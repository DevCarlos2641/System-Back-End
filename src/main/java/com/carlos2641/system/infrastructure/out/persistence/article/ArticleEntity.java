package com.carlos2641.system.infrastructure.out.persistence.article;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "articulo")
public class ArticleEntity {

    @Id
    @Column(length = 20)
    private String primaryK;

    @Column(length = 20)
    private String secondary;

    @Column(length = 100)
    private String name;

    @Column(nullable = false)
    private int stock;

    @Column(length = 20)
    private String udm;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private int pieces;

    @Column(length = 20)
    private String brand;

    @Column(nullable = false)
    private boolean bulk;
}
