package com.example.product.client.impl;

import com.example.product.client.ProductClient;
import com.example.product.common.DecreaseStockInput;
import com.example.product.common.ProductInfoOutput;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created By ChengHao On 2020/2/12
 */
@Component
public class ProductClientFallback implements ProductClient {
    @Override
    public List<ProductInfoOutput> listForOrder(List<String> productIdList) {
        return null;
    }

    @Override
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {

    }

    @Override
    public String getProductMsgByFeign() {
        return null;
    }
}
