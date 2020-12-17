package com.coanimal.ams.domain;

import java.io.Serializable;
import java.sql.Date;

public class WalkReply implements Serializable {

  private static final long serialVersionUID = 20201203L;


  private int walkReplyNo; // pk
  private int walkNo; // fk
  private String content;
  private Date createDate;
  private int memberNo;
  private String nickname;


  @Override
  public String toString() {
    return "WalkReply [walkReplyNo=" + walkReplyNo + ", walkNo=" + walkNo + ", content=" + content
        + ", createDate=" + createDate + ", memberNo=" + memberNo + ", nickname=" + nickname + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((content == null) ? 0 : content.hashCode());
    result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
    result = prime * result + memberNo;
    result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
    result = prime * result + walkNo;
    result = prime * result + walkReplyNo;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    WalkReply other = (WalkReply) obj;
    if (content == null) {
      if (other.content != null) {
        return false;
      }
    } else if (!content.equals(other.content)) {
      return false;
    }
    if (createDate == null) {
      if (other.createDate != null) {
        return false;
      }
    } else if (!createDate.equals(other.createDate)) {
      return false;
    }
    if (memberNo != other.memberNo) {
      return false;
    }
    if (nickname == null) {
      if (other.nickname != null) {
        return false;
      }
    } else if (!nickname.equals(other.nickname)) {
      return false;
    }
    if (walkNo != other.walkNo) {
      return false;
    }
    if (walkReplyNo != other.walkReplyNo) {
      return false;
    }
    return true;
  }



  public int getWalkReplyNo() {
    return walkReplyNo;
  }

  public void setWalkReplyNo(int walkReplyNo) {
    this.walkReplyNo = walkReplyNo;
  }

  public int getWalkNo() {
    return walkNo;
  }

  public void setWalkNo(int walkNo) {
    this.walkNo = walkNo;
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

