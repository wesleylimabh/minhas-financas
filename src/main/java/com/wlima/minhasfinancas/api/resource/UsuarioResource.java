package com.wlima.minhasfinancas.api.resource;

import com.wlima.minhasfinancas.api.dto.UsuarioDTO;
import com.wlima.minhasfinancas.exception.ErroAutenticacao;
import com.wlima.minhasfinancas.exception.RegraNegocioExcepetion;
import com.wlima.minhasfinancas.model.entity.Usuario;
import com.wlima.minhasfinancas.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

    private UsuarioService service;

    public UsuarioResource(UsuarioService service){
        this.service = service;
    }

    @PostMapping("/autenticar")
    public ResponseEntity autenticar(@RequestBody UsuarioDTO dto) {
        try{
            Usuario usuarioAutenticado = service.autenticar(dto.getEmail(), dto.getSenha());
            return ResponseEntity.ok(usuarioAutenticado);
        }catch (ErroAutenticacao e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody UsuarioDTO dto){
        Usuario usuario = Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha()).build();

        try {
            Usuario usuarioSalvo = service.salvarUsuario(usuario);
            return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);
        } catch (RegraNegocioExcepetion ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
