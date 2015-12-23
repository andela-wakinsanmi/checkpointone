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
  private List<Member>allClubMember;
  private List<Book>allBooksInLibrary;
  private Map<Book, Integer>allBooksAvailableToBorrow;
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
    for(int i = 0, n = newMembers.length; i<n; i++)
      addMemberToLibrary(newMembers[i]);
    for(int i = 0, n = newBooks.length; i<n; i++)
      addBookToLibrary(newBooks[i]);
  }
  private void initializePrivateVariables(){
    allClubMember = new ArrayList<Member>();
    allBooksInLibrary = new ArrayList<Book>();
    allBooksAvailableToBorrow = new HashMap<Book, Integer>();
    memberAndBooksBorrowed = new HashMap<Member, List<Book>>();
  }
  //add book
  public boolean isBookAvailableInLibrary(Book bookRequestingFor){
    if(allBooksInLibrary.contains(bookRequestingFor))
      return true;
    else
      return false;
  }
  public void addBookToLibrary(Book...newBook){
    for(Book newBookToAdd : newBook){
      if(!isBookAvailableInLibrary(newBookToAdd)){
        allBooksInLibrary.add(newBookToAdd);
        addBookToBookAvailableToBorrow(newBookToAdd);
      } else {
        addBookToBookAvailableToBorrow(newBookToAdd);
      }
    }
  }
  public void addBooksToLibrary(Book[] newBooks){
    for(int i = 0, n = newBooks.length; i<n; i++){
      addBookToLibrary(newBooks[i]);
    }
  }
  private void addBookToBookAvailableToBorrow(Book newBookToAdd){
    if(!isBookAvailableInLibrary(newBookToAdd)){
      allBooksAvailableToBorrow.put(newBookToAdd, 1);
    } else {
      int numberOfCopies = allBooksAvailableToBorrow.get(newBookToAdd) + 1;
      allBooksAvailableToBorrow.put(newBookToAdd, numberOfCopies);
    }
  }
  //member
  public void addMemberToLibrary(Member...newMember){

  }
  public void addMembersToLibrary(Member[] newMembers){

  }
  //borrow book
  private boolean isBookAvailableToBorrow(Book bookRequestingFor){
    return true;
  }
  public boolean isMemberAvailableInLibrary(Member memberRequesting){
    if(allClubMember.contains(memberRequesting)) return true;
    else return false;
  }

  private void addBooksToBookAvailableToBorrow(Book[] newBooksToAdd){
    for(Book newBook : newBooksToAdd){
      addBookToBookAvailableToBorrow(newBook);
    }
  }

  public void requestForBook(Member memberRequesting, Book bookMemberRequestsFor){

  }
  public Map<Book, Member> returnBookToEligibleMember(){
    return null;
  }


}
