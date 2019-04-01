package com.example.repository;

import com.example.repository.model.Product;
import com.example.repository.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RepositoryApplication implements CommandLineRunner {

    private ProductRepository productRepository;

    private Logger LOG = LoggerFactory.getLogger(RepositoryApplication.class);

    @Autowired
    public void productRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(RepositoryApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        Product product1 = new Product();
        product1.setName("Tester Product");
        product1.setDescription("This is a tester product");
        product1.setCategory("TEST");
        product1.setType("GENERAL");
        product1.setPrice(0.0);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Another Tester Product");
        product2.setDescription("This is a tester product");
        product2.setCategory("TEST");
        product2.setType("CUSTOM");
        product2.setPrice(15.0);
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setName("Tester Product");
        product3.setDescription("description");
        product3.setCategory("USUAL");
        product3.setType("SPECIFIC");
        product3.setPrice(19.0);
        productRepository.save(product3);

        Product productToUpdate = productRepository.findByType("SPECIFIC");
        LOG.info("Before updating product details:{}", productToUpdate);
        if (productToUpdate != null) {
            productToUpdate.setName("Updated Product");
            productToUpdate.setDescription("Updated description");

            Product updated = productRepository.save(productToUpdate);
            LOG.info("Updated product details:{}", updated);
        }

//        List<Product> products = productRepository.findAll();
//
//        for (Product product : products) {
//            LOG.info("Products found:" + product.toString());
//        }
//
//        Product resultProduct = productRepository.findByType("CUSTOM");
//
//        LOG.info("GENERAL type of product found:" + resultProduct.toString());

//        List<Product> products = productRepository.findByDescriptionAndCategory("This is a tester product", "TEST");
//
//        for (Product product : products) {
//            LOG.info("DescriptionAndCategory Products found: {}", product);
//        }

//        List<String> names = new ArrayList<>();
//        names.add("Tester Product");
////        names.add("Another Tester Product");
//
//        List<Product> catAndNameProducts = productRepository.findByCategoryAndNameIn("TEST", names);
//        for (Product catAndNameProduct : catAndNameProducts) {
//            LOG.info("CategoryAndName Product: {}", catAndNameProduct);
//        }
    }
}
