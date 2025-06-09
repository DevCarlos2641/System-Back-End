package com.carlos2641.system.infrastructure.in.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDTO {

    private Long id_client;

    @NotBlank(message = "Names is required")
    private String name;

    @NotBlank(message = "RFC is required")
    private String rfc;

    @NotBlank(message = "Regimen is required")
    private String regimen;

    @NotBlank(message = "Legal name is required")
    private String legal_name;

    @NotBlank(message = "Address is required")
    private String address;

    @NotNull
    private int cp;

    @Email(message = "Email invalid")
    private String email;

    @Size(min = 10, max = 13, message = "Telephone incorrect")
    private String tel;
}
