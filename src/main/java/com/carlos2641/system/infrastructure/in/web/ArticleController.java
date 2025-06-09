package com.carlos2641.system.infrastructure.in.web;

import com.carlos2641.system.application.service.ArticleService;
import com.carlos2641.system.infrastructure.in.dto.ArticlePreviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService service;

    @GetMapping("/all")
    private ResponseEntity<?> getAll(){
        return ResponseEntity.ok(
                service.findAll().stream()
                        .map(article ->
                                new ArticlePreviewResponse(
                                    article.getPrimaryK(),
                                    article.getSecondary(),
                                    article.getName(),
                                    article.getStock(),
                                    article.getPrice()
                                )
                        ).toList()
        );
    }

//    @GetMapping("/allPreview")
//    private ResponseEntity<?> getAllPreview(){
//        return service.getAllPreview();
//    }

}
