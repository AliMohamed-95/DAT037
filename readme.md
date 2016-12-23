Data structures DAT037
======================

### Table of Contents
* [Introduction](#introduction)
* [Assignments](#example2)
	* 1.[Binary serach](#binary-serach)
	* 2.[Binary heap & Bubble sort](#binary-heap)
	* 3.[Dijkstra](#dijkstra)
	
## Introduction

This course provides an introduction to mathematical modeling of computational problems. It covers the common algorithms, algorithmic paradigms, and data structures used to solve these problems. The course emphasizes the relationship between algorithms and programming, and introduces basic performance measures and analysis techniques for these problems.

## Assignments
The course consists of three labs addressing different data structures.

### Binary serach

Programming assignment 1: Binary search

The purpose of this assignment is to practice Java programming with interfaces and generics, and to get acquainted with a simple but useful algorithm.

#### A. Implementing a set of integers using a sorted array

A simple way to implement a set of elements is to use a sorted array containing those elements. In this case one can use binary search to efficiently decide whether a given element is in the set.

Your first task is to implement a set of integers as a sorted array of integers. You should implement the interface

```
public interface MyIntSet {
   public boolean member(int element);
  }
using a class:
   public class MySortedIntArray implements MyIntSet {
      ...   
  }
  ```
  
The member method must be implemented using binary search.

Your top-level program should be called Lab1A (i.e. there should be a class Lab1A implementing the main method). This program should read a file containing a sorted list of integers separated by spaces, use those numbers to create an instance of MySortedIntArray, and use the member method to determine if a given number is present in the file. If your program is invoked using the command java Lab1A <element> <file>, then the program should print true on standard output if <element> is in <file>, and false otherwise.

Binary search is described in the course text book. However, the implementation is actually not quite correct, and it returns an index rather than a boolean.

You must implement binary search on your own. Use a plain array, not an ArrayList. You are not allowed to use other people's programs or programs from standard libraries.

You can use the Scanner class to read the file. You are allowed to use an ArrayList in the main program.

The MyIntSet interface only contains a member method, so there is no requirement to implement an add method. A simpler solution is to just pass an array containing the elements read from the file to the constructor of the  MySortedIntArray class. However, you are allowed to implement an add method, in which case you should use a dynamic array.

#### B. Generics: Implementing a set of elements of arbitrary type using a sorted array

Your second task is to implement sets with elements of an arbitrary type E. You should implement the generic Java interface

```
public interface MySet<E> {
    public boolean member(E element);
}
using a generic class:

public class MySortedArray<E extends Comparable<? super E>> implements MySet<E> {
    ...
}
```
The member method must be implemented using binary search.

In order to sort elements of type E we must have a way to compare them. You should use the elements' "natural ordering", i.e. the one provided by the Comparable interface. (The somewhat cryptic declaration  <E extends Comparable<? super E>> is explained in the course text book: Section 1.5.5 in the second edition, and Section 1.5.6 in the third edition.)

As in part A you shouldn't use an ArrayList from the collection framework as a back-end. The idea is that you start from the code in part A and make it generic.

The top-level class containing main should be called Lab1B. It should not be generic. This class should instantiate  E to the type of integers, for instance as follows: new MySortedArray<Integer>(...).

As in part A, if your program is invoked using the command java Lab1B <element> <file>, where <file> is a file containing a sorted list of integers separated by spaces, and <element> is an integer, then the program should print true on standard output if <element> is in <file>, and false otherwise.



