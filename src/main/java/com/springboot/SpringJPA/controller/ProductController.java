package com.springboot.SpringJPA.controller;

import com.springboot.SpringJPA.dto.ProductDto;
import com.springboot.SpringJPA.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController
{
      private final ProductService productService;

      @PostMapping("/createProduct")
      public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto)
      {
          return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
      }

      @GetMapping("/findAllProduct")
      public ResponseEntity<List<ProductDto>> findAll()
      {
          return ResponseEntity.ok(productService.findAll());
      }

      @GetMapping("/findByTitle/{title}")
      public ResponseEntity<List<ProductDto>> findProductByTitle(@PathVariable  String title)
      {
          return ResponseEntity.ok(productService.fetchListOfProductByTitle(title));
      }

    @GetMapping("/findByPrice/{price}")
    public ResponseEntity<List<ProductDto>> findProductByPrice(@PathVariable  BigDecimal price)
    {
        return ResponseEntity.ok(productService.fetchProductByPrice(price));
    }

    @GetMapping("/findByPriceGreter/{price}")
    public ResponseEntity<List<ProductDto>> findProductByPriceGreter(@PathVariable  BigDecimal price)
    {
        return ResponseEntity.ok(productService.fetchProduceByPriceGreter(price));
    }

    @GetMapping("/findByQuantityGreater/{quantity}")
    public ResponseEntity<List<ProductDto>> findProductByQuantityGreater(@PathVariable  Integer quantity)
    {
        return ResponseEntity.ok(productService.fetchPoductByQuantiyGreater(quantity));
    }

    @GetMapping("/findByQuantityLess/{quantity}")
    public ResponseEntity<List<ProductDto>> findProductByQuantityLess(@PathVariable("quantity")  Integer qty)
    {
        return ResponseEntity.ok(productService.fetchProductLessThanQuantity(qty));
    }

    @GetMapping("/findByQuantityGreaterAndEqual/{quantity}")
    public ResponseEntity<List<ProductDto>> findProductByQuantityGreaterAndEqual(@PathVariable("quantity")  Integer qty)
    {
        return ResponseEntity.ok(productService.fetchProductGreaterAndEqueal(qty));
    }

}
