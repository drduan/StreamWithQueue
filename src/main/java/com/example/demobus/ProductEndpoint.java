package com.example.demobus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/products")
public class ProductEndpoint {
    protected Logger logger = LoggerFactory.getLogger(ProductEndpoint.class);
    @Autowired
    ProductService productService;
    // 省略了其它不相干代码

    // TODO: 该端点仅仅是用来测试消息发送，并不包含任何业务逻辑处理

    @RequestMapping("/aaa")
    @ResponseBody
    public String save1() {
        //        String productDto = this.productService.findOne(itemCode);
        //        if (null != productDto) {
        this.productService.save("aaa");
        //        }
        this.logger.debug("return:{} " );

        return "aaa";
    }

}
