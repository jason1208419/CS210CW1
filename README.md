# CS210CW1
**Coursework assignment**<br />
**Jens Blanck**<br />
**19/3/18**<br />
<br />
This coursework is due 27 April and is to be submitted on Blackboard. There will also be vivas in the lab slots in the last two weeks of term. For the vivas it is expected that you can download the code from Blackboard and run it to demonstrate that it works. It is also expected that you can answer questions about your implementation of the coursework.<br />
This is an individual coursework, please adhere to guidelines about academic misconduct.
### Description
To handle a large amount of data it has been decided to filter the data into separate files.<br />
The data is larger than the local storage capacity so all the data cannot be handled at once.<br />
In this assignment we are only interested in a concurrent implementation of this filtering.<br />
So a number of simplifications have been made to the above scenario.<br />
* The data is assumed to be integers.<br />
* The size of the local storage capacity is m (below m is chosen to be 4).<br />
* The size of the data is n (below n is chosen to be 100m = 400).<br />
* Any storage needed to handle concurrency correctly is assumed to be negligible compared to n and m, so this is disregarded.<br />
* The filtering is into k files (below k is chosen to be 2).<br />
[Clearly, in a real application m and n would be several magnitudes larger.]<br />

### Task
Develop a multithreaded program with three concurrent threads, A, B and C. Thread A generates n random integer numbers and writes them into a shared memory with a capacity of m integers. Due to the limited capacity of the shared memory, thread A cannot write all numbers at once. Threads B and C read the integer numbers from the shared memory. Thread B writes the even numbers to th file even-numbers and thread C writes the odd numbers to the file odd-numbers. Every number generated by thread A should be written in one of the two files. No number should be written twice. Choose any method, or combination of methods, for synchronization.<br />
To achieve full marks:<br />
* Encapsulate the synchronized methods and the shared memory into one structure.<br />
* Avoid busy waiting.<br />
* Avoid static variables.<br />

### Extension task
Write code that could easily be modified to cater for different values of m, n, and k above. For k = 3 you may consider the three classes of odd numbers, even numbers, and multiples of 3. Note that these are non-disjoint: numbers belonging to more than one class can be filtered into any of these but should still only appear in one of the output files. Partial credit for this can be achieved by describing what is needed during the viva.

### Languages
Implementations can be in either **Haskell** or **Java**.<br />
If Haskell is used I would recommend using STM, but MVars are also viable.

### Marks
Marks will be awarded according to correctness of implementation; understanding of implementation demonstrated at viva; and elegance of code.<br />
The extension task is only needed for the final 20% of the marks.<br />
A submission that does not compile or that does not run independent threads should not expect to achieve a pass mark.
