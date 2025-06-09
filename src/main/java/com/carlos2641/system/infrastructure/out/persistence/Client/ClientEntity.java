package com.carlos2641.system.infrastructure.out.persistence.Client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_client;

    @Column(length = 40)
    private String name;

    @Column(length = 20)
    private String rfc;

    @Column(length = 50)
    private String regimen;

    @Column(length = 40)
    private String legal_name;

    @Column(length = 40)
    private String address;

    private int cp;

    @Column(length = 40)
    private String email;

    @Column(length = 12)
    private String tel;
}
