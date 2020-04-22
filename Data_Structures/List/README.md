# Linked List

The linked list or one way list is a linear set of data elements which is also termed as nodes. Here, the linear order is specified using pointers.

Each node is separated into two different parts:

- The first part holds the information of the element or node
- The second piece contains the address of the next node (link / next-pointer field) in this structure list.

![linked List](https://www.w3schools.in/wp-content/uploads/2016/09/Linked-list-1.png)



Linked lists can be measured as a form of high-level standpoint as being a series of nodes where each node has at least one single pointer to the next connected node, and in the case of the last node, a null pointer is used for representing that there will be no further nodes in the linked list.

- Insertion is O(1)
- Deletion is O(n)
- Searching is O(n)

Linked lists have a few key points that usually make them very efficient for implementing. These are:

- the list is **dynamic** and hence can be **resized** based on the requirement
- Secondly, the insertion is O(1).



## Singly Linked List

Singly linked lists are one of the most primitive data structures you will learn in this tutorial. Here each node makes up a singly linked list and consists of a value and a reference to the next node (if any) in the list.

![singly linked list](https://www.w3schools.in/wp-content/uploads/2016/09/Singly-Linked-List.png)