package com.wlima.minhasfinancas.service;

import com.wlima.minhasfinancas.exception.RegraNegocioExcepetion;
import com.wlima.minhasfinancas.model.entity.Usuario;
import com.wlima.minhasfinancas.model.repository.UsuarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {

    @Autowired
    UsuarioService service;

    @Autowired
    UsuarioRepository repository;

    @Test(expected = Test.None.class)
    public void deveValidarEmail(){
        //cenario
        repository.deleteAll();

        //acao
        service.validarEmail("usuario@email.com");

    }

    @Test(expected = RegraNegocioExcepetion.class)
    public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado(){
        //cenario
        Usuario usuario = Usuario.builder().nome("usuario").email("usuario@email.com").build();
        repository.save(usuario);

        //acao
        service.validarEmail("usuario@email.com");
    }

}