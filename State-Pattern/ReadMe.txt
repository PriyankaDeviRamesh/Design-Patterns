CSX42: Assignment 4
Name : Priyanka Devi Ramesh

Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=0

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf priyankadevi_ramesh_assign_4.tar.gz priyankadevi_ramesh_assign_4

-----------------------------------------------------------------------
Academic Honesty statement:

"I have done this assignment completely on my own. I have not copied it, nor have I given my solution to anyone else. 
I understand that if I am involved in plagiarism or cheating an official form will be submitted to the Academic Honesty
Committee of the Watson School to determine the action that needs to be taken. "

[Date: 11/11/2018]

-----------------------------------------------------------------------
Provide justification for how your state pattern works :

whenever a new line of input is read i.e. whenever a traveller comes process it inside context class's increaseOrdDecreaseSecurity() method. 
which then forwards to the init state class thats where the current state is set to. Whenever decision is made it is forwarded to context class and the from there 
delegated to particular class. Then whenever the respective state's performOperation method() is invoked the operation Ids of that state is added to the result ArrayList.
Later whenever Results class is invoked the result ArrayList is printed in the output file.This is how my state Pattern is implemented.

I have used ArrayList in my program. It is faster and it increases its size by 1.5 times.
-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

https://stackoverflow.com/questions/13185727/reading-a-txt-file-using-scanner-class-in-java
https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java

