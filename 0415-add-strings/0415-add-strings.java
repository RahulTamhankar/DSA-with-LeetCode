class Solution {
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1,j=num2.length()-1;
        int carry=0;
        StringBuilder result= new StringBuilder();

        while(i>=0 || j>=0 || carry!=0){
            int digit1=i>=0 ? num1.charAt(i)-'0':0;
            int digit2=j>=0 ? num2.charAt(j)-'0':0;

            int total=digit1+digit2+carry;
            carry=total/10;
            result.append(total%10);
            i--;
            j--;
        }
        return result.reverse().toString();
    }
}

// Example
// Let’s say:

// java
// Copy
// Edit
// num1 = "123"
// num2 = "89"
// We'd perform:

// 3 + 9 = 12 → append 2, carry 1

// 2 + 8 + 1 = 11 → append 1, carry 1

// 1 + 0 + 1 = 2 → append 2

// result = "2112" → reverse → "212"

// ✅ Final output: "212"