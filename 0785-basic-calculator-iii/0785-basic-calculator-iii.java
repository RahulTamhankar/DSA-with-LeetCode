class Solution {
    public int calculate(String s) {
        return helper(s + "+", new int[]{0});
    }

    private int helper(String s, int[] index){
        int result = 0, lastNum = 0, currentNum = 0;
        char operator = '+';

        while(index[0] < s.length()){
            char c = s.charAt(index[0]);
            if(Character.isDigit(c)){
                currentNum = currentNum * 10 + (c - '0');
                index[0]++;
            }
            else if(c == '('){
                index[0]++;
                currentNum = helper(s, index);
            }
            else{
                if(operator == '+'){
                    result += lastNum;
                    lastNum = currentNum;
                }
                else if(operator == '-'){
                    result += lastNum;
                    lastNum = -currentNum;
                }
                else if(operator == '*'){
                    lastNum = lastNum * currentNum;
                }
                else if(operator == '/'){
                    lastNum = lastNum / currentNum;
                }

                operator = c;
                currentNum = 0;
                index[0]++;

                if(c == ')'){
                    break;
                }
            }
        }

        return result + lastNum;
    }
}










