package com.carlos2641.system.infrastructure.out.persistence.article;

import com.carlos2641.system.infrastructure.in.dto.ArticlePreviewResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ArticleJpaRepository extends JpaRepository<ArticleEntity, String> {

    @Query("SELECT NEW com.carlos2641.system.infrastructure.in.dto.ArticlePreviewResponse(a.primaryK, a.secondary, a.name, a.stock, a.price) FROM articulo a")
    List<ArticlePreviewResponse> findAllPreview();

}
