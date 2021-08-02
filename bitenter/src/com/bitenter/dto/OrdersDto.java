package com.bitenter.dto;

// 구매내역 관련
public class OrdersDto {
    private String id;
    private String itemname;
    private int price;
    private String orderdate;
    private int orderid;
    private String itemnum;
    
    // 구매내역 보기에 사용
    public OrdersDto(String id, String itemname, int price, String orderdate, int orderid) {
        super();
        this.id = id;
        this.itemname = itemname;
        this.price = price;
        this.orderdate = orderdate;
        this.orderid = orderid;
    }
    
    public OrdersDto(String id, String itemnum) {
        super();
        this.id = id;
        this.itemnum = itemnum;
    }
    
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getName() {
        return id;
    }
    
    public void setName(String id) {
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
    
    public String getOrderdate() {
        return orderdate;
    }
    
    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }
    
    public String getItemnum() {
        return itemnum;
    }
    
    public void setItemnum(String itemnum) {
        this.itemnum = itemnum;
    }
    
    // 구매내역 보기
    @Override
    public String toString() {
        return " | No." + orderid
             + " | 아이디: " + id
             + " | 상품명: " + itemname 
             + " | 가격: " + price
             + " | 주문일: " + orderdate;
    }

    
    
    
}
