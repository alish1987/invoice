package com.mirhashemi.invoice.invoice;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invoice",uniqueConstraints={@UniqueConstraint(columnNames={"invoiceNumber"})})
public class Invoice {
    @Id
    @GeneratedValue
    private Integer id;
    private String invoiceNumber;
    private String companyName;
    private Date invoiceDate;
    private Integer sellerTel;
    private String sellerUnit;
    private String sellerDesc;
    private String sellerName;
//    @OneToMany(mappedBy = "invoice")
    @OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Article> articles;


}
