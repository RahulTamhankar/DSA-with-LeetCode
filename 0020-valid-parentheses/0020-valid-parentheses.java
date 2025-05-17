class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(!stack.isEmpty()){
                char last=stack.peek();
                if(isPair(last,cur)){
                    stack.pop();
                    continue;
                }
            }
            stack.push(cur);
        }
        return stack.isEmpty();

    }
    private boolean isPair(char last,char cur){
            return (last=='(' && cur==')') ||
            (last =='{' && cur=='}') ||
            (last=='[' && cur==']');
        }
}

// Why not return false immediately if a pair doesn't match?
//Because not every character comes with its pair immediately.
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
		
// 	Stack<Character>charStack=new Stack<>();
	
// 	for(int i=0;i<s.length();i++){
// 		char curr=s.charAt(i);
// 		if(!charStack.isEmpty()){
// 			char last=charStack.peek();
// 			if(isPair(last,curr)){
// 				stack.pop();		
// 				continue;
// 			}
// 			return false;    // WONT WORK
// 		}
// 		stack.offer(curr);
// 	}
// 	return true;

//
// \U0001f525 Your Real Question:
// “If two characters don’t make a valid pair, why not return false immediately?”

// Let’s walk through it!

// ✅ Example That Works: "([])"
// Characters come in one at a time:

// Step	Char	Stack (top is right)	What happens
// 1	(	(	push
// 2	[	(, [	push
// 3	]	(	[ matches ] → pop ✅
// 4	)	empty	( matches ) → pop ✅

// ✅ Stack is empty → all brackets matched in correct order → return true.

// ❌ Now What If You Return false too Early?
// Imagine your wrong code says:

// “If the current character doesn't match the last one, return false.”

// That would mean at Step 2 ([) vs Step 1 ((), they don’t match → return false immediately ❌

// But that’s wrong, because:

// ( will be matched with ) later.

// [ will be matched with ] now.

// So you have to wait until you get a closing bracket, then check if it matches the last opened one.
	
//     }
//     private Boolean isPair(char last,char curr){
	
// 		return (curr=="(" && last==")") || (curr=="[" && last=="]")
// 				|| (curr=="{" && last=="}") 
		
//     }	
// }