package com.coanimal.ams.domain;

import java.io.Serializable;
import java.sql.Date;

// 20201215
public class Member implements Serializable {

  private static final long serialVersionUID = 20201207L;

  private int memberNo;
  private String email;
  private String idPhoto;
  private String password;
  private String nickname;
  private Date createdDate;
  private String authkey;
  private int authstatus;
  
  @Override
  public String toString() {
    return "Member [memberNo=" + memberNo + ", email=" + email + ", idPhoto=" + idPhoto
        + ", password=" + password + ", nickname=" + nickname + ", createdDate=" + createdDate
        + ", authkey=" + authkey + ", authstatus=" + authstatus + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((authkey == null) ? 0 : authkey.hashCode());
    result = prime * result + authstatus;
    result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((idPhoto == null) ? 0 : idPhoto.hashCode());
    result = prime * result + memberNo;
    result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
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
    Member other = (Member) obj;
    if (authkey == null) {
      if (other.authkey != null)
        return false;
    } else if (!authkey.equals(other.authkey))
      return false;
    if (authstatus != other.authstatus)
      return false;
    if (createdDate == null) {
      if (other.createdDate != null)
        return false;
    } else if (!createdDate.equals(other.createdDate))
      return false;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (idPhoto == null) {
      if (other.idPhoto != null)
        return false;
    } else if (!idPhoto.equals(other.idPhoto))
      return false;
    if (memberNo != other.memberNo)
      return false;
    if (nickname == null) {
      if (other.nickname != null)
        return false;
    } else if (!nickname.equals(other.nickname))
      return false;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    return true;
  }

  public int getMemberNo() {
    return memberNo;
  }

  public void setMemberNo(int memberNo) {
    this.memberNo = memberNo;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getIdPhoto() {
    return idPhoto;
  }

  public void setIdPhoto(String idPhoto) {
    this.idPhoto = idPhoto;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public String getAuthkey() {
    return authkey;
  }

  public void setAuthkey(String authkey) {
    this.authkey = authkey;
  }

  public int getAuthstatus() {
    return authstatus;
  }

  public void setAuthstatus(int authstatus) {
    this.authstatus = authstatus;
  }
  
  
  

}
