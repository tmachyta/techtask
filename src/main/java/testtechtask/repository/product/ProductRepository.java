package testtechtask.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testtechtask.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
