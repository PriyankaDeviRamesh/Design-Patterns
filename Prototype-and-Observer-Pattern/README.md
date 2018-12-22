# CSX42: Assignment 2
## Name: Priyanka Devi Ramesh

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in coursesRegistration/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile coursesRegistration/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile coursesRegistration/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile coursesRegistration/src/build.xml run -Darg0=<input_file.txt> -Darg1=<delete_file.txt> -Darg2=<output1_file.txt> -Darg3=<output2_file.txt> -Darg4=<output3_file.txt>

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:

I have created a original node and an arraylist of observers which acts as a backups in the node class. So When I am Inserting a node in the original tree, I am cloning two nodes and linking it with the observer nodes. When I delete any courses in the original tree, I will call notifyAll method that notifies the observer by calling update methods with the observers of node courses as the parameters and it automatically deletes the courses in observers too.

Time Complexity BST :
Average Case
insert - O(log n)
search - O(log n)
delete - O(log n)

Worst Case
insert - O(n)
search - O(n)
delete - O(n)

-----------------------------------------------------------------------
Provide list of citations (urls, etc.) from where you have taken code
(if any).

http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
https://stackoverflow.com/questions/13185727/reading-a-txt-file-using-scanner-class-in-java
https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
stackoverflow.com/questions//17203493


-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 08/22/2018

