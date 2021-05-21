package com.example.model.repository;

import com.example.model.entity.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel,Long> {
    Optional<ProductModel> findProductById(Long id);

    void deleteEmployeeById(Long id);
}
