# Project Title

A2

## Description

The Mancala 'board' is made up of two rows of six holes, or pits, each. If you don't have a Mancala board handy, an empty egg carton can work. Next, four pieces -- marbles or stones -- are placed in each of the 12 holes. The color of the pieces is irrelevant.
 
Each player has a 'store' to the right side of the Mancala board.



## Getting Started

### Dependencies

* Describe any prerequisites, libraries, OS version, etc., needed before installing and running your program.

Java Development Kit (JDK): You'll need to have the Java Development Kit installed on your system. Ensure that you have a compatible version of the JDK. The code snippets appear to use Java syntax, so a Java environment is essential


### Executing program

* How to build and run the program
* Step-by-step bullets
```
use code blocks for commands
```
* include the expected output

* scioer start CIS2430
* scioer shell CIS2430

For book class:
* cd coursework/
* cd GP3/
* gradle build
* java -jar build/libs/mancala.jar

Expected output:
Welcome to Mancala!
Enter Player One's name: 1
Enter Player Two's name: 2
Player Two's Store
   4 4 4 4 4 4 
[0] --- --- --- --- --- --- [0]
   4 4 4 4 4 4 
Player One's Store

It's 1's turn.
Enter the pit number to move from (1-6): 1
1 moved 4 stones.

Player Two's Store
   4 4 4 4 4 4 
[0] --- --- --- --- --- --- [0]
   0 5 5 5 5 4 
Player One's Store

It's 2's turn.
Enter the pit number to move from (7-12): 7
2 moved 4 stones.

Player Two's Store
   4 5 5 5 5 0 
[0] --- --- --- --- --- --- [0]
   0 5 5 5 5 4 
Player One's Store

It's 1's turn.
Enter the pit number to move from (1-6): 2
1 moved 5 stones.

Player Two's Store
   4 5 5 5 5 0 
[0] --- --- --- --- --- --- [1]
   0 0 6 6 6 5 
Player One's Store

It's 1's turn.
Enter the pit number to move from (1-6): 8
Invalid move. Invalid move.

Player Two's Store
   4 5 5 5 5 0 
[0] --- --- --- --- --- --- [1]
   0 0 6 6 6 5 
Player One's Store

It's 1's turn.
Enter the pit number to move from (1-6): 3
1 moved 6 stones.

Player Two's Store
   4 5 5 5 6 1 
[0] --- --- --- --- --- --- [2]
   0 0 0 7 7 6 
Player One's Store

It's 2's turn.
Enter the pit number to move from (7-12): 7
2 moved 1 stones.

Player Two's Store
   4 5 5 5 7 0 
[0] --- --- --- --- --- --- [2]
   0 0 0 7 7 6 
Player One's Store

It's 1's turn.
Enter the pit number to move from (1-6): 4
1 moved 7 stones.

Player Two's Store
   4 5 6 6 8 1 
[0] --- --- --- --- --- --- [3]
   0 0 0 0 8 7 
Player One's Store

It's 2's turn.
Enter the pit number to move from (7-12): 7
2 moved 1 stones.

Player Two's Store
   4 5 6 6 9 0 
[0] --- --- --- --- --- --- [3]
   0 0 0 0 8 7 
Player One's Store

It's 1's turn.
Enter the pit number to move from (1-6): 5
1 moved 8 stones.

Player Two's Store
   5 6 7 7 10 1 
[0] --- --- --- --- --- --- [4]
   0 0 0 0 0 8 
Player One's Store

It's 2's turn.
Enter the pit number to move from (7-12): 7
2 moved 1 stones.

Player Two's Store
   5 6 7 7 11 0 
[0] --- --- --- --- --- --- [4]
   0 0 0 0 0 8 
Player One's Store

It's 1's turn.
Enter the pit number to move from (1-6): 6
1 moved 8 stones.

Game Over!
Player Two's Store
   0 0 0 0 0 0 
[36] --- --- --- --- --- --- [12]
   0 0 0 0 0 0 
Player One's Store

1 wins!


## Limitations

What isn't done? What things cause errors?  

Error Handling: The code does not include comprehensive error handling. For example, if you attempt to remove a product that doesn't exist in the cart or check if a product is in the cart without proper validation, it might result in errors or unexpected behavior. Implementing error handling and validation for these scenarios would be beneficial.

## Author Information

Your name and contact information including your email address
Crissy Grao
1211950
cgrao@uoguelph.ca

## Development History

1. Indentation and Formatting:
Ensured consistent indentation and formatting throughout the code to improve overall readability.

2. Comments:
Some comments were added to explain the purpose of specific methods and sections of the code.

Mancala complete 
Keep a log of what things you accomplish when.  You can use git's tagging feature to tag the versions or you can reference commits.

* 0.2
    * Various bug fixes and optimizations
    * See [commit change]() or See [release history]()
* 0.1
    * Initial Release

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [simple-readme] (https://gist.githubusercontent.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc/raw/d59043abbb123089ad6602aba571121b71d91d7f/README-Template.md)



