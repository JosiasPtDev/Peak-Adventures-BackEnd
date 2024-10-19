package org.josiasptdev.backend.service;


import org.apache.coyote.Response;
import org.josiasptdev.backend.entity.Usuarios;
import org.josiasptdev.backend.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }



    public List<Usuarios> ObtenerUsuarios(){
        return usuariosRepository.findAll();
    }

    public ResponseEntity<Usuarios> CrearUsuario(Usuarios usuario){
        usuariosRepository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    public ResponseEntity<Usuarios> EditarUsuario(Long id, Usuarios usuarioActualizado) {
        Optional<Usuarios> usuarioExistenteOpt = usuariosRepository.findById(id);

        if (usuarioExistenteOpt.isPresent()) {

            Usuarios usuarioExistente = usuarioExistenteOpt.get();

            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setApellido(usuarioActualizado.getApellido());
            usuarioExistente.setEmail(usuarioActualizado.getEmail());
            usuarioExistente.setTelefono(usuarioActualizado.getTelefono());
            usuarioExistente.setCorreo(usuarioActualizado.getCorreo());
            usuarioExistente.setPassword(usuarioActualizado.getPassword());
            usuarioExistente.setDni(usuarioActualizado.getDni());
            usuarioExistente.setSexo(usuarioActualizado.getSexo());

            usuariosRepository.save(usuarioExistente);
            return ResponseEntity.ok(usuarioExistente);
        }
        return ResponseEntity.notFound().build();
    }


    public void EliminarUsuario(Long id){
        usuariosRepository.deleteById(id);
    }

}
