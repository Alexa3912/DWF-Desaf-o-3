package sv.edu.udb.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth2")
public class OAuth2Controller {

    @GetMapping("/success")
    public String showToken(@RequestParam String token) {
        return "Tu token de acceso es: " + token;
    }
}
