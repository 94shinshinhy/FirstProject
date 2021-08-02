package com.bitenter.dto;

// 장바구니 관련
public class CartDto {
    private String id;
    private String itemname;
    private int price;
    private int cartid;
    
    // 장바구니 보기에 사용
    public CartDto(String id, String itemname, int price, int cartid) {
        super();
        this.id = id;
        this.itemname = itemname;
        this.price = price;
        this.cartid = cartid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getCartId() {
        return cartid;
    }

    public void setCartId(int cartid) {
        this.cartid = cartid;
    }
    
    
    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    // 장바구니 보기
    @Override
    public String toString() {
        return " | No." + cartid
             + " | 아이디: " + id
             + " | 상품명: " + itemname 
             + " | 가격: " + price;
    }
    
    
    
}
