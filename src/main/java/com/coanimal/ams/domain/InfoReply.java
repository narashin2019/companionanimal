package com.coanimal.ams.domain;

import java.io.Serializable;
import java.sql.Date;

public class InfoReply implements Serializable {

  private static final long serialVersionUID = 20201203L;

  private int infoReplyNo; //pk
  private int infoNo; //fk
  private String content; 
  private Date createDate;
  private int memberNo;
  private String nickname;



  @Override
  public String toString() {
    return "InfoReply [infoReplyNo=" + infoReplyNo + ", infoNo=" + infoNo + ", content=" + content
        + ", createDate=" + createDate + ", memberNo=" + memberNo + ", nickname=" + nickname + "]";
  }





  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((content == null) ? 0 : content.hashCode());
    result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
    result = prime * result + infoNo;
    result = prime * result + infoReplyNo;
    result = prime * result + memberNo;
    result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
    return result;
  }





  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    InfoReply other = (InfoReply) obj;
    if (content == null) {
      if (other.content != null)
        return false;
    } else if (!content.equals(other.content))
      return false;
    if (createDate == null) {
      if (other.createDate != null)
        return false;
    } else if (!createDate.equals(other.createDate))
      return false;
    if (infoNo != other.infoNo)
      return false;
    if (infoReplyNo != other.infoReplyNo)
      return false;
    if (memberNo != other.memberNo)
      return false;
    if (nickname == null) {
      if (other.nickname != null)
        return false;
    } else if (!nickname.equals(other.nickname))
      return false;
    return true;
  }





  public int getInfoReplyNo() {
    return infoReplyNo;
  }





  public void setInfoReplyNo(int infoReplyNo) {
    this.infoReplyNo = infoReplyNo;
  }





  public int getInfoNo() {
    return infoNo;
  }





  public void setInfoNo(int infoNo) {
    this.infoNo = infoNo;
  }





  public String getContent() {
    return content;
  }





  public void setContent(String content) {
    this.content = content;
  }





  public Date getCreateDate() {
    return createDate;
  }





  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }





  public int getMemberNo() {
    return memberNo;
  }





  public void setMemberNo(int memberNo) {
    this.memberNo = memberNo;
  }





  public String getNickname() {
    return nickname;
  }





  public void setNickname(String nickname) {
    this.nickname = nickname;
  }



  
}
