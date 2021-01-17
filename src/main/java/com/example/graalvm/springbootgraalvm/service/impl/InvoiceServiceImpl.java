package com.example.graalvm.springbootgraalvm.service.impl;

import com.example.graalvm.springbootgraalvm.domain.Invoice;
import com.example.graalvm.springbootgraalvm.repository.InvoiceRepository;
import com.example.graalvm.springbootgraalvm.service.IInvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
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

    @Override
    public Mono<Invoice> getInvoiceById(Long id) {
        return invoiceRepository.findById(id)
                .map(Mono::just).orElse(Mono.empty());
    }
}
