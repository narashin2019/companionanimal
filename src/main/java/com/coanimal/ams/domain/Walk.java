package com.coanimal.ams.domain;

import java.io.Serializable;
import java.sql.Date;

public class Walk implements Serializable {

  private static final long serialVersionUID = 20201203L;

  private int walkNo;
  private int memberNo;
  private String walkCategory;
  private String title;
  private String content;
  private Date createDate;
  private int viewCount;
  private int likeCount;
  private String nickname;


  @Override
  public String toString() {
    return "Walk [walkNo=" + walkNo + ", memberNo=" + memberNo + ",  walkCategory=" + walkCategory
        + ", title=" + title + ", content=" + content + ", createDate=" + createDate
        + ", viewCount=" + viewCount + ", likeCount=" + likeCount + ", nickname=" + nickname + "]";
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((content == null) ? 0 : content.hashCode());
    result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
    result = prime * result + ((walkCategory == null) ? 0 : walkCategory.hashCode());
    result = prime * result + walkNo;
    result = prime * result + likeCount;
    result = prime * result + memberNo;
    result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    result = prime * result + viewCount;
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
    Walk other = (Walk) obj;
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
    if (walkCategory == null) {
      if (other.walkCategory != null) {
        return false;
      }
    } else if (!walkCategory.equals(other.walkCategory)) {
      return false;
    }

    if (walkNo != other.walkNo) {
      return false;
    }
    if (likeCount != other.likeCount) {
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
    if (title == null) {
      if (other.title != null) {
        return false;
      }
    } else if (!title.equals(other.title)) {
      return false;
    }
    if (viewCount != other.viewCount) {
      return false;
    }
    return true;

  }


  public int getWalkNo() {
    return walkNo;
  }


  public void setWalkNo(int walkNo) {
    this.walkNo = walkNo;
  }


  public int getMemberNo() {
    return memberNo;
  }


  public void setMemberNo(int memberNo) {
    this.memberNo = memberNo;
  }


  public String getWalkCategory() {
    return walkCategory;
  }


  public void setWalkCategory(String walkCategory) {
    this.walkCategory = walkCategory;
  }


  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    this.title = title;
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


  public int getViewCount() {
    return viewCount;
  }


  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }


  public int getLikeCount() {
    return likeCount;
  }


  public void setLikeCount(int likeCount) {
    this.likeCount = likeCount;
  }


  public String getNickname() {
    return nickname;
  }


  public void setNickname(String nickname) {
    this.nickname = nickname;
  }



}

