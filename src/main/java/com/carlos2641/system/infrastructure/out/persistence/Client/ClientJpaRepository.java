package com.carlos2641.system.infrastructure.out.persistence.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientJpaRepository extends JpaRepository<ClientEntity, Long> {

    @Query("""
        SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END
        FROM ClientEntity c
        WHERE (c.email = :email OR c.rfc = :rfc OR c.tel = :tel)
        AND c.id_client <> :id
    """)
    boolean existsByEmailOrRfcOrTel(
            @Param("email") String email,
            @Param("rfc") String rfc,
            @Param("tel") String tel,
            @Param("id") Long id
    );

    @Query("""
        SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END
        FROM ClientEntity c
        WHERE (c.email = :email OR c.rfc = :rfc OR c.tel = :tel)
    """)
    boolean existsByEmailOrRfcOrTel(
            @Param("email") String email,
            @Param("rfc") String rfc,
            @Param("tel") String tel
    );

}
