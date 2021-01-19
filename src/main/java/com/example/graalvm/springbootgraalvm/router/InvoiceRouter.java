package com.example.graalvm.springbootgraalvm.router;

import com.example.graalvm.springbootgraalvm.handler.InvoiceHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
public class InvoiceRouter {

    @Bean
    public RouterFunction<ServerResponse> routeFunction(InvoiceHandler invoiceHandler) {
        return route(
                GET("/invoice").and(accept(TEXT_PLAIN)), invoiceHandler::getAllInvoices
        );
    }
}