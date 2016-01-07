package com.andela.library;

import com.andela.member.Staff;
import com.andela.member.Student;
import com.andela.model.Book;
import com.andela.model.Member;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import static org.junit.Assert.*;

/**
 * Created by Spykins on 23/12/2015.
 */
public class ReadersClubTest {
  BookQueue myTestQueue = new BookQueue();

  Member myMemberStudent1 = new Student("Waleola", 1345, "12 Bello M Yusuf, Jabi");
  Member myMemberStudent2 = new Student("Samuel", 4536);
  Member myMemberStudent3 = new Student("George", 7301, "kafashan, Kaduna State");
  Member myMemberStaff1 = new Staff("Charles", 2091);
  Member myMemberStaff3 = new Staff("Mainu", 2410);
  Member myMemberStaff4 = new Staff("Bamidele", 7490, "24, Mabushi rooad");

  Book myBook1 = new Book("Rich dad Poor dad", 23456, "Robert Kiyosaki", 2);
  Book myBook2 = new Book("21 indespensable quality of a leader", 87693, "John C Maxwell", 3);

  ReadersClub readersClub = new ReadersClub(myTestQueue,myMemberStaff1,myBook1);

  @Test
  public void testRequestForBook() throws Exception {
    readersClub.requestForBook(myMemberStudent1, myBook1);
    readersClub.requestForBook(myMemberStudent3, myBook1);
    readersClub.requestForBook(myMemberStaff4, myBook1);
    readersClub.requestForBook(myMemberStaff1,myBook1);

    assertTrue(myTestQueue.isMemberAlreadyinQueue(myBook1,myMemberStaff1));
    assertTrue(myTestQueue.isMemberAlreadyinQueue(myBook1,myMemberStaff4));
    assertTrue(myTestQueue.isMemberAlreadyinQueue(myBook1,myMemberStudent1));
    assertTrue(myTestQueue.isMemberAlreadyinQueue(myBook1,myMemberStudent3));

    assertFalse(myTestQueue.isMemberAlreadyinQueue(myBook1,myMemberStudent2));
    assertFalse(myTestQueue.isMemberAlreadyinQueue(myBook1,myMemberStaff3));
    assertFalse(myTestQueue.isMemberAlreadyinQueue(myBook2, myMemberStaff4));
  }

  @Test

  public void testAddBookToLibrary() throws Exception {
    Book myBook1 = new Book("Rich dad Poor dad", 23456, "Robert Kiyosaki", 2);
    Book myBook2 = new Book("21 indespensable quality of a leader", 87693, "John C Maxwell", 3);
    Book myBook10 = new Book("What goes Around", 530462, "James hill", 2);

    readersClub.addBookToLibrary(myBook1,myBook2);

    assertTrue(readersClub.isBookAvailableInLibrary(myBook1));
    assertTrue(readersClub.isBookAvailableInLibrary(myBook2));

    assertFalse(readersClub.isBookAvailableInLibrary(myBook10));
  }

  @Test
  public void testAddBooksToLibrary() throws Exception {
    Book myBook1 = new Book("Rich dad Poor dad", 23456, "Robert Kiyosaki", 2);
    Book myBook2 = new Book("21 indespensable quality of a leader", 87693, "John C Maxwell", 3);
    Book myBook10 = new Book("What goes Around", 530462, "James hill", 2);
    Book[] bookArray = {myBook1, myBook2};

    readersClub.addBooksToLibrary(bookArray);

    assertTrue(myBook1.getNumberOfCopies() == 2);
    assertTrue(myBook2.getNumberOfCopies() == 3);

    readersClub.addBookToLibrary(myBook1, myBook2);

    assertTrue(readersClub.isBookAvailableInLibrary(myBook1));
    assertFalse(readersClub.isBookAvailableInLibrary(myBook10));

    readersClub.addBookToLibrary(myBook1, myBook2);

    assertTrue(myBook1.getNumberOfCopies() == 4);
    assertTrue(myBook2.getNumberOfCopies() == 5);
  }

