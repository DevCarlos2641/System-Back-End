package com.carlos2641.system.application.service;

import com.carlos2641.system.domain.model.Article;
import com.carlos2641.system.domain.model.User;
import com.carlos2641.system.domain.port.in.ArticleUseCase;
import com.carlos2641.system.domain.port.in.UserUseCase;
import com.carlos2641.system.domain.port.out.ArticleRepositoryPort;
import com.carlos2641.system.domain.port.out.UserRepositoryPort;
import com.carlos2641.system.infrastructure.in.dto.ArticlePreviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService implements ArticleUseCase {

    private final ArticleRepositoryPort repositoryPort;

    @Override
    public List<ArticlePreviewResponse> findAll() {
        return repositoryPort.findAll();
    }
}
