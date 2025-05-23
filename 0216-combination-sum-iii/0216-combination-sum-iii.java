// class Solution {
//     private void solve(int i,int k,int n,List<Integer> curr,List<List<Integer>> ans){
//         if(n==0 && k==0){
//             ans.add(curr);
//             return;
//         }
//         if(i>9) return;
//         if(n<0 || k<0) return;

//         List<Integer> temp=new ArrayList<>(curr);
//         temp.add(i);
//         solve(i+1,k-1,n-i,temp,ans);
//         solve(i+1,k,n,curr,ans);
//     }
    
//     public List<List<Integer>> combinationSum3(int k, int n) {
//         List<List<Integer>> ans=new ArrayList<>();
//         solve(1,k,n,new ArrayList<>(),ans);
//         return ans;
//     }
// }

class Solution{
    public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans = new ArrayList<>();
    combination(ans, new ArrayList<Integer>(), k, 1, n);
    return ans;
}

private void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
	if (comb.size() == k && n == 0) {
		List<Integer> li = new ArrayList<Integer>(comb);
		ans.add(li);
		return;
	}
	for (int i = start; i <= 9; i++) {
		comb.add(i);
		combination(ans, comb, k, i+1, n-i);
		comb.remove(comb.size() - 1);
	}
}
}

//why do comb.remove(comb.size() - 1);
// Example:
// Suppose you're at comb = [1, 2] and the next number to try is 3.

// You do comb.add(3) → comb = [1, 2, 3]

// You make a recursive call.

// After that call, you need to go back to comb = [1, 2] to try 4, 5, etc.

// So you remove the last element (3) with comb.remove(comb.size() - 1).

