package com.example.graalvm.springbootgraalvm.service.impl;

import com.example.graalvm.springbootgraalvm.domain.Invoice;
import com.example.graalvm.springbootgraalvm.repository.InvoiceRepository;
import com.example.graalvm.springbootgraalvm.service.IInvoiceService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class InvoiceServiceImpl implements IInvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Flux<Invoice> getAllInvoices() {
        return Flux.fromIterable(invoiceRepository.findAll());
    }
}