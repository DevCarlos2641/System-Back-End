package com.carlos2641.system.domain.port.out;


import com.carlos2641.system.infrastructure.in.dto.ArticlePreviewResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ArticleRepositoryPort {
    List<ArticlePreviewResponse> findAll();

}
