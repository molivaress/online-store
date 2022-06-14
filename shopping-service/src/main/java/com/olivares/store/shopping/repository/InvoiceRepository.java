package com.olivares.store.shopping.repository;

import com.olivares.store.shopping.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    public List<Invoice> findByCustomerId(Long customerId);

    public Invoice findByNumberInvoice(String numberInvoice);
}
