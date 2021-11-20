package br.com.uvass.desafiosb.model.repository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNaoEncontrado extends RuntimeException{
    public  ProductNaoEncontrado() {
        super("produto não encontrado!");
    }
}

