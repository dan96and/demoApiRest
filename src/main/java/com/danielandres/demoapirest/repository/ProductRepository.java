package com.danielandres.demoapirest.repository;

import com.danielandres.demoapirest.domain.Product;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Set<Product> findAllByVisible(boolean visible);

    Set<Product> findAllByCategory(String category);

    @Modifying
    @Query("update Product p set p.name =:name where p.id = :id")
    void updateProductName(@Param(value = "id") long id, @Param(value = "name") String name);


}
