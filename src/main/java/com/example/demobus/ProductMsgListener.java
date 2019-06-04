package com.example.demobus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class ProductMsgListener {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected ProductService productService;

    @StreamListener(Sink.INPUT)
    public void onProductMsg(ProductMsg productMsg) {
        if (ProductMsg.MA_UPDATE.equalsIgnoreCase(productMsg.getAction())) {
            this.logger.debug("收到商品变更消息，商品货号: {}", productMsg.getItemCode());
            // 重新获取该商品信息
//            String productDto = this.productService.loadByItemCode(productMsg.getItemCode());
//            if (null != productDto)
//                this.logger.debug("重新获取到的商品信息为:{}", productDto);
//            else
                this.logger.debug("货号为:{} 的商品不存在", productMsg.getItemCode());
        } else if (ProductMsg.MA_DELETE.equalsIgnoreCase(productMsg.getAction())) {
            this.logger.debug("收到商品删除消息，所要删除商品货号为: {}", productMsg.getItemCode());
        } else {
            this.logger.debug("收到未知商品消息: {}", productMsg);
        }
    }
}
