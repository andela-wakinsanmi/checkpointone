package com.andela.member;

import com.andela.model.Member;

/**
 * Created by Spykins on 21/12/2015.
 */
public class Staff extends Member{

  private int staffPaidSalary;
  private int staffWorkHour;
  private String studentDepartment;

  public Staff(String memberName, int memberIdNumber, String memberAddress){
    super(memberName, memberIdNumber, memberAddress);
  }

  public Staff(String memberName, int memberIdNumber){
    super(memberName,memberIdNumber);
  }

  public int getStaffPaidSalary() {
    return staffPaidSalary;
  }

  public void setStaffPaidSalary(int staffPaidSalary) {
    this.staffPaidSalary = staffPaidSalary;
  }

  public int getStaffWorkHour() {
    return staffWorkHour;
  }

  public void setStaffWorkHour(int staffWorkHour) {
    this.staffWorkHour = staffWorkHour;
  }
}
