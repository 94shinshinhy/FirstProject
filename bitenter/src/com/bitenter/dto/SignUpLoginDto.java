package com.bitenter.dto;

// 회원가입, 로그인 관련
public class SignUpLoginDto {
    private String id;
    private String pwd;
    private String name;
    private String phone;
    private String address;
    private String ssn;
    
    // 아이디 찾기에 사용
    public SignUpLoginDto() {}

    // 회원가입에 사용
    public SignUpLoginDto(String id, String pwd, String name, String phone, String address, String ssn) {
        super();
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.ssn = ssn;
    }
    
    // 로그인에 사용
    public SignUpLoginDto(String id, String pwd) {
        super();
        this.id = id;
        this.pwd = pwd;
    }
    
    // 비밀번호 찾기에 사용
    public SignUpLoginDto(String id, String name, String ssn) {
        super();
        this.id = id;
        this.name = name;
        this.ssn = ssn;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    
    
    
}
