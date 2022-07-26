package com.linx.shorklink.handler;

import com.linx.shorklink.model.po.UrlMap;
import com.linx.shorklink.model.request.CreateShortlinkRequest;
import com.linx.shorklink.repository.UrlMapRepository;
import com.linx.shorklink.service.ShortlinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.net.URI;

/**
 * 1
 *
 * @author linx
 * @since 2022/7/10 下午10:32
 */
@Component
public class ShortlinkHandler {
    private final ShortlinkService shortlinkService;
    private final UrlMapRepository urlMapRepository;

    public ShortlinkHandler(ShortlinkService shortlinkService, UrlMapRepository urlMapRepository) {
        this.shortlinkService = shortlinkService;
        this.urlMapRepository = urlMapRepository;
    }

    /**
     * 创将短连接
     *
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> create(ServerRequest serverRequest) {
        //todo 这里还得研究一下CreateShortlinkRequest的参数验证怎么做
        //Mono<CreateShortlinkRequest> body = serverRequest.bodyToMono(CreateShortlinkRequest.class);
        //body.subscribe(ShortlinkHandler::println);
        Mono<UrlMap> map = serverRequest.bodyToMono(CreateShortlinkRequest.class).publishOn(Schedulers.parallel()).map(shortlinkService::defaultCreate);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(map, Boolean.class);

    }

    /**
     * 访问短连接
     *
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> access(ServerRequest serverRequest) {
        String compressionCode = serverRequest.pathVariable("compressionCode");

        Mono<String> byCompressionCode = urlMapRepository.findByCompressionCode(compressionCode);
        //String block = byCompressionCode.block();这里直接使用 Mono 对象上调用 block()  会阻塞，只要发布者不再推送数据，可以执行block方法获取Mono里面的值 ，但是再推送就会异常
        //todo 这里还需要研究一下 这样是阻塞的
        String block = byCompressionCode.toProcessor().block();//这样获取字符串可以避免报错
        //临时重定向:
        // 302:HTTP/1.0的规范(发布于1996年)中，临时重定向的状态码仅包含302，尽管规范指定不允许客户端更改重定向请求的请求方法，然而大部分浏览器却忽略这个规定，在重定向后的新请求上使用GET请求，这就是HTTP/1.1(发行与1999年)中引进303和307状态码的原因，以使客户端可以明确的知道如何实现
        return ServerResponse.status(HttpStatus.FOUND).location(URI.create(block)).build();
        // 303:HTTP状态码 303(“See Other”) 告诉客户端临时被移动至新地址，并且明确告诉客户端在新URL上使用GET请求，不管原请求使用的是什么方法
        // 307:HTTP状态码 307(“Temporary Redirect”)规定了客户端用另一个URL重新发起请求，且使用的方法和原方法一样。例如当使用POST方法发起请求时，重定向后发起的仍然是POST请求
        //永久重定向:
        // 301:301 和 308的不同之处在于，当接收到308的响应时，客户端必须在新地址上重复同样的请求，而301重定向会改变请求的方法，将POST方法改变成GET方法来请求新地址
        // 308:308状态码有个问题是它相对较新(2015年4月在RFC 7538中引入)，因此并非所有的浏览器和爬虫器都支持，例如在Windows 7 和 Windows 8 的 IE11上是无法理解308的，只会展示一个空页面而不是重定向

        //这里我采用307
        //return ServerResponse.temporaryRedirect(URI.create(redirectUrl)).body(flux, String.class);
        //return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(flux,String.class);
    }

    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
       // Flux<UrlMap> all = urlMapRepository.findAll();
        Flux<UrlMap> all = urlMapRepository.findByShortUrl("11");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(all, UrlMap.class);
    }

    private static void println(Object o) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[ 线程: " + threadName + " ] " + o);
    }
}
