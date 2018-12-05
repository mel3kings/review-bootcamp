### Problem
There are one hundred closed lockers in a hallway. A man begins by opening all one hundred lockers. Next, he closes every second locker. Then he goes to every third locker and closes it if it is open or opens it if it is closed (e.g., he toggles every third locker). After his one hundredth pass in the hallway, in which he toggles only locker number one hundred, how many lockers are open?

### SOLUTION
- Question: For which rounds is a door toggled (open or closed)?
    - Answer:  door n is toggled once for each factor of n, including itself and 1. That is, door 15 is toggled on round 1, 3, 5, and 15.
- Question: When would a door be left open?
    - Answer: A door is left open if the number of factors (x) is odd. You can think about this by pairing factors off as an open and a close. If there’s one remaining, the door will be open.
- Question: When would x be odd?
    - Answer: x is odd if n is a perfect square. Here’s why: pair n’s factors by their complements. For example, if n is 36, the factors are (1, 36), (2, 18), (3, 12), (4, 9), (6, 6). Note that (6, 6) only contributes 1 factor, thus giving n an odd number of factors.
- Question: How many perfect squares are there?
    - Answer: There are 10 perfect squares. You could count them (1, 4, 9, 16, 25, 36, 49, 64, 81, 100), or you could simply realize that you can take the numbers 1 through 10 and square them (1 * 1, 2 * 2, 3 * 3, ... , 10 * 10).
Therefore, there are 10 lockers open.