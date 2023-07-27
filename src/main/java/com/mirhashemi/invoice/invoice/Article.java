package com.mirhashemi.invoice.invoice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer unitPrice;
    private Integer sumPrice;
    private Integer allPrice;
    @JsonIgnore
//    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "invoice_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Invoice invoice;


}
