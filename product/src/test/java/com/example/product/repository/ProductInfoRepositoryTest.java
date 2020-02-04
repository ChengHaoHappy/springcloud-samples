package com.example.product.repository;

import com.example.product.dataobject.ProductInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created By ChengHao On 2020/2/4
 */
@SpringBootTest
class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus(){
        List<ProductInfo> list = productInfoRepository.findByProductStatus(0);
        System.out.println(list);
    }
}