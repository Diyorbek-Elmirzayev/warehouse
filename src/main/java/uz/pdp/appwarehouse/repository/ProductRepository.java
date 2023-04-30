package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    boolean existsByNameAndCategoryId(String name, Integer category_id);
}
