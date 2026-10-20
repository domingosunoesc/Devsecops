package br.edu.ifc.devsecops;

import br.edu.ifc.devsecops.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class ApiController {

    private static final Logger logger =
            LoggerFactory.getLogger(ApiController.class);

    private final List<Book> books = new ArrayList<>();

    public ApiController() {
        books.add(new Book(
                1L,
                "Clean Code",
                "Robert Martin",
                "Programacao"));

        books.add(new Book(
                2L,
                "Spring in Action",
                "Craig Walls",
                "Java"));
    }

    @GetMapping
    public List<Book> findAll() {

        logger.info("Listagem de livros realizada");

        return books;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(
            @PathVariable Long id) {

        logger.info("Consulta livro {}", id);

        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> {

                    logger.warn(
                      "Livro {} nao encontrado", id);

                    return ResponseEntity.notFound()
                            .build();
                });
    }

    @PostMapping
    public ResponseEntity<Book> create(
            @RequestBody Book book) {

        books.add(book);

        logger.info(
          "Livro cadastrado: {}",
          book.getTitulo());

        return ResponseEntity.ok(book);
    }

    @GetMapping("/error")
    public ResponseEntity<String> simulateError() {

        logger.error(
          "Erro proposital biblioteca");

        return ResponseEntity.internalServerError()
                .body("ERRO");
    }
}
