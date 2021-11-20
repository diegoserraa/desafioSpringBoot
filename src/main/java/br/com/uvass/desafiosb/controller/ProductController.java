package br.com.uvass.desafiosb.controller;
import br.com.uvass.desafiosb.model.entity.Product;
import br.com.uvass.desafiosb.model.repository.ProductNaoEncontrado;
import br.com.uvass.desafiosb.model.repository.ProductRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(JdbcTemplate jdbcTemplate) {

        productRepository = new ProductRepository(jdbcTemplate);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Product> buscarProduct(){
        try {
            return productRepository.buscarProduct();
        }
        catch (EmptyResultDataAccessException e) {
            throw new ProductNaoEncontrado();
        }
    }
}
