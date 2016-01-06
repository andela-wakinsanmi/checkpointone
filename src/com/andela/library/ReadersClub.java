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
    for(int i = 0, n = newMembers.length; i<n; i++) {
      addMemberToLibrary(newMembers[i]);
    }
    for(int i = 0, n = newBooks.length; i<n; i++) {
      addBookToLibrary(newBooks[i]);
    }
  }

  private void initializePrivateVariables(){
    allBooksInLibrary = new ArrayList<Book>();
    memberAndBooksBorrowed = new HashMap<Member, List<Book>>();
  }

  //add book
  public boolean isBookAvailableInLibrary(Book bookRequestingFor){
    if(allBooksInLibrary.contains(bookRequestingFor)) {
      return true;
    } else {
      return false;
    }
  }

  public void addBookToLibrary(Book...newBook){
    for(Book newBookToAdd : newBook){
      if(!isBookAvailableInLibrary(newBookToAdd)){
        allBooksInLibrary.add(newBookToAdd);
      } else {
        changeBookCopies(newBookToAdd, 1);
      }
    }
  }

  private void changeBookCopies(Book bookToChangeCopy, int valueToIncrement){
    int indexOfBook = allBooksInLibrary.indexOf(bookToChangeCopy);
    Book bookToIncrememnt = allBooksInLibrary.get(indexOfBook);
    bookToIncrememnt.incrementBookCopies(valueToIncrement);
  }
  public void addBooksToLibrary(Book[] newBooks){
    for(int i = 0, n = newBooks.length; i < n; i++){
      addBookToLibrary(newBooks[i]);
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
    if(memberAndBooksBorrowed.containsKey(memberRequesting)) {
      return true;
    } else {
      return false;
    }
  }
  public void addMembersToLibrary(Member[] newMembers){
    for(int i = 0, n = newMembers.length; i<n; i++) {
      addMemberToLibrary(newMembers[i]);
    }
  }
  //borrow book
  private boolean isBookAvailableToBorrow(Book bookRequestingFor){
    if(isBookAvailableInLibrary(bookRequestingFor) && (bookRequestingFor.getNumberOfCopies() > 0) ){
      return true;
    } else {
      return false;
    }
  }

  public void requestForBook(Member memberRequesting, Book bookMemberRequestsFor){
    bookQueue.addMemberToQueue(bookMemberRequestsFor, memberRequesting);
  }

  public Map<Book, Member> returnBookToEligibleMember(Book bookRequested){
    Map<Book, Member> bookBorrowedAndMember = new HashMap<Book, Member>();
    if(isBookAvailableToBorrow(bookRequested)){
      Member memberThatGetsBook = bookQueue.returnEligibleMemberForABook(bookRequested);
      changeBookCopies(bookRequested, -1);
      bookBorrowedAndMember.put(bookRequested, memberThatGetsBook);
    }
    return bookBorrowedAndMember;
  }
}
