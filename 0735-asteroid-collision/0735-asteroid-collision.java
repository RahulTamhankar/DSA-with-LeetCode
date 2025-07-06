import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();

        for(int a:asteroids){
            while(!st.isEmpty() && a<0 && st.peek()>0){
                int sum=a+st.peek();
                if(sum<0){
                    st.pop();
                }else if(sum>0){
                    a=0;
                }else{
                    st.pop();
                    a=0;
                }
            }
            if(a!=0){
                st.push(a);
            }
        }

        int[] result=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            result[i]=st.pop();
        }
        return result;
    
    }
}




// import java.util.*;

// class Solution {
//     public int[] asteroidCollision(int[] asteroids) {
//         List<Integer> st = new ArrayList<>();

//         for (int a : asteroids) {
//             boolean destroyed = false;

//             while (!st.isEmpty() && a < 0 && st.get(st.size() - 1) > 0) {
//                 int sum = a + st.get(st.size() - 1);

//                 if (sum < 0) {
//                     st.remove(st.size() - 1); // top asteroid destroyed
//                 } else if (sum > 0) {
//                     destroyed = true; // current asteroid destroyed
//                     break;
//                 } else {
//                     st.remove(st.size() - 1); // both destroyed
//                     destroyed = true;
//                     break;
//                 }
//             }

//             if (!destroyed) {
//                 st.add(a);
//             }
//         }

//         // Convert ArrayList to int[]
//         int[] res = new int[st.size()];
//         for (int i = 0; i < st.size(); i++) {
//             res[i] = st.get(i);
//         }

//         return res;
//     }
// }



// The Asteroid Collision problem can be considered a variation of the classic Balancing Symbols problem, although it might not be immediately apparent.

// The Balancing Symbols problem is a classic problem where you have a sequence of symbols, such as parentheses, and you want to determine if they are "balanced". That is, for every opening symbol, there should be a corresponding closing symbol. One common way to solve this problem is by using a stack data structure.

// In the case of the Asteroid Collision problem, the "opening" and "closing" symbols are replaced by positive and negative integers respectively, with positive integers moving right and negative integers moving left. We can imagine the problem as trying to determine if the movements of the asteroids are "balanced", similar to the parentheses in the Balancing Symbols problem. That is, for every right-moving asteroid, is there a corresponding left-moving asteroid that would collide with it, and vice versa.

// Therefore, the stack can be used in a similar way: When we encounter a right-moving asteroid (positive integer), we push it into the stack. When we encounter a left-moving asteroid (negative integer), we compare it with the top of the stack. If the left-moving asteroid is larger, we pop the right-moving asteroid from the stack (analogous to matching and removing a pair of opening and closing symbols), and continue the process until the stack is empty or the top of the stack is a left-moving asteroid.

// Thus, while the problems are different in their specific details, they share a common structure that allows us to apply similar problem-solving strategies. It's this underlying structure that allows us to identify the Asteroid Collision problem as a variation of the Balancing Symbols problem.

