package com.example.graalvm.springbootgraalvm.service;

import com.example.graalvm.springbootgraalvm.domain.Invoice;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IInvoiceService {

    Flux<Invoice> getAllInvoices();

    Mono<Invoice> getInvoiceById(Long id);

}
