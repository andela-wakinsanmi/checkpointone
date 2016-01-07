package com.andela.library;

import com.andela.member.Staff;
import com.andela.member.Student;
import com.andela.model.Book;
import com.andela.model.Member;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Spykins on 22/12/2015.
 */
public class BookQueueTest {
  BookQueue myTestQueue = new BookQueue();

  Member myMemberStudent1 = new Student("Waleola", 1345, "12 Bello M Yusuf, Jabi");
  Member myMemberStudent2 = new Student("Samuel", 4536);
  Member myMemberStaff1 = new Staff("Charles", 2091);
  Member myMemberStaff2 = new Staff("Ovay", 4970, "50, somewhere in Gwarimpa");

  Book myBook1 = new Book("Rich dad Poor dad", 23456, "Robert Kiyosaki", 2);
  Book myBook2 = new Book("21 indespensable quality of a leader", 87693, "John C Maxwell", 3);


  @Test
  public void testAddMemberToQueue() throws Exception {
    myTestQueue.addMemberToQueue(myBook1, myMemberStaff1);
    myTestQueue.addMemberToQueue(myBook2,myMemberStaff2);
    myTestQueue.addMemberToQueue(myBook2, myMemberStudent1);

    assertTrue(myTestQueue.isMemberAlreadyinQueue(myBook1, myMemberStaff1));
    assertTrue(myTestQueue.isMemberAlreadyinQueue(myBook2, myMemberStudent1));
    assertTrue(!myTestQueue.isMemberAlreadyinQueue(myBook2, myMemberStaff1));
    assertTrue(!myTestQueue.isMemberAlreadyinQueue(myBook1, myMemberStaff2));
  }

  @Test
  public void testReturnEligibleMemberForABook() throws Exception {

    Member myMemberStudent3 = new Student("George", 7301, "kafashan, Kaduna State");
    Member myMemberStudent4 = new Student("Bodunde", 6810);
    Member myMemberStaff3 = new Staff("Mainu", 2410);
    Member myMemberStaff4 = new Staff("Bamidele", 7490, "24, Mabushi rooad");

    myTestQueue.addMemberToQueue(myBook1, myMemberStudent1);
    myTestQueue.addMemberToQueue(myBook1, myMemberStaff2);
    myTestQueue.addMemberToQueue(myBook1, myMemberStudent2);
    myTestQueue.addMemberToQueue(myBook1, myMemberStaff3);
    myTestQueue.addMemberToQueue(myBook1,myMemberStudent3);
    /*
       creation sequence  member >> myMemberStudent1, myMemberStudent2, myMemberStaff1, myMemberStaff2
       myMemberStudent3, myMemberStudent4, myMemberStaff3, myMemberStaff4
     */
    //priority test:  myMemberStaff2, myMemberStaff3, myMemberStudent1, myMemberStudent2, myMemberStudent3

    assertTrue(myTestQueue.returnEligibleMemberForABook(myBook1) == myMemberStaff2);
    assertTrue(myTestQueue.returnEligibleMemberForABook(myBook1) == myMemberStaff3);
    assertTrue(myTestQueue.returnEligibleMemberForABook(myBook1) == myMemberStudent1);


    myTestQueue.addMemberToQueue(myBook2, myMemberStudent3);
    myTestQueue.addMemberToQueue(myBook2, myMemberStudent2);
    myTestQueue.addMemberToQueue(myBook2, myMemberStaff1);
    myTestQueue.addMemberToQueue(myBook2, myMemberStudent1);

    assertTrue(myTestQueue.returnEligibleMemberForABook(myBook2) == myMemberStaff1);
    assertTrue(myTestQueue.returnEligibleMemberForABook(myBook2) == myMemberStudent1);
    assertTrue(myTestQueue.returnEligibleMemberForABook(myBook2) == myMemberStudent2);
    assertTrue(myTestQueue.returnEligibleMemberForABook(myBook2) == myMemberStudent3);
  }

  @Test
  public void testHasQueueForBookRequested() throws Exception {
    Book myBook10 = new Book("What goes Around", 530462, "James hill", 2);

    myTestQueue.addMemberToQueue(myBook1, myMemberStaff1);
    myTestQueue.addMemberToQueue(myBook2,myMemberStaff2);
    myTestQueue.addMemberToQueue(myBook2, myMemberStudent1);

    assertTrue(myTestQueue.hasQueueForBookRequested(myBook1));
    assertTrue(!myTestQueue.hasQueueForBookRequested(myBook10));
  }
  @Test
  public void testIsMemberAlreadyinQueue() throws Exception {
    myTestQueue.addMemberToQueue(myBook1, myMemberStaff1);
    myTestQueue.addMemberToQueue(myBook2,myMemberStaff2);
    myTestQueue.addMemberToQueue(myBook2, myMemberStudent1);

    Member myMemberStaff10 = new Staff("Blessing", 46729);

    assertTrue(myTestQueue.isMemberAlreadyinQueue(myBook1, myMemberStaff1));
    assertTrue(myTestQueue.isMemberAlreadyinQueue(myBook2, myMemberStaff2));
    assertTrue(myTestQueue.isMemberAlreadyinQueue(myBook2, myMemberStudent1));

    assertTrue(!myTestQueue.isMemberAlreadyinQueue(myBook2, myMemberStaff10));
    assertTrue(!myTestQueue.isMemberAlreadyinQueue(myBook2, myMemberStaff1));
    assertTrue(!myTestQueue.isMemberAlreadyinQueue(myBook1, myMemberStaff2));


  }
}