#Multi-Threading Experiment
This exercise was my first introduction into threads and multithreading. I decided to attempt a matrix multiplication algorithm to showcase threading and its usefulness. The program is built to allow for flexibility in the number of threads and the size of the matrices. It showcases the amount of time it takes to multiply two matrices in one thread versus the number of threads set at the beginning of the Main class.


##What I learned:
- How to implement threads in Java, both by extending the Thread class or by implementing the Runnable interface.
- How to ensure thread execution finishes before the program concludes with the join() method.
- When to use threads and when not to use them.
- What concurrency errors are and how to prevent them.
- A computer with N cores can execute programs at most N times as fast as a single core. 
  - On my computer, the time it took to execute the algorithm decreased until around 4 cores and then began to increase again which is consistent with the number of cores on my machine's intel i7 vPro.
- Multithreading increases memory demand, when the demand is greater than the available resources, performance decreases. 
  - Another reason for the decrease in performance as threads increased past 4.
- Writing to shared data-structures using either volatile or explicit synchronization increases memory demand (see second point).

## Conclusion
Multithreading can have a number of useful implementations, and I know can approach multithreading with knowledge and confidence to improve performance of my programs.
