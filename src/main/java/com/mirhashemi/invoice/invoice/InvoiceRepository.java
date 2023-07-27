package com.mirhashemi.invoice.invoice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {


  Optional<Invoice> findByInvoiceNumber(String invoiceNumber);

}
