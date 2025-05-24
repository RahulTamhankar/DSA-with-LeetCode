class Solution {

    public void solve(int[] candidates,int target,List<Integer> curr, List<List<Integer>> result,int idx){
        if(target<0){ //to handle case when i/p-> {100,2} ,target=1 => ie. 1-100=-99
            return;
        }
        if(target==0){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1]){  //i>idx for inital iteration case where idx=0, atleast that we need to explore
                continue;
            }  
            curr.add(candidates[i]);
            solve(candidates,target-candidates[i],curr,result,i+1);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>  result=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates,target,curr,result,0);
        return result;   
    }
}

//Note - Whenever you want to avaoid duplicate combinations in recursion,  sort the array and check  whether the i-1!=i, only then move explore i otherwise skip and go to i+1


