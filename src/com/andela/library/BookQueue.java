package com.andela.library;

import com.andela.model.Book;
import com.andela.model.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Spykins on 22/12/2015.
 */
public class BookQueue {
  private Map<Book, PriorityQueue<Member>> queueForBook;
  public BookQueue(){
    queueForBook = new HashMap<Book, PriorityQueue<Member>>();
  }
  public void addMemberToQueue(Book bookRequested, Member memberRequestingForBook){

  }
  public void removeMemberFromQueue(Book bookMemberBorrowed, Member memberWithBook){

  }
  public Member returnEligibleMemberForABook(Book bookRequested){
    return null;
  }

  public boolean hasQueueForBookRequested(Book bookRequested){
    return true;
  }

  public boolean isMemberAlreadyinQueue(Book bookRequested, Member memberRequestingForBook){
    return false;
  }

}
