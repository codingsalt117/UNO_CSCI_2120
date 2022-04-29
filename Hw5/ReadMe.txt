Robin Johnson
29April2022
CSCI2120
HomeWork 5

Contains:
	Dog.java
	ListRunner.java
	Iterator.java
	LinkedList.java
	LinkedListTester.java
	JavaDocs

Dog.java: Class for making Dog objects
ListRunner.java: Contains code to run the overall program
Iterator.java: Creates an iterator for a list and contains methods to manipulate an iterator
LinkedList.java: Makes and manages doubly linked lists and methods to manipulates a list
LinkedListTester.java: Tests methods that were required to write by the assignment
JavaDocs: Located in docs folder

To run:
	1. Compile all java files--------
		Expected Results:
		terminal: $ javac *java
			Note: LinkedListTester.java uses unchecked or unsafe operations.
			Note: Recompile with -Xlint:unchecked for details.

			
			
	2a.To run the ListRunner------java ListRunner
		Expected Results:
		Terminal: $ java ListRunner
			Just Entered Dog constructor
			Leaving Dog constructor
			Just Entered Dog constructor
			Leaving Dog constructor
			Just Entered Dog constructor
			Leaving Dog constructor
			Just Entered Dog constructor
			Leaving Dog constructor

			Dog: Fifi , height: 8 weight: 12


			Dog: Fifi , height: 8 weight: 12
			Dog: Butch , height: 10 weight: 10
			Dog: Leonard , height: 13 weight: 22
			Dog: Spot , height: 9 weight: 17


			Just Entered Dog constructor
			Leaving Dog constructor
			Dog: Fifi , height: 8 weight: 12
			Dog: Jack , height: 18 weight: 18
			Dog: Butch , height: 10 weight: 10
			Dog: Leonard , height: 13 weight: 22
			Dog: Spot , height: 9 weight: 17


			Iterating using Iterators!!!
			Dog: Fifi , height: 8 weight: 12
			Dog: Jack , height: 18 weight: 18
			Dog: Butch , height: 10 weight: 10
			Dog: Leonard , height: 13 weight: 22
			Dog: Spot , height: 9 weight: 17


			Iterating backwards using Iterators!!!
			Dog: Spot , height: 9 weight: 17
			Dog: Leonard , height: 13 weight: 22
			Dog: Butch , height: 10 weight: 10
			Dog: Jack , height: 18 weight: 18
			Dog: Fifi , height: 8 weight: 12

	2b. To run LinkedListTester---java org.junit.runner.JUnitCore LinkedListTester
		Expected Results:
		Terminal:$ java org.junit.runner.JUnitCore LinkedListTester
			JUnit version 4.11
			Just Entered Dog constructor
			Leaving Dog constructor
			...
			...	
			Time: 0.007

			OK (9 tests)

