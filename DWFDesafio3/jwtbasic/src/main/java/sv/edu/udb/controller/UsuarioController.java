package sv.edu.udb.controller;


import java.security.Principal;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import sv.edu.udb.model.Usuario;
import sv.edu.udb.repository.UsuarioRepository;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;


    @GetMapping("/perfil")
    @PreAuthorize("hasRole('USER')")
    public Usuario getPerfil(Principal principal) {
        return usuarioRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
