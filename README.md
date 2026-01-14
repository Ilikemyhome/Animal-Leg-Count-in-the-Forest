# Animal-Leg-Count-in-the-Forest

Problem Statement
Given an array of animal names, return the number of animals that have exactly four legs.
Example:
Input: ["lion", "monkey", "deer", "snake", "elephant"]
Output: 3

Clarifying Questions
These are the questions I would ask in an interview to ensure full understanding:
- Should capitalization matter?
→ I will treat input as case‑insensitive.
- What should happen with unknown animals?
→ Unknown animals are treated as having 0 legs.
- Can the input array be empty?
→ Yes, and the result should be 0.
- Can the input contain duplicates?
→ Yes, each occurrence counts.
- Do we need to handle null values?
→ For this assignment, we assume no nulls.

Approach
 Data Structure Choice: HashSet<String>
A HashSet provides O(1) average lookup time, making it ideal for checking whether an animal belongs to the “four‑legged” group.
 Steps
- Create a HashSet of known four‑legged animals.
- Loop through the input array.
- Convert each animal to lowercase.
- Check membership in the HashSet.
- Increment the counter when matched.
- Return the final count.
This approach is clean, readable, and efficient.

 Flowchart
          ┌──────────────────────┐
          │   Start Program      │
          └──────────┬───────────┘
                     ↓
        ┌────────────────────────────┐
        │   Receive animals[] input  │
        └──────────┬─────────────────┘
                   ↓
     ┌───────────────────────────────┐
     │     Initialize count = 0      │
     └──────────┬────────────────────┘
                ↓
   ┌────────────────────────────────────┐
   │ For each animal in animals[]       │
   └──────────┬─────────────────────────┘
              ↓
   ┌────────────────────────────────────┐
   │    Convert animal to lowercase     │
   └──────────┬─────────────────────────┘
              ↓
   ┌────────────────────────────────────┐
   │ Is animal in fourLegs HashSet?     │
   └───────┬───────────────┬───────────┘
           │Yes             │No
           ↓                ↓
 ┌────────────────┐     ┌──────────────┐
 │ count++         │     │ continue     │
 └───────┬─────────┘     └──────┬──────┘
         ↓                      ↓
         ┌──────────────────────────────┐
         │ After loop, return count     │
         └──────────────────────────────┘



 Time & Space Complexity
Time Complexity: O(n)
- We loop through the array once → n operations
- Each HashSet lookup is O(1)
- Total:
O(n)
Space Complexity: O(1)
- The HashSet contains a fixed number of animals (6)
- No additional data structures grow with input size
- Total:
O(1)

 Optimization Discussion
Original Solution
- Uses a HashSet for O(1) lookups
- Clean and readable
- Already optimal in time complexity
Possible Optimization: Switch Statement



Trade‑offs
___________________________________________________________________________________
|HashSet  |Easy to maintain, scalable, readable   | Slight constant space overhead | 
|__________________________________________________________________________________|
|Switch   |Removes HashSet → slightly lower space | Harder to update, less clean   | 
|__________________________________________________________________________________|


Conclusion
The HashSet version is the best balance of clarity, maintainability, and performance.

Unit Tests (JUnit 5)
 Normal Cases (3)
  - Mixed animals
  - Multiple four‑legged animals
  - Repeated animals
 Edge Cases (3)
  - Uppercase / mixed case
  - No four‑legged animals
  - All four‑legged animals
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CountLegsTest {

    @Test
    void countFourLegs() {
        String[] test1 = {"frog", "horse", "spider", "ant"}; // 1
        String[] test2 = {"frog", "horse", "spider", "ant","lion", "monkey", "deer", "snake", "elephant"}; // 4
        String[] test3 = {"horse", "spider", "ant","lion","lion"}; // 3
        String[] extra = {"lion","lion","lion","lion","lion","lion"}; // 6

        String[] test4 = {"FROG","CAT","DOG"}; // 2
        String[] test5 = {"spider", "ant","monkey","frog"}; // 0
        String[] test6 = {"FrOg","CaT","hOrSE","DoG","osTrich","ElePhaNt"}; // 4

        assertEquals(1, CountLegs.countFourLegs(test1));
        assertEquals(4, CountLegs.countFourLegs(test2));
        assertEquals(3, CountLegs.countFourLegs(test3));
        assertEquals(6, CountLegs.countFourLegs(extra));
        assertEquals(2, CountLegs.countFourLegs(test4));
        assertEquals(0, CountLegs.countFourLegs(test5));
        assertEquals(4, CountLegs.countFourLegs(test6));
    }
}



 Final Code
import java.util.Arrays;
import java.util.HashSet;

public class CountLegs {

    public static int countFourLegs(String[] animals) {
        int totalCount = 0;

        HashSet<String> fourLegs = new HashSet<>(Arrays.asList(
                "lion", "deer", "elephant", "horse", "dog", "cat"
        ));

        for (String a : animals) {
            if (fourLegs.contains(a.toLowerCase())) {
                totalCount++;
            }
        }

        return totalCount;
    }
}





