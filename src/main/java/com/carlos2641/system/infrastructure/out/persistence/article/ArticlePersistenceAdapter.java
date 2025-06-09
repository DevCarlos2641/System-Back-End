package com.carlos2641.system.infrastructure.out.persistence.article;

import com.carlos2641.system.domain.model.Article;
import com.carlos2641.system.domain.port.out.ArticleRepositoryPort;
import com.carlos2641.system.infrastructure.in.dto.ArticlePreviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ArticlePersistenceAdapter implements ArticleRepositoryPort {

    private final ArticleJpaRepository jpaRepository;

    @Override
    public List<ArticlePreviewResponse> findAll() {
        return jpaRepository.findAllPreview();
    }
}
