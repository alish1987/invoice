package com.mirhashemi.invoice.invoice;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceService {
  private final InvoiceRepository repository;
  private final ArticleRepository articleRepository;

  @Transactional
  public Invoice registerInvoice(Invoice invoice) {

    var savedUser = repository.save(invoice);
    for (Article article : invoice.getArticles()) {
      article.setInvoice(savedUser);
      articleRepository.save(article);
    }
    return savedUser;
  }


  public Invoice findByInvoiceNumber(String invoiceNumber) throws Exception {
    var invoice = repository.findByInvoiceNumber(invoiceNumber)
            .orElseThrow(() -> new Exception("Not found Invoice with invoiceNumber = " + invoiceNumber));
    return invoice;
  }


}
