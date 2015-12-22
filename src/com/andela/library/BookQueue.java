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
    if(hasQueueForBookRequested(bookRequested)){
      queueForBook.get(bookRequested).add(memberRequestingForBook);
    } else {
      PriorityQueue<Member> newBookQueue = new PriorityQueue<Member>();
      newBookQueue.add(memberRequestingForBook);
      queueForBook.put(bookRequested, newBookQueue);
    }
  }

  public Member returnEligibleMemberForABook(Book bookRequested){
    return queueForBook.get(bookRequested).poll();
  }

  public boolean hasQueueForBookRequested(Book bookRequested){
    if(queueForBook.containsKey(bookRequested)) return true;
    else return false;
  }

  public boolean isMemberAlreadyinQueue(Book bookRequested, Member memberRequestingForBook){
    if (queueForBook.containsKey(bookRequested)) {
      if(queueForBook.get(bookRequested).contains(memberRequestingForBook)) return true;
      else return false;
    } else
      return false;
  }

}
