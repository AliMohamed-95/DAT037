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

### Binary heap

In one exchange to trade with shares of large companies. You can do this via the Internet if you have a bank service for stock trading. You can specify where if you want to buy or sell a certain share classes and indicate the price they are willing to pay.

Suppose you want to buy shares in Ericsson for SEK 70 each. Your bid will then be compared with the offer price, ie the lowest price a seller presently is willing to accept for its Ericsson shares. If the selling price is 70 SEK or less accepted your offer and you get to buy the shares for 70 SEK. They call such a completion of the deal a "completed". (Of course it is unwise to offer the lowest selling price, but also such bids have to be handled.) If the sale price is higher than SEK 70 will be added to your bid in Ericsson's "order book" where all uncompleted bids recorded. If the latter comes in a new seller who is willing to sell for 70 SEK will your purchase be carried out when instead.

#### Assignment

Your task is to implement a program for stock trading as outlined above. For simplicity, you only need to deal with one class of shares and all bids refer only to one share at a time. However, there are several different sellers and buyers. The bids shall be specified in whole crowns. (It is of course easy to write a more general program that handles more classes of shares, where any number of shares can be handled in an order.)

The order book consists of two priority queues: one for the seller and the buyer. In the priority queue for sellers means lower price higher priority. In the priority queue of buyers, by contrast, higher price higher priority.

### Dijkstra

Your task is to implement a service similar Västtrafiks travel planner. Your program has access to a network and serves to calculate the shortest travel time between two specific stops in this network, provided information about the travel time between subsequent stops on each route. For simplicity, so you need not deal with the departure times, but it is assumed that every trip can be done immediately. You can imagine that there are an unlimited number of taxis at each stop.

#### Requirements

* The program will take four arguments:
	- 1. A file stops (the file format is described below).
	- 2. A file lines (the file format is described below).
	- 3. Start stop.
	- 4. The terminus.
* Implementation:
	- 1. You have to use Dijkstra's algorithm to compute the shortest path, and you must implement the algorithm itself. The algorithm must be implemented so as to have time complexity O (v + E log V) where e is the number of edges, v the number of nodes, provided that the graph is not a multi-graph, and determining similarity between the nodes labels takes O (1) . (This does not apply to all such graphs, and maybe not for your nodetiketter, but you can not ignore.) Therefore it is important that you use a sufficiently efficient priority queue.
	- 2. You must define your own graph class, and you must represent graphs with adjacency lists.
	- 3. It should be possible to implement other graph algorithms without changing the graph representation.
	- 4. Graph data structure must not contain any fields that are only used for Dijkstra's algorithm.
	- 5. It must be possible to use Dijkstra's algorithm in other programs.
	- 6. The main program will be separated from the implementation of the graphs and the Dijkstra's algorithm. Printing and any graphics are handled in the main program.
	
#### Help package 
To facilitate the work, you get a package, Lab3Help.jar (documentation), with features to load line information and interface Path. Do not unpack the jar file, but put it in your CLASSPATH.

Stop Files can be loaded with the read method tops in the class Lab3File. The method gives readings tops a list that contains elements of type BStop. These elements represent stops and contains the names and coordinates.

Line Files can be loaded with the read lines, also in the class Lab3File, the result is a list of elements of type BLineTable. Each BLineTable represents information about a line and includes line numbers and the stops that are included in the line. These stops are represented by objects / values of type BLineStop, which contain hold name and the time it takes to get to the bus stop from the previous stop.








