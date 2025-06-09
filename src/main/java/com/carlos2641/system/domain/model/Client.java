package com.carlos2641.system.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Client {
    private Long id_client;
    private String name;
    private String rfc;
    private String regimen;
    private String legal_name;
    private String address;
    private int cp;
    private String email;
    private String tel;
}
