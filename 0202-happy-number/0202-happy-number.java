//Recursion
// class Solution {
//     public boolean isHappy(int n) {
//         if(n==1 || n==7) return true;
//         else if(n<10) return false;
//         else{
//             int sum=0;
//             while(n>0){
//                 int temp=n%10;
//                 sum+=temp*temp;
//                 n=n/10;
//             }
//             return isHappy(sum);
//         }
//     }
// }
//Why only 1 and 7 are happy single-digit numbers?
// Because:

// 1 is trivially happy

// 7 transforms into 1 after a few steps:

// 7² = 49

// 4² + 9² = 97

// 9² + 7² = 130

// 1² + 3² + 0² = 10

// 1² + 0² = 1 ✅



//----------------------------------------------------
//If there is a cycle, no is not happy
// The key idea:
// If there is a cycle, fast and slow will eventually meet.
// If the number is happy, fast will eventually become 1.
//Floyd cycle
class Solution {
    public boolean isHappy(int n){
        int slow=n;
        int fast=getNext(n);

        while(fast!=1 && slow!=fast){
            slow=getNext(slow);
            fast=getNext(getNext(fast));
        }
        return fast==1;
    }

    private int getNext(int n){
        int sum=0;
        while(n>0){
            int digit=n%10;
            sum+=digit*digit;
            n/=10;
        }
        return sum;
    }
}

//\U0001f504 If the number is not happy
// Example: n = 2

// You will end up in a cycle:

// Copy
// Edit
// 2 → 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 → ...
// slow and fast will eventually meet at the same number (!= 1)

// So: while (fast != 1 && slow != fast) breaks when slow == fast

// Return false

