package com.bitenter.dto;

// 내 정보 수정 (마이페이지)
public class UpdateMyInfoDto {
    private String pwd;
    private String name;
    private String phone;
    private String address;
    
    // 내 정보 수정에 사용 (마이페이지)
    public UpdateMyInfoDto() {}
    
    // 내 모든 정보 수정에 사용 (마이페이지)
    public UpdateMyInfoDto(String pwd, String name, String phone, String address) {
        super();
        this.pwd = pwd;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
    
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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
    
    
    
}
