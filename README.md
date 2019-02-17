# CS210CW1
### Description<br />
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

### Task<br />
Develop a multithreaded program with three concurrent threads, A, B and C. Thread A generates n random integer numbers and writes them into a shared memory with a capacity of m integers. Due to the limited capacity of the shared memory, thread A cannot write all numbers at once. Threads B and C read the integer numbers from the shared memory. Thread B writes the even numbers to th file even-numbers and thread C writes the odd numbers to the file odd-numbers. Every number generated by thread A should be written in one of the two files. No number should be written twice. Choose any method, or combination of methods, for synchronization.<br />
To achieve full marks:<br />
* Encapsulate the synchronized methods and the shared memory into one structure.<br />
* Avoid busy waiting.<br />
* Avoid static variables.<br />

### Extension task<br />
Write code that could easily be modified to cater for different values of m, n, and k above. For k = 3 you may consider the three classes of odd numbers, even numbers, and multiples of 3. Note that these are non-disjoint: numbers belonging to more than one class can be filtered into any of these but should still only appear in one of the output files. Partial credit for this can be achieved by describing what is needed during the viva.
