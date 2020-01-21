package com.wlima.minhasfinancas.model.repository;

import com.wlima.minhasfinancas.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

//    Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(String email);
}
