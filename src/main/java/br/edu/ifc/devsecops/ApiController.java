package br.edu.ifc.devsecops;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ApiController {

    private static final Logger logger =
            LoggerFactory.getLogger(ApiController.class);

    @GetMapping("/api/hello")
    public Map<String, String> hello() {

        logger.info("Endpoint /api/hello executado");

        return Map.of(
                "message",
                "Projeto DevSecOps funcionando!"
        );
    }

    @GetMapping("/api/success")
    public ResponseEntity<String> success() {

        logger.info("Requisicao com sucesso");

        return ResponseEntity.ok("SUCCESS");
    }

    @GetMapping("/api/bad-request")
    public ResponseEntity<String> badRequest() {

        logger.warn("Bad request gerado");

        return ResponseEntity.badRequest().body("BAD REQUEST");
    }

    @GetMapping("/api/error")
    public ResponseEntity<String> error() {

        logger.error("Erro proposital para monitoramento");

        return ResponseEntity.internalServerError().body("ERROR");
    }
}
