package com.wlima.minhasfinancas.service.impl;

import com.wlima.minhasfinancas.exception.RegraNegocioExcepetion;
import com.wlima.minhasfinancas.model.entity.Usuario;
import com.wlima.minhasfinancas.model.repository.UsuarioRepository;
import com.wlima.minhasfinancas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    private UsuarioRepository repository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        return null;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public void validarEmail(String email) {
        boolean existe = repository.existsByEmail(email);
        if(existe){
            throw new RegraNegocioExcepetion("Já existe um usuário cadastrado com este email");
        }

    }
}
