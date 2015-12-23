package com.andela.model;

import com.andela.member.Staff;
import com.andela.member.Student;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Spykins on 23/12/2015.
 */
public class MemberTest {

  @Test
  public void testCompareTo() throws Exception {
    Member myMemberStudent1 = new Student("Waleola", 1345, "12 Bello M Yusuf, Jabi");
    Member myMemberStudent2 = new Student("Samuel", 4536);
    Member myMemberStudent3 = new Student("George", 7301, "kafashan, Kaduna State");
    Member myMemberStudent4 = new Student("Bodunde", 6810);
    Member myMemberStaff1 = new Staff("Charles", 2091);
    Member myMemberStaff2 = new Staff("Ovay", 4970, "50, somewhere in Gwarimpa");
    Member myMemberStaff3 = new Staff("Mainu", 2410);
    Member myMemberStaff4 = new Staff("Bamidele", 7490, "24, Mabushi rooad");
    Member myMember = new Member("myMember",2310);
    assertTrue(myMemberStaff2.compareTo(myMemberStaff1) ==  1);
    assertTrue(myMemberStaff1.compareTo(myMemberStudent1) == -1);
    assertTrue(myMemberStudent3.compareTo(myMemberStaff1) == 1);
  }
}