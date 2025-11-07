# House Robber

**LeetCode #198** | **Medium**

## Problem

You're robbing houses on a street. Each house has money, but you can't rob two adjacent houses (alarms will go off!).

Given an array where each element is the money in that house, find the maximum you can rob.

**Example:**
```
Input: [2, 7, 9, 3, 1]
Output: 12
Explanation: Rob house 0 ($2) + house 2 ($9) + house 4 ($1) = $12
```

---

## Insight

At each house, I have two choices:
1. Rob it: Take current house money + best total from 2 houses back (can't use adjacent house)
2. Skip it: Keep the best total from the previous house
3. I pick whichever gives more money.

## My solution 

I use Dynamic Programming with two variables:
- `maxTwoBack`: Best money I could have 2 houses ago
- `maxOneBack`: Best money I could have 1 house ago
- `maxCurrent`: Best money at current house
- **Formula:** `maxCurrent = max(maxOneBack, maxTwoBack + nums[i])`

Then I slide the window forward for the next house.

Reason why DP works best here is because this problem has:
a) Optimal Substructure
The solution to the problem depends on solutions to smaller subproblems.
Max money at house i = depends on max money at house i-1 and i-2
b) Overlapping Subproblems
Without DP, we'd recalculate the same houses multiple times. For example, finding the best solution for house 5 requires knowing the best for house 3 and 4, and finding the best for house 4 also needs house 3 - that's overlap!
## How it works

**Input:** `[2, 7, 9, 3, 1]`
```
Step 1 - House 0 ($2):
  maxCurrent = max(0, 0 + 2) = 2
  Decision: Rob 
  State: maxTwoBack=0, maxOneBack=2

Step 2 - House 1 ($7):
  maxCurrent = max(2, 0 + 7) = 7
  Decision: Rob 
  State: maxTwoBack=2, maxOneBack=7

Step 3 - House 2 ($9):
  maxCurrent = max(7, 2 + 9) = 11
  Decision: Rob  (houses 0 and 2)
  State: maxTwoBack=7, maxOneBack=11

Step 4 - House 3 ($3):
  maxCurrent = max(11, 7 + 3) = 11
  Decision: Skip (keeping previous best)
  State: maxTwoBack=11, maxOneBack=11

Step 5 - House 4 ($1):
  maxCurrent = max(11, 11 + 1) = 12
  Decision: Rob  (houses 0, 2, and 4)
  State: maxTwoBack=11, maxOneBack=12


**Result:** $12 (robbed houses 0, 2, and 4)

 Time and Space Complexity
Time Complexity: O(n)

We make a single pass through the array
Each iteration does constant-time operations (comparison, assignment)
No nested loops
Where n = number of houses

Space Complexity: O(1)

Only using 3 variables (maxTwoBack, maxOneBack, maxCurrent)
Space doesn't grow with input size




---
## My Code

See [HouseRobber.java](src/HouseRobber.java) for full implementation.

## What I Learned

- How to optimize DP from O(n) space to O(1) space
- The "sliding window" pattern for tracking previous states
- Breaking down complex problems into simple decisions at each step
