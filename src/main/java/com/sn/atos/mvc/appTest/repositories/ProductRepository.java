package com.sn.atos.mvc.appTest.repositories;

import com.sn.atos.mvc.appTest.entities.Product;
import org.hibernate.exception.spi.SQLExceptionConverter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByName(String name);

    @Query(value="SELECT * FROM PRODUCT WHERE name=:name", nativeQuery = true)
    List<Product> findByNameQuery(String name);

    @Query("SELECT p FROM Product p WHERE p.name=:name")
    List<Product> findByNameJpql(String name);

    @Transactional()
    List<Product> findByIdGreaterThan(long id);

}
