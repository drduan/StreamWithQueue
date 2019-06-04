package com.example.demobus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    protected Logger logger = LoggerFactory.getLogger(ProductService.class);
    private Source source;
    private List<String> productList;

    @Autowired
    public ProductService(Source source) {
        this.source = source;
        this.productList = this.buildProducts();
    }

    /**
     * 获取商品列表
     *
     * @return
     */
    //    public List<ProductDto> findAll() {
    //        return this.productList;
    //    }

    /**
     * 根据ItemCode获取
     *
     * @param itemCode
     * @return
     */
    //    public ProductDto findOne(String itemCode) {
    //        for (ProductDto productDto : this.productList) {
    //            if (productDto.getItemCode().equalsIgnoreCase(itemCode)) {
    //                return productDto;
    //            }
    //        }
    //
    //        return null;
    //    }

    /**
     * 保存或更新商品信息
     *
     * @param productDto
     * @return
     */
    public String save(String productDto) {
        // TODO: 实现商品保存处理

        //        for (String sourceProductDto : this.productList) {
        //            if (sourceProductDto.getItemCode().equalsIgnoreCase(productDto.getItemCode())) {
        //                sourceProductDto.setName(sourceProductDto.getName() + "-new");
        //                sourceProductDto.setPrice(sourceProductDto.getPrice() + 100);
        //                productDto = sourceProductDto;
        //                break;
        //            }
        //        }/
        this.logger.debug("发送商品消息:{} ");

        // 发送商品消息
        this.sendMsg(ProductMsg.MA_UPDATE, productDto);

        return productDto;
    }

    /**
     * 具体消息发送的实现
     *
     * @param msgAction 消息类型
     * @param itemCode 商品货号
     */
    protected void sendMsg(String msgAction, String itemCode) {
        ProductMsg productMsg = new ProductMsg(msgAction, itemCode);
        this.logger.debug("发送商品消息:{} ", productMsg);

        // 发送消息
        this.source.output().send(MessageBuilder.withPayload(productMsg).build());
    }

    protected List<String> buildProducts() {
        List<String> products = new ArrayList<>();
        products.add("测试商品-1");
        products.add("测试商品-2");
        products.add("测试商品-3");
        products.add("测试商品-4");
        products.add("测试商品-5");
        products.add("测试商品-6");
        return products;
    }

}
