CSX42: Assignment 3
Name: Priyanka Devi Ramesh

Following are the commands and the instructions to run ANT on your project.

Note: build.xml is present in primeNumbers/src folder.
Instruction to clean:
####Command: ant -buildfile primeNumbers/src/build.xml clean

Description: It cleans up all the .class files that were generated when you compiled your code.

Instruction to compile:
####Command: ant -buildfile primeNumbers/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

Instruction to run:
####Command: ant -buildfile primeNumbers/src/build.xml run  
Note: Arguments accept the absolute path of the files.

Description:

Read the input file from the command-line argument. called the startWorkers() with NUM_THREADS as parameter and that calls the run method and join methods of thread class to start the threads. The run() of the WorkerThread class checks if the number is prime or not and add it to the results.
then computed the sum of prime numbers in the results. /* assumption made : All odd numbers are prime numbers - for this assignment */
I have used Arraylist to store all the prime numbers as Arraylist grows by 50% in space and time required will not be on higher side .
Provide list of citations (urls, etc.) from where you have taken code (if any).

https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java 
https://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java

Academic Honesty statement:
"I have done this assignment completely on my own. I have not copied it, nor have I given my solution to anyone else. I understand that if I am involved in plagiarism or cheating an official form will be submitted to the Academic Honesty Committee of the Watson School to determine the action that needs to be taken. "

Date: 10/28/2018