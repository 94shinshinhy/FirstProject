package com.bitenter.dto;

// 내 정보 보기 (마이페이지)
public class SelectMyInfoDto {
    private String id;
    private String name;
    private String phone;
    private String address;

    // 내 정보 보기에 사용 (마이페이지)
    public SelectMyInfoDto(String id, String name, String phone, String address) {
        super();
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    // 내 정보 보기
    @Override
    public String toString() {
        return " | 아이디: " + id
             + "\n | 이름: " + name
             + "\n | 번호: " + phone
             + "\n | 주소: " + address;
    }
    
    
    
}
