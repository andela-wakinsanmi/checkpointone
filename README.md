# checkpointone

### ReadersClub

ReadersClub is a class that can manage a Library Club, the ReadersClub accepts a BookQueue, Member (or Arrays of Member) and Book (or Arrays of Book) as argument. The ReadersClub keeps a list of allBooksInLibrary and the MembersAndBooksBorrowed as a
private variable. To initialize a ReadersClub object, You need to call either of the following Constructors:

+ ReadersClub(BookQueue bookQueue, Member newMember, Book newBook)
+ ReadersClub(BookQueue bookqueue, Member[] newMembers, Book[] newBooks)

Details about BookQueue, Member and Book class will be discussed below.

The client of the ReadersClub can add books to the Library by calling the public method
+ addBookToLibrary(Book...newBook)
+ addBooksToLibrary(Book[] newBooks)

Client can also add Members to the club by calling the public methods
+ public void addMemberToLibrary(Member...newMembers)
+ addMembersToLibrary(Member[] newMembers)

The client can request for a book by calling
- requestForBook(Member memberRequesting, Book bookMemberRequestsFor).

The Client will get a Map of the bookRequested and the eligibleMember by calling the method:
+ public Map<Book, Member> returnBookToEligibleMember(Book bookRequested)

[Click to preview the ReadersClub implementation] (https://github.com/andela-wakinsanmi/checkpointone/blob/staging/src/com/andela/library/ReadersClub.java)



### BookQueue
The BookQueue class keeps track of the queueForBook. An instance of the BookQueue is passed into the ReadersClub
constructor. The BookQueue keeps track of a Map whose key is Book and value is PriorityQueue of member (i.e Map<Book, PriorityQueue<Member>>)

When a member Requests For a Book from the ReadersClub, the method calls the BookQueue method which adds the Member to the PriorityQueue of Book if there is a request placed on the Book already or it adds a new entry into the Map if the Member is the first person to request for the book. The method:
  - public void addMemberToQueue(Book bookRequested, Member memberRequestingForBook)

Also the Method returnEligibleMemberForABook returns a member that is eligible to borrow a book at a particular time, based on the predefined preference (Staff has higher Priority over Student, Date of registration also has high priority).

  - public Member returnEligibleMemberForABook(Book bookRequested)

  [Click to preview the BookQueue implementation]
  (https://github.com/andela-wakinsanmi/checkpointone/blob/staging/src/com/andela/library/BookQueue.java)
### Staff
  This is a staff model, this class extends Member

[Click to preview the Staff Class] (https://github.com/andela-wakinsanmi/checkpointone/blob/staging/src/com/andela/member/Staff.java)
### Student
   This is a student model, this also extends Member.

[Click to preview Student Class] (https://github.com/andela-wakinsanmi/checkpointone/blob/staging/src/com/andela/member/Student.java)
  ### Member
  Member is the super class of Student and Staff. The Member class implements Comparable interface and i overide the
  compareTo method to ensure the subclass(Student or Staff) is properly sorted in the priority queue.

[Click to preview Member class] (https://github.com/andela-wakinsanmi/checkpointone/blob/staging/src/com/andela/model/Member.java)
  ### Book

  The Book class is a model, it keeps track of BookTitle, isbnNumber, nameOfAuthor and numberOfCopies.

  - public Book(String bookTitle, int isbnNumber, String nameOfAuthor, int numberOfCopies)
  [Click to preview Book Class] (https://github.com/andela-wakinsanmi/checkpointone/blob/staging/src/com/andela/model/Book.java)
