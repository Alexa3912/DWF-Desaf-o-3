package sv.edu.udb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import sv.edu.udb.model.Usuario;
import sv.edu.udb.repository.UsuarioRepository;

@SpringBootApplication
public class JwtbasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtbasicApplication.class, args);
    }


}
