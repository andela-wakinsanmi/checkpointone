package com.andela.model;

import java.util.Date;

/**
 * Created by Spykins on 21/12/2015.
 */
public class Member {
  private String memberName;
  private int memberIdNumber;
  private Date memberRegistrationDate;
  private String memberAddress;

  public Member(String memberName, int memberIdNumber){
    this.memberRegistrationDate = new Date();
    this.memberName = memberName;
    this.memberIdNumber = memberIdNumber;
  }
  public Member(String memberName, int memberIdNumber, String memberAddress){
    this(memberName, memberIdNumber);
    this.memberAddress = memberAddress;
  }

  public String getMemberName() {
    return memberName;
  }

  public int getMemberIdNumber() {
    return memberIdNumber;
  }

  public Date getMemberRegistrationDate() {
    return memberRegistrationDate;
  }

  public String getMemberAddress() {
    return memberAddress;
  }

  public void setMemberAddress(String memberAddress) {
    this.memberAddress = memberAddress;
  }
}
