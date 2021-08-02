package com.bitenter.dto;

// 아티스트 소개 관련
public class ArtistsDto {
    private String artname;
    private String member;
    private String enter;
    private String title;
    private String debut;
    private int artnum;
    
    // 아티스트 소개 보기에 사용
    public ArtistsDto(String artname, String member, String enter, String title, String debut) {
        super();
        this.artname = artname;
        this.member = member;
        this.enter = enter;
        this.title = title;
        this.debut = debut;
    }
    
    public String getName() {
        return artname;
    }

    public void setName(String name) {
        this.artname = name;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getEnter() {
        return enter;
    }

    public void setEnter(String enter) {
        this.enter = enter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }
    
    public int getArtnum() {
        return artnum;
    }

    public void setArtnum(int artnum) {
        this.artnum = artnum;
    }

    // 아티스트 소개 보기
    @Override
    public String toString() {
        return " | 아티스트: " + artname
             + "\n | 멤버: " + member
             + "\n | 소속사: " + enter
             + "\n | 타이틀: " + title
             + "\n | 데뷔: " + debut;
    }
    
    
    
}
