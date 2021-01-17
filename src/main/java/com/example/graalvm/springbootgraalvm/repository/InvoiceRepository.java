package com.example.graalvm.springbootgraalvm.repository;

import com.example.graalvm.springbootgraalvm.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
