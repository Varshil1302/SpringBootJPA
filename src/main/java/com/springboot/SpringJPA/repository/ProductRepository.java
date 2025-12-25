package com.springboot.SpringJPA.repository;

import com.springboot.SpringJPA.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long>
{
      List<ProductEntity> findByTitle(String title);
      List<ProductEntity> findByPrice(BigDecimal price);
      List<ProductEntity> findByPriceGreaterThan(BigDecimal price);
      List<ProductEntity> findByQuantityGreaterThan(Integer quantity);
      List<ProductEntity> findByQuantityLessThan(Integer quantity);
      List<ProductEntity> findByQuantityGreaterThanEqual(Integer quantity);
}
