package com.springboot.SpringJPA.service;

import com.springboot.SpringJPA.dto.ProductDto;
import com.springboot.SpringJPA.entity.ProductEntity;
import com.springboot.SpringJPA.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService
{
    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    public ProductDto createProduct(ProductDto productDto)
    {
        ProductEntity productEntity=mapper.map(productDto,ProductEntity.class);
        ProductEntity savedProduct=productRepository.save(productEntity);
        return mapper.map(savedProduct,ProductDto.class);
    }

    public List<ProductDto> findAll()
    {
        List<ProductEntity> productList=productRepository.findAll();
        List<ProductDto> productDtos=productList.stream().map(productdto->mapper.map(productdto,ProductDto.class)).toList();
        return productDtos;
    }

    public List<ProductDto> fetchListOfProductByTitle(String title)
    {
        List<ProductEntity> productEntities=productRepository.findByTitle(title);
        List<ProductDto> productDtos=productEntities.stream().map(entity->mapper.map(entity,ProductDto.class)).toList();
        return productDtos;
    }

    public List<ProductDto> fetchProductByPrice(BigDecimal price)
    {
        List<ProductEntity> productEntities=productRepository.findByPrice(price);
        List<ProductDto> productDtos=productEntities.stream().map(entity->mapper.map(entity,ProductDto.class)).toList();
        return productDtos;
    }

    public List<ProductDto> fetchProduceByPriceGreter(BigDecimal price){
        List<ProductEntity> productEntities=productRepository.findByPriceGreaterThan(price);
        List<ProductDto> productDtos=productEntities.stream().map(entity->mapper.map(entity,ProductDto.class)).toList();
        return productDtos;
    }
    public List<ProductDto> fetchPoductByQuantiyGreater(Integer quant)
    {
        List<ProductEntity> productEntities=productRepository.findByQuantityGreaterThan(quant);
        List<ProductDto> productDtos=productEntities.stream().map(entity->mapper.map(entity,ProductDto.class)).toList();
        return productDtos;
    }
    public List<ProductDto> fetchProductLessThanQuantity(Integer quant)
    {
        List<ProductEntity> productEntities=productRepository.findByQuantityLessThan(quant);
        List<ProductDto> productDtos=productEntities.stream().map(entity->mapper.map(entity,ProductDto.class)).toList();
        return productDtos;
    }
    public List<ProductDto> fetchProductGreaterAndEqueal(Integer qty)
    {
        List<ProductEntity> productEntities=productRepository.findByQuantityGreaterThanEqual(qty);
        List<ProductDto> productDtos=productEntities.stream().map(entity->mapper.map(entity,ProductDto.class)).toList();
        return productDtos;
    }

}
