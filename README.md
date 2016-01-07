# Readers Club

### ReadersClub class

ReadersClub class manages a Book Club, the ReadersClub constructor accepts a BookQueue, Member
(or Arrays of Member) and Book (or Arrays of Book) as argument. The ReadersClub keeps a list of allBooksInLibrary
and the MembersAndBooksBorrowed. To initialize a ReadersClub object, You need to call either
of the following Constructors:

###### ReadersClub Constructors

+ `ReadersClub(BookQueue bookQueue, Member newMember, Book newBook)`
+ `ReadersClub(BookQueue bookqueue, Member[] newMembers, Book[] newBooks)`

```java
  BookQueue myTestQueue = new BookQueue();
  Member myMemberStudent1 = new Student("Bodunde", 6810);
  Book myBook1 = new Book("Rich dad Poor dad", 23456, "Robert Kiyosaki", 2);
  ReadersClub readersClub = new ReadersClub(myTestQueue,myMemberStudent1,myBook1);
```

###### Instance Methods in ReadersClub class

The client of the ReadersClub can call the following methods

+ `addBookToLibrary(Book...newBook)` - Adds a book (or comma separated books) to the Library
+ `addBooksToLibrary(Book[] newBooks)` - Adds Array of books to the Library
+ `addMemberToLibrary(Member...newMembers)` - Adds a member (or comma separated Members) to the Library
+ `addMembersToLibrary(Member[] newMembers)` - Adds Array of Members to the Library
+ `requestForBook(Member memberRequesting, Book bookMemberRequestsFor)` - a member can request for a Book
+ `returnBookToEligibleMember(Book bookRequested)` - This returns a Map<Book, EligibleMember>
+ `returnBookToLibrary(Member memberReturningBook, Book bookMemberIsReturning)` - Member can return the book they have borrowed
back to the Library

[Click to preview the ReadersClub implementation] (https://github.com/andela-wakinsanmi/checkpointone/blob/staging/src/com/andela/library/ReadersClub.java)



### BookQueue

The BookQueue class keeps track of the queueForBook. An instance of the BookQueue is passed into the ReadersClub
constructor. The BookQueue keeps track of a Map of Book and PriorityQueue of member (i.e Map<Book, PriorityQueue<Member>>)

When a member Requests For a Book from the ReadersClub, the ReadersClub method calls the BookQueue method which is responsible for
adding Members to the PriorityQueue.

###### BookQueue Constructor


```java
  BookQueue myTestQueue = new BookQueue();
 ```

###### Methods in BookQueue class

Methods in BookQueue are protected, it is the Library Class that uses the BookQueue Methods. The List of BookQueue Protected
Methods are listed below:

+ `addMemberToQueue(Book bookRequested, Member memberRequestingForBook)`- Adds Member to queue for book
+ `returnEligibleMemberForABook(Book bookRequested)` - Returns the eligible member to the Readers Club class

  [Click to preview the BookQueue implementation]
  (https://github.com/andela-wakinsanmi/checkpointone/blob/staging/src/com/andela/library/BookQueue.java)


### Member Class

  Member  is an Abstract Class, it's the super class of Student and Staff. The Member class implements Comparable
  interface to sort priority queue. Client can't create an Object of this class

###### Methods in Member class

 + `getMemberName()` - Returns the name of member
 + `getMemberIdNumber()` - Returns the Id of Member
 + `getMemberRegistrationDate()` - Returns the Member Registration Date
 + `getMemberAddress()` - Returns the member Address
 + `setMemberAddress(String memberAddress)` - Sets the Address of member

[Click to preview Member class] (https://github.com/andela-wakinsanmi/checkpointone/blob/staging/src/com/andela/model/Member.java)


### Staff

  This is a staff model, this class extends Member

###### Staff Constructor

 +   `public Staff(String memberName, int memberIdNumber, String memberAddress)`;
 +   `public Staff(String memberName, int memberIdNumber)`;


```java
    Member myMemberStaff1 = new Staff("Charles", 2091);
    Member myMemberStaff2 = new Staff("Ovay", 4970, "50, somewhere in Gwarimpa");
```

###### Methods in Staff class

 + `public int getStaffPaidSalary()`
 + `public void setStaffPaidSalary(int staffPaidSalary)`
 + `public int getStaffWorkHour()`
 + `public void setStaffWorkHour(int staffWorkHour)`


[Click to preview the Staff Class] (https://github.com/andela-wakinsanmi/checkpointone/blob/staging/src/com/andela/member/Staff.java)



### Student

   This is a Student Class, this Class extends Member.

###### Student Constructor

 + `public Student (String memberName, int memberIdNumber, String memberAddress)`
 + `public Student(String memberName, int memberIdNumber)`

 ```java
    Member myMemberStudent1 = new Student("Waleola", 1345, "12 Bello M Yusuf, Jabi");
    Member myMemberStudent2 = new Student("Samuel", 4536);
 ```

###### Methods in Student class

 + `public String getStudentDepartment()`
 + `public void setStudentDepartment(String studentDepartment)`
 + `public String getStudentSubjectOfInterest()`
 + `public void setStudentSubjectOfInterest(String studentSubjectOfInterest)`


[Click to preview Student Class] (https://github.com/andela-wakinsanmi/checkpointone/blob/staging/src/com/andela/member/Student.java)


### Book
  The Book class keeps track of BookTitle, isbnNumber, nameOfAuthor and numberOfCopies.

###### Book Constructor

 + `public Book(String bookTitle, int isbnNumber, String nameOfAuthor, int numberOfCopies)`

```java
      Book myBook1 = new Book("Rich dad Poor dad", 23456, "Robert Kiyosaki", 2);
      Book myBook2 = new Book("21 indespensable quality of a leader", 87693, "John C Maxwell", 3);
```

###### Methods in Book class

 + `public String getBookTitle()`
 + `public int getIsbnNumber()`
 + `public String getNameOfAuthor()`
 + `public int getNumberOfCopies()`
 + `public void setBookTitle(String bookTitle)`
 + `public void incrementBookCopies(int numberOfCopiesToAdd)` - Increments the copy of the book
 + `public void decrementBookCopies(int numberOfCopiesToDecrement)` - Decrements the copy of the book


  [Click to preview Book Class] (https://github.com/andela-wakinsanmi/checkpointone/blob/staging/src/com/andela/model/Book.java)
