package org.josiasptdev.backend.controller;


import org.josiasptdev.backend.entity.Usuarios;
import org.josiasptdev.backend.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    public UsuariosService usuariosService;


    @GetMapping
    public List<Usuarios> ObtenerUsuarios() {
        return usuariosService.ObtenerUsuarios();
    }

    @PostMapping()
    public Usuarios CrearUsuario(@RequestBody Usuarios usuario) {
        usuariosService.CrearUsuario(usuario);
        return usuario;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> ActualizarUsuario(@PathVariable Long id, @RequestBody Usuarios usuario) {
        return usuariosService.EditarUsuario(id, usuario);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Usuarios> eliminarUsuario(@PathVariable Long id) {
        usuariosService.EliminarUsuario(id);
        return ResponseEntity.ok().build();
    }



}
