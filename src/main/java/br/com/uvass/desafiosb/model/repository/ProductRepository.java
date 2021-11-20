package br.com.uvass.desafiosb.model.repository;
import br.com.uvass.desafiosb.model.entity.Installments;
import br.com.uvass.desafiosb.model.entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class ProductRepository {

    private JdbcTemplate jdbcTemplate;
    private InstallmentsRepository installmentsRepository;

    public ProductRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        this.installmentsRepository = new InstallmentsRepository(jdbcTemplate);
    }

    public List<Product> buscarProduct() {
        String sql = "select * from product";

        List<Product> listProduct = jdbcTemplate.query(sql, new ProductMapper());

        listProduct.forEach(product -> {
            Installments installments = installmentsRepository.buscarInstallments(product.getInstallments_id());
            product.setInstallments(installments);
        });

        return listProduct;
    }
}
