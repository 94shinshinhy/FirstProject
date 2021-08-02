package com.bitenter.dto;

// 후기 관련
public class ReplyDto {
    private int num;
    private String comm;
    private String id;
    private String replydate;
    
    // 후기 목록 보기에 사용
    public ReplyDto(int num, String comm, String id, String replydate) {
        super();
        this.num = num;
        this.comm = comm;
        this.id = id;
        this.replydate = replydate;
    }

    // 후기 작성에 사용
    public ReplyDto(String comm) {
        super();
        this.comm = comm;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getReplydate() {
        return replydate;
    }

    public void setReplydate(String replydate) {
        this.replydate = replydate;
    }
    
    // 후기 목록 보기
    @Override
    public String toString() {
        return "No." + num
              + " | 작성자: " + id 
              + "\t | 작성일: " + replydate
              + "\n\n 내용: " + comm + "\n";
    }
    
    
    
}
