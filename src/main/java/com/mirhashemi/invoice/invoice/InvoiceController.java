package com.mirhashemi.invoice.invoice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoice")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService service;

    @PostMapping("/register")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> register(@RequestBody Invoice invoice) {
        service.registerInvoice(invoice);
        return ResponseEntity.ok("invoice saved successfully!");

    }
    @GetMapping("/{invoiceNumber}")
    @PreAuthorize("hasRole('USER')")
    public  ResponseEntity<Invoice> userAccess(@PathVariable("invoiceNumber") String invoiceNumber) throws Exception {

        return ResponseEntity.ok(service.findByInvoiceNumber(invoiceNumber));
    }

}
