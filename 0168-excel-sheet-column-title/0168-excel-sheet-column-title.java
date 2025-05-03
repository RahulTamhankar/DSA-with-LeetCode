class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res=new StringBuilder();
        while(columnNumber>0){
            columnNumber--; 
            res.insert(0,(char)((columnNumber%26)+'A'));
            columnNumber/=26;
        }
        return res.toString();
    }
}

// 2. columnNumber /= 26: Actually moves to next digit
// Purpose:
// After you've "used up" the least significant letter, you shift your focus left:

// Think of it like base conversion:
// If you're converting 123 in base 10:

// 123 % 10 = 3 → rightmost digit

// 123 / 10 = 12 → chop off last digit

// Similarly, in base-26 (Excel-style):

// java
// Copy
// Edit
// columnNumber /= 26;  // Shifts to the left digit
// Example:
// After step 1:

// columnNumber = 700

// You handled the 'Y' (700 % 26 = 24 → 'Y')

// Now:

// java
// Copy
// Edit
// columnNumber /= 26;  // 700 / 26 = 26
// Next round:

// columnNumber-- → 25

// 25 % 26 = 25 → 'Z'

// Done.

// ✅ Why 700 doesn't become 699 here
// 700 became 699 because of columnNumber--, not because of division.

// columnNumber /= 26 is after that — it simply divides by 26 to get the next significant "digit" in the pseudo-base-26 system.

// \U0001f501 Sequence Recap for columnNumber = 701:
// Step	Operation	Result
// Init		701
// 1	--	700
// 2	% 26	24 → 'Y'
// 3	/= 26	700 / 26 = 26
// 4	--	25
// 5	% 26	25 → 'Z'
// 6	/= 26	25 / 26 = 0
// Done	Result	'ZY'

