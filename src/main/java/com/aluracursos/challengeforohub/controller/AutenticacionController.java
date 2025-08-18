package com.aluracursos.challengeforohub.controller;

import com.aluracursos.challengeforohub.domain.usuario.DatosAutenticacion;
import com.aluracursos.challengeforohub.domain.usuario.Usuario;
import com.aluracursos.challengeforohub.infra.security.DatosTokenJwt;
import com.aluracursos.challengeforohub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAutenticacion datos){
        var autenticationtoken = new UsernamePasswordAuthenticationToken(datos.login(), datos.contrasena());
        var autenticacion =manager.authenticate(autenticationtoken);

        var tokenJWT =tokenService.generarToken((Usuario) autenticacion.getPrincipal());
        return ResponseEntity.ok(new DatosTokenJwt(tokenJWT));
    }
}
