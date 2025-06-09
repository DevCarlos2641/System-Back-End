package com.carlos2641.system.infrastructure.in.dto;
import lombok.Data;
import java.util.List;

@Data
public class RememberResponse {
    private List<ArticlePreviewResponse> articles;
    private List<ClientDTO> clients;
}
