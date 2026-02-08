package com.crudUser.demo.dto.Response;

import com.crudUser.demo.model.Usuario.Usuario;

import java.util.Collection;
import java.util.List;

public class UsuariosResponseDTO {
    List<UsuarioResponseDTO> usuarios;

    public UsuariosResponseDTO(Collection<Usuario> usuarios) {
         this.usuarios = usuarios.stream()
                 .map(UsuarioResponseDTO::new)
                 .toList();
    }

    public List<UsuarioResponseDTO> getUsuarios() { return usuarios; }
    public void setUsuarios(List<UsuarioResponseDTO> usuarios) { this.usuarios = usuarios; }
}
