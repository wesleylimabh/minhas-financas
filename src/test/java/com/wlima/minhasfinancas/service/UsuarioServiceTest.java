package com.wlima.minhasfinancas.service;

import com.wlima.minhasfinancas.exception.RegraNegocioExcepetion;
import com.wlima.minhasfinancas.model.entity.Usuario;
import com.wlima.minhasfinancas.model.repository.UsuarioRepository;
import com.wlima.minhasfinancas.service.impl.UsuarioServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {

    UsuarioService service;
    UsuarioRepository repository;

    @Before
    public void setUp(){
        repository = Mockito.mock(UsuarioRepository.class);
        service = new UsuarioServiceImpl(repository);
    }

    @Test(expected = Test.None.class)
    public void deveValidarEmail(){
        //cenario
        Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(false);

        //acao
        service.validarEmail("usuario@email.com");

    }

    @Test(expected = RegraNegocioExcepetion.class)
    public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado(){
        //cenario
        Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(true);

        //acao
        service.validarEmail("usuario@email.com");
    }

}