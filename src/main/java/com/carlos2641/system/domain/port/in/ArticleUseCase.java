package com.carlos2641.system.domain.port.in;

import com.carlos2641.system.infrastructure.in.dto.ArticlePreviewResponse;

import java.util.List;

public interface ArticleUseCase {
    List<ArticlePreviewResponse> findAll();
}