  @Test
  public void testAddMemberToLibrary() throws Exception {
    Member myMemberStudent1 = new Student("Waleola", 1345, "12 Bello M Yusuf, Jabi");
    Member myMemberStudent2 = new Student("Samuel", 4536);
    Member myMemberStudent3 = new Student("George", 7301, "kafashan, Kaduna State");
    Member myMemberStudent4 = new Student("Bodunde", 6810);

    readersClub.addMemberToLibrary(myMemberStudent1,myMemberStudent2,myMemberStudent3);

    assertTrue(readersClub.isMemberAvailableInLibrary(myMemberStudent1));
    assertFalse(readersClub.isMemberAvailableInLibrary(myMemberStudent4));
  }

  @Test
  public void testAddMembersToLibrary() throws Exception {
    Member myMemberStudent1 = new Student("Waleola", 1345, "12 Bello M Yusuf, Jabi");
    Member myMemberStudent2 = new Student("Samuel", 4536);
    Member myMemberStudent3 = new Student("George", 7301, "kafashan, Kaduna State");
    Member myMemberStudent4 = new Student("Bodunde", 6810);

    Member[] memberArray = {myMemberStudent1,myMemberStudent2,myMemberStudent3};
    readersClub.addMembersToLibrary(memberArray);

    assertTrue(readersClub.isMemberAvailableInLibrary(myMemberStudent1));
    assertFalse(readersClub.isMemberAvailableInLibrary(myMemberStudent4));
  }
  @Test
  public void testReturnBookToEligibleMember() throws Exception{
    Book myBook1 = new Book("Rich dad Poor dad", 23456, "Robert Kiyosaki", 2);
    Book myBook2 = new Book("21 indespensable quality of a leader", 87693, "John C Maxwell", 3);
    Book[] bookArray = {myBook1, myBook2};

    readersClub.addBooksToLibrary(bookArray);
    readersClub.addBookToLibrary(myBook1, myBook2);
    //books copy is 3

    readersClub.requestForBook(myMemberStudent1, myBook1);
    readersClub.requestForBook(myMemberStudent3, myBook1);
    readersClub.requestForBook(myMemberStaff4, myBook1);
    readersClub.requestForBook(myMemberStaff1,myBook1);

    HashMap<Book, Member>eligibleMember = new HashMap<>();
    eligibleMember.put(myBook1, myMemberStaff1);

    assertTrue(readersClub.returnBookToEligibleMember(myBook1).equals(eligibleMember));

    eligibleMember.put(myBook1, myMemberStaff4);

    assertTrue(readersClub.returnBookToEligibleMember(myBook1).equals(eligibleMember));

    eligibleMember.put(myBook1, myMemberStudent1);
    assertTrue(readersClub.returnBookToEligibleMember(myBook1).equals(eligibleMember));

    assertTrue(myBook1.getNumberOfCopies() == 0);
    eligibleMember.put(myBook1, myMemberStudent3);
    assertTrue(readersClub.returnBookToEligibleMember(myBook1) == null);

  }

  @Test
  public void returnBookToLibrary() throws Exception{
    Book myBook1 = new Book("Rich dad Poor dad", 23456, "Robert Kiyosaki", 2);
    Book myBook2 = new Book("21 indespensable quality of a leader", 87693, "John C Maxwell", 3);
    Book[] bookArray = {myBook1, myBook2};

    readersClub.addBooksToLibrary(bookArray);
    assertTrue(myBook1.getNumberOfCopies() == 2);

    readersClub.addBookToLibrary(myBook1, myBook2);
    assertTrue(myBook1.getNumberOfCopies() == 3);

    readersClub.requestForBook(myMemberStudent1, myBook1);
    readersClub.requestForBook(myMemberStudent3, myBook1);
    readersClub.requestForBook(myMemberStaff4, myBook1);
    readersClub.requestForBook(myMemberStaff1,myBook1);

    HashMap<Book, Member>eligibleMember = new HashMap<>();
    eligibleMember.put(myBook1, myMemberStaff1);
    assertTrue(readersClub.returnBookToEligibleMember(myBook1).equals(eligibleMember));
    assertTrue(myBook1.getNumberOfCopies() == 2);

    readersClub.returnBookToLibrary(myMemberStaff1, myBook1);
    assertTrue(myBook1.getNumberOfCopies() == 3);

  }
}