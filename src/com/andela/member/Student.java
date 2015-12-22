package com.andela.member;

import com.andela.model.Member;

/**
 * Created by Spykins on 21/12/2015.
 */
public class Student extends Member {
  private String studentDepartment;
  private String studentSubjecctOfInterest;
  public Student (String memberName, int memberIdNumber, String memberAddress){
    super(memberName, memberIdNumber, memberAddress);
  }
  public Student(String memberName, int memberIdNumber){
    super(memberName,memberIdNumber);
  }

  public String getStudentDepartment() {
    return studentDepartment;
  }

  public void setStudentDepartment(String studentDepartment) {
    this.studentDepartment = studentDepartment;
  }

  public String getStudentSubjecctOfInterest() {
    return studentSubjecctOfInterest;
  }

  public void setStudentSubjecctOfInterest(String studentSubjecctOfInterest) {
    this.studentSubjecctOfInterest = studentSubjecctOfInterest;
  }
}

