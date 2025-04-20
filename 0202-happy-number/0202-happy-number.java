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