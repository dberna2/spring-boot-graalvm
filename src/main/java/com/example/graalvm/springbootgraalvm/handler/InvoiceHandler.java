package com.example.graalvm.springbootgraalvm.handler;

import com.example.graalvm.springbootgraalvm.domain.Invoice;
import com.example.graalvm.springbootgraalvm.service.IInvoiceService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class InvoiceHandler {

    private final IInvoiceService invoiceService;

    public InvoiceHandler(IInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public Mono<ServerResponse> getAllInvoices(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(invoiceService.getAllInvoices(), Invoice.class);
    }

    public Mono<ServerResponse> getInvoiceById(ServerRequest request) {
        Long invoiceId = Long.parseLong(request.pathVariable("id"));
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(invoiceService.getInvoiceById(invoiceId), Invoice.class);

    }
}
