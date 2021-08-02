package com.bitenter.dto;

// 굿즈 및 앨범 구매 관련
public class ItemDto {
    private String itemname;
    private int itemnum;
    private int price;
    
    // 굿즈 및 앨범 보기에 사용
    public ItemDto(String itemname, int price) {
        super();
        this.itemname = itemname;
        this.price = price;
    }
    
    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }
    
    public int getItemnum() {
        return itemnum;
    }

    public void setItemnum(int itemnum) {
        this.itemnum = itemnum;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    // 굿즈 및 앨범 보기
    @Override
    public String toString() {
        return " | 상품명: " + itemname 
             + "\n | 가격: " + price;
    }
    
    
    
}
