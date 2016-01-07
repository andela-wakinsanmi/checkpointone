package com.andela.library;

import com.andela.model.Book;
import com.andela.model.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Spykins on 23/12/2015.
 */
public class ReadersClub {

  private List<Book>allBooksInLibrary;
  private Map<Member, List<Book>>memberAndBooksBorrowed;
  BookQueue bookQueue;

  public ReadersClub(BookQueue bookQueue, Member newMember, Book newBook){
    this.bookQueue = bookQueue;
    initializePrivateVariables();
    addMemberToLibrary(newMember);
    addBookToLibrary(newBook);
  }

  public ReadersClub(BookQueue bookqueue, Member[] newMembers, Book[] newBooks){
    this.bookQueue = bookqueue;
    initializePrivateVariables();
    addMembersToLibrary(newMembers);
    addBooksToLibrary(newBooks);
  }

  private void initializePrivateVariables(){
    allBooksInLibrary = new ArrayList<Book>();
    memberAndBooksBorrowed = new HashMap<Member, List<Book>>();
  }

  //add book
  protected boolean isBookAvailableInLibrary(Book bookRequestingFor){
    return allBooksInLibrary.contains(bookRequestingFor);
  }

  public void addBookToLibrary(Book...newBook){
    for(Book newBookToAdd : newBook){
      if(!isBookAvailableInLibrary(newBookToAdd)){
        allBooksInLibrary.add(newBookToAdd);
      } else {
        newBookToAdd.incrementBookCopies(1);
      }
    }
  }

  public void addBooksToLibrary(Book[] newBooks){
    for(Book book : newBooks){
      addBookToLibrary(book);
    }
  }

  //member
  public void addMemberToLibrary(Member...newMembers){
    for(Member newMember : newMembers){
      if(!isMemberAvailableInLibrary(newMember)){
        ArrayList memberBorrowedBook = new ArrayList();
        memberAndBooksBorrowed.put(newMember, memberBorrowedBook);
      }
    }
  }

  public boolean isMemberAvailableInLibrary(Member memberRequesting){
    return memberAndBooksBorrowed.containsKey(memberRequesting);
  }

  public void addMembersToLibrary(Member[] newMembers){
    for(Member member : newMembers) {
      addMemberToLibrary(member);
    }
  }

  //borrow book
  private boolean isBookAvailableToBorrow(Book bookRequestingFor){
    return isBookAvailableInLibrary(bookRequestingFor) && (bookRequestingFor.getNumberOfCopies() > 0);
  }

  public void requestForBook(Member memberRequesting, Book bookMemberRequestsFor){
    bookQueue.addMemberToQueue(bookMemberRequestsFor, memberRequesting);
  }

  public Map<Book, Member> returnBookToEligibleMember(Book bookRequested){
    Map<Book, Member> bookBorrowedAndMember = new HashMap<Book, Member>();

    if(isBookAvailableToBorrow(bookRequested)){
      Member memberThatGetsBook = bookQueue.returnEligibleMemberForABook(bookRequested);
      bookRequested.decrementBookCopies(1);
      bookBorrowedAndMember.put(bookRequested, memberThatGetsBook);
      updateMemberAndBooksBorrowed(memberThatGetsBook, bookRequested);
      return bookBorrowedAndMember;
    }
    return null;
  }

  private void updateMemberAndBooksBorrowed (Member memberThatGetsBook, Book bookRequested ) {
    if(hasMemberBorrowedBook(memberThatGetsBook)){
      List bookBorrowedByMember = memberAndBooksBorrowed.get(memberThatGetsBook);
      bookBorrowedByMember.add(bookRequested);
      memberAndBooksBorrowed.put(memberThatGetsBook, bookBorrowedByMember);
    } else {
      List listOfBookBorrowedByMember = new ArrayList<Book>();
      listOfBookBorrowedByMember.add(bookRequested);
      memberAndBooksBorrowed.put(memberThatGetsBook, listOfBookBorrowedByMember);
    }
  }

  private boolean hasMemberBorrowedBook(Member memberRequesting){
    return memberAndBooksBorrowed.containsKey(memberRequesting);
  }

  public void returnBookToLibrary(Member memberReturningBook, Book bookMemberIsReturning){
    List listOfBookBorrowed = memberAndBooksBorrowed.get(memberReturningBook);

    if(listOfBookBorrowed.contains(bookMemberIsReturning)){
      bookMemberIsReturning.incrementBookCopies(1);
      listOfBookBorrowed.remove(bookMemberIsReturning);
      memberAndBooksBorrowed.put(memberReturningBook, listOfBookBorrowed);
    }
  }
}
