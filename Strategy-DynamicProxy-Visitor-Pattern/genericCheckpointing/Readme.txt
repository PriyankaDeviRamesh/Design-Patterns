Name : Priyanka Devi Ramesh
BNumber : B00714190
Assignment 5 - Generic Check Pointing.

Following are the commands and the instructions to run ANT on your project.
-----------------------------------------------------------------------

## To clean:
ant -buildfile genericCheckpointing/src/build.xml clean

-----------------------------------------------------------------------

## To compile: 
ant -buildfile genericCheckpointing/src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile genericCheckpointing/src/build.xml run -Darg0=firstarg -Darg1=SECOND -Darg2=THIRD

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile genericCheckpointing/src/build.xml tarzip

-----------------------------------------------------------------------
## Description:

This project is to create a generic check point to serialize and deserialize 
objects. The code should allow the conversion of objects into a Pseudo-XML format
by serialization and deserializes this Pseudo-XML format back into objects. 
This is done using dynamic proxies and reflection because addition of new objects 
or serialization formats causes minimal changes (reduces the ripple effect).
Data Structure used is ArrayList. 
-----------------------------------------------------------------------
### Academic Honesty statement:

"I have done this assignment completely on my own. I have not copied it, nor have
I given my solution to anyone else. I understand that if I am involved in plagiarism 
or cheating an official form will be submitted to the Academic Honesty Committee of 
the Watson School to determine the action that needs to be taken. "

Date: 12/07/2018
-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
https://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java
