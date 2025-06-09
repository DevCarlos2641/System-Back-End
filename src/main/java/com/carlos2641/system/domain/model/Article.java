package com.carlos2641.system.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
public class Article {
    private String primaryK;
    private String secondary;
    private String name;
    private int stock;
    private String udm;
    private float price;
    private int pieces;
    private String brand;
    private boolean bulk;
}
