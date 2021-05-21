package com.example.model.service;




import com.example.model.entity.ProductModel;
import com.example.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepositoryParentBackend;


    public ProductModel addProductModel(ProductModel productModel){
        return productRepositoryParentBackend.save(productModel);
    }

    public List<ProductModel> getAllProducts(){
        return (List<ProductModel>) productRepositoryParentBackend.findAll();
    }

    public ProductModel updateProduct(ProductModel productModel){
        return productRepositoryParentBackend.save(productModel);
    }

    public void deleteProduct(Long id){
        productRepositoryParentBackend.deleteEmployeeById(id);
    }

}
