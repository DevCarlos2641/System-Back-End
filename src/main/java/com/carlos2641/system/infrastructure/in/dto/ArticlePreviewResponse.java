package com.carlos2641.system.infrastructure.in.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticlePreviewResponse {

    private String primaryK;
    private String secondary;
    private String name;
    private int stock;
    private float price;
}
