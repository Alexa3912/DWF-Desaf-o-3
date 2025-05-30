package sv.edu.udb.config;


import java.io.IOException;
import java.util.Map;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


import lombok.RequiredArgsConstructor;


import sv.edu.udb.model.Usuario;
import sv.edu.udb.repository.UsuarioRepository;
import sv.edu.udb.service.JwtService;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        DefaultOAuth2User oauthUser = (DefaultOAuth2User) authentication.getPrincipal();
        Map<String, Object> attributes = oauthUser.getAttributes();

        final String email = (String) attributes.get("email");
        final String nombre = (String) attributes.get("name");
        final String safeEmail = (email != null) ? email : oauthUser.getName() + "@github.com";

        Usuario usuario = usuarioRepository.findByEmail(safeEmail)
                .orElseGet(() -> {
                    Usuario nuevo = new Usuario();
                    nuevo.setNombre(nombre != null ? nombre : "GitHubUser");
                    nuevo.setEmail(safeEmail);
                    nuevo.setPassword(new BCryptPasswordEncoder().encode("oauth2user"));
                    nuevo.setRol("USER");
                    nuevo.setRegistradoPorGithub(true);
                    return usuarioRepository.save(nuevo);
                });

        String token = jwtService.generateToken(usuario);

        response.sendRedirect("/oauth2/success?token=" + token);
    }
}
