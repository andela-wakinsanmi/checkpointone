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
    allClubMember.add(newMember);
    allBooksInLibrary.add(newBook);
    //add book to bookAvailableToCopy
  }
  public ReadersClub(BookQueue bookqueue, Member[] newMembers, Book[] newBooks){
    this.bookQueue = bookqueue;
    initializePrivateVariables();
    for(Member newMember : newMembers)
      allClubMember.add(newMember);
    for(Book newBook : newBooks)
      allBooksInLibrary.add(newBook);
    //add book to bookAvailableToCopy
  }
  private void initializePrivateVariables(){
    allClubMember = new ArrayList<Member>();
    allBooksInLibrary = new ArrayList<Book>();
    allBooksAvailableToBorrow = new HashMap<Book, Integer>();
    memberAndBooksBorrowed = new HashMap<Member, List<Book>>();
  }
  private void addBookToBookAvailableToBorrow(Book newBookToAdd){

  }
  private void addBooksToBookAvailableToBorrow(Book[] newBookToAdd){

  }
  public void requestForBook(Member memberRequesting, Book bookMemberRequestsFor){

  }
  public Map<Book, Member> returnBookToEligibleMember(){
    return null;
  }
  public boolean isMemberAvailableInLibrary(Member memberRequesting){
    return true;
  }
  public boolean isBookAvailableInLibrary(Book bookRequestingFor){
    return true;
  }
  private boolean isBookAvailableToBorrow(Book bookRequestingFor){
    return true;
  }
  public void addBookToLibrary(Book...newBook){

  }
  public void addBooksToLibrary(Book[] newBooks){

  }
  public void addMemberToLibrary(Member...newMember){

  }
  public void addMembersToLibrary(Member[] newMembers){

  }
}
