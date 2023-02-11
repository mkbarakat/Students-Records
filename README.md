# Students-Records
AVL trees Data structure with Doubly circular Linked List

In this project, we are going to create a student Tawjihi records database. As what we have in the first
project, a Tawjihi record has (seat number, branch, andaverage) separated by comma.The records will
be read from one file and stored in a circular doubly linked listunsorted. To access the information fast
we will use 2 AVL trees. The first AVL will sort the data according to student’s seat number. The second
AVL will sort that data by average. In the second AVL tree, there will be grade duplicates. To handle the
duplicate we will maintain a single linked list within the secondAVL node (see below).
Important: the AVL trees will not contain any of the student information directly. Instead, they will
contain a pointer to the students’ information in the doubly linked list.
All the mentioned data structures should be part of a single data structure (class) let us call it TawjihiDS.
The following figure shows the internal structure of TawjihiDS:




![Full Stack developer/ Software Engineer / Data Engineer](https://github.com/mkbarakat/Students-Records/blob/master/Screenshot%20from%202023-02-11%2012-19-17.png?raw=true)
he TawjihiDS should have the following operations:

Insert: insert a new student record to the doubly linked list as well as pointers into the two AVL
trees. Duplicate students’ seat numbers are not allowed.
 Update a student information given the seat number.
 Delete a student record given the seat number.
 Find a student record given a seat number.
 Get all students for a given grade.


implement a javaFX GUI as follow:

At first, the user has to use a file chooser to load a Tawjihi file according to a selected Tawjihi
branch (i.e. Scientific or Literary).
 Read the file and fill the TawjihiDS (i.e. doubly linked list and 2 AVLs).
 Show options to insert/update/delete Tawjihi records
 Show an option to find a Tawjihi record using a seat number, with options to show the
previous/next records.
 Show an option to print out doubly linked list, 1 st AVL(level-traversal), or 2 nd AVL(level-traversal).
 Show an option to print out the AVL’s height.
