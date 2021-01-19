package com.example.graalvm.springbootgraalvm.service;

import com.example.graalvm.springbootgraalvm.domain.Invoice;
import reactor.core.publisher.Flux;

public interface IInvoiceService {

    Flux<Invoice> getAllInvoices();
}
