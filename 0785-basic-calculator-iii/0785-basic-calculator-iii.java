class Solution {
    public int calculate(String s) {
        return helper(s+"+",new int[]{0});
    }

    private int helper(String s,int[] index){
        int result=0,lastNum=0,currentNum=0;
        char operator='+';

        while(index[0]<s.length()){
            char c=s.charAt(index[0]);
            if(Character.isDigit(c)){
                currentNum=currentNum*10+(c-'0');
                index[0]++;
            }
            else if(c=='('){
                index[0]++;
                currentNum=helper(s,index); //recurse
            }
            else{
                if(operator=='+'){
                    result+=lastNum;
                    lastNum=currentNum;
                }else if(operator=='-'){
                    result+=lastNum;
                    lastNum=-currentNum;
                }else if(operator=='*'){
                    lastNum=lastNum*currentNum;
                }else if(operator=='/'){
                    lastNum=lastNum/currentNum;
                }
                operator=c;
                currentNum=0;
                index[0]++;

                if(c==')'){
                    break;
                }
            }
        }
        return result+lastNum;
    }
}

// Initial call
// calculate("2*(3+4)")
// → helper("2*(3+4)+", index=[0])
// ✅ Appended '+' to force processing of the last number.

// The index[0] in the provided Java Solution class is used as a mutable, shared pointer to the current position in the input string s.

// Here's a breakdown of why and how index[0] is used:

// Passing by Reference (Simulated): In Java, primitive types (like int) are passed by value. This means if you passed int index to the helper function, any changes to index inside helper would not affect the index in the calling function.

// By wrapping the integer index inside an array new int[]{0}, you are essentially passing an object reference. When index[0] is modified within the helper function (e.g., index[0]++), it modifies the actual integer value at the first position of the array that was passed from the caller. This change is then visible to all levels of the recursion.

// Maintaining Global Position Across Recursion: The calculate method is designed to parse an arithmetic expression, which can include parentheses and nested sub-expressions. When helper encounters an opening parenthesis '(', it makes a recursive call to helper to evaluate the sub-expression within the parentheses.

// Without index[0]: If a simple int were used for the index, the recursive call would start parsing from index = 0 of the entire string s again, leading to incorrect results.

// With index[0]: Because index[0] is a shared reference, when the recursive call to helper returns after parsing the sub-expression, index[0] will have been advanced past the closing parenthesis ')' of that sub-expression. This allows the calling helper function to resume parsing from the correct position in the main string s where it left off.

// Iteration Control:

// while(index[0]<s.length()): This condition ensures that the parsing continues as long as the current index is within the bounds of the string.

// index[0]++: After processing a character (digit, operator, or parenthesis), the index[0] is incremented to move to the next character in the string.

// In essence, index[0] acts like a global cursor that keeps track of the parsing progress across all recursive calls, allowing the function to correctly navigate and evaluate complex expressions with nested parentheses.

// You want a dry run of the calculate method using the example 2*(3+4)? Let's trace the execution step by step.

// Dry Run: calculate("2*(3+4)")
// Initial Call
// calculate("2*(3+4)") is called.

// Inside calculate, it calls helper("2*(3+4)+", new int[]{0}).

// s becomes "2*(3+4)+".

// index is [0].

// Entering helper("2*(3+4)+", index=[0]) - First Level
// result = 0

// lastNum = 0

// currentNum = 0

// operator = '+'

// Loop 1: index[0] is 0, c is '2'

// Character.isDigit('2') is true.

// currentNum = 0 * 10 + ( '2' - '0' ) = 2.

// index[0] becomes 1.

// Loop 2: index[0] is 1, c is '*'

// Character.isDigit('*') is false.

// c is not '('.

// The else block executes:

// operator is '+', so result += lastNum (0 + 0 = 0). result is 0.

// lastNum = currentNum (2). lastNum is 2.

// operator becomes c (''). operator is ''.

// currentNum becomes 0.

// index[0] becomes 2.

// c is not ')'.

// This dry run illustrates how index[0] is crucial for maintaining the parsing position across recursive calls, ensuring that the main helper function resumes processing the string exactly where the nested helper call finished.







