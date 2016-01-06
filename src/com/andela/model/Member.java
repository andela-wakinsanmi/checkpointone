package com.andela.model;

import com.andela.member.Staff;
import com.andela.member.Student;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by Spykins on 21/12/2015.
 */
public abstract class Member implements Comparable<Member> {

  private String memberName;
  private int memberIdNumber;
  private Date memberRegistrationDate;
  private String memberAddress;

  public Member(String memberName, int memberIdNumber){
    try{
      this.memberRegistrationDate = new Date();
      Thread.sleep(100);
    } catch(Exception e){

    }
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

  public boolean equals(Member member){
    return this.getMemberRegistrationDate() == member.getMemberRegistrationDate();
  }

  @Override
  public int compareTo(Member member) {
    if(this.getClass() == member.getClass()){
      return this.getMemberRegistrationDate().compareTo(member.getMemberRegistrationDate());
    } else if(member instanceof Student) {
      return -1;
    } else {
      return 1;
    }
  }
}
