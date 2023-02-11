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




![Full Stack developer/ Software Engineer / Data Engineer](https://www.anchorsoftacademy.com/media/courseimg/fullstack-courser-banner_2VLJ5A6.jpg)
