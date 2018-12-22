# CSX42: Assignment 1
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
Read the two files and stored in two ArrayLists line by line and parsed these ArrayLists into strings 
and passed as the argument for the Student and Course classe ArrayLists. Then created an HashMap for StudentLevel and sorted the student ArrayList based on the StudentLevel. Assigned Courses based on the sorted student ArrayList and written it in a file and console.

-----------------------------------------------------------------------
Provide list of citations (urls, etc.) from where you have taken code
(if any).

https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
https://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 08/22/2018


