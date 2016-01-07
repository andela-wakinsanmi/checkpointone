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

  protected void addMemberToQueue(Book bookRequested, Member memberRequestingForBook){
    if(hasQueueForBookRequested(bookRequested)){
      queueForBook.get(bookRequested).add(memberRequestingForBook);
    } else {
      PriorityQueue<Member> newBookQueue = new PriorityQueue<Member>();
      newBookQueue.add(memberRequestingForBook);
      queueForBook.put(bookRequested, newBookQueue);
    }
  }

  protected Member returnEligibleMemberForABook(Book bookRequested){
    return queueForBook.get(bookRequested).poll();
  }

  protected boolean hasQueueForBookRequested(Book bookRequested){
    return queueForBook.containsKey(bookRequested);
  }

  protected boolean isMemberAlreadyinQueue(Book bookRequested, Member memberRequestingForBook) {
    return queueForBook.containsKey(bookRequested) &&
        queueForBook.get(bookRequested).contains(memberRequestingForBook);
  }
}
