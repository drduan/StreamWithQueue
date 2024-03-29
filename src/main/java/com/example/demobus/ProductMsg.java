package com.example.demobus;

import lombok.Data;

@Data
public class ProductMsg {
    /** 消息类型：更新商品，值为: {@value} */
    public static final String MA_UPDATE = "update";
    /** 消息类型：删除商品，值为: {@value} */
    public static final String MA_DELETE = "delete";

    // ========================================================================
    // fields =================================================================
    private String action;
    private String itemCode;

    // ========================================================================
    // constructor ============================================================
    public ProductMsg() {  }

    public ProductMsg(String action, String itemCode) {
        this.action = action;
        this.itemCode = itemCode;
    }

//    @Override
//    public String toString() {
        //        return MoreObjects.toStringHelper(this)
        //                .add("action", this.getAction())
        //                .add("itemCode", this.getItemCode()).toString();
//    }

    // ==================================================================
    // setter/getter ====================================================
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }

    public String getItemCode() {
        return itemCode;
    }
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
