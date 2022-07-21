package com.sirius.gateway.handler;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sirius.common.utils.ServletUtil;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

/**
 *  自定义限流异常
 */
public class SentinelFallbackHandler implements WebExceptionHandler {
    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        if (exchange.getResponse().isCommitted()){
            return Mono.error(ex);
        }
        if (!BlockException.isBlockException(ex)){
            return Mono.error(ex);
        }
        return serverResponseMono(exchange, ex).flatMap(serverResponse -> writeResponse(serverResponse,exchange));
    }

    private Mono<ServerResponse> serverResponseMono(ServerWebExchange exchange,Throwable throwable){
        return GatewayCallbackManager.getBlockHandler().handleRequest(exchange,throwable);
    }

    private Mono<Void> writeResponse(ServerResponse response, ServerWebExchange exchange)
    {
        return ServletUtil.webFluxResponseWriter(exchange.getResponse(), "请求超过最大数，请稍候再试");
    }
}
