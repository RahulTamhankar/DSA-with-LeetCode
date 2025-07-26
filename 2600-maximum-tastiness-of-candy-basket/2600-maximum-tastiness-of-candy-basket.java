class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n=price.length;
        int low=0,high=price[n-1]-price[0];
        int ans=0;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(canSelect(price,k,mid)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }

    private boolean canSelect(int[] price,int k,int minDiff){
        int count=1;
        int last=price[0];

        for(int i=1;i<price.length;i++){
            if(price[i]-last>=minDiff){
                count++;
                last=price[i];
            }
            if(count>=k) return true;
        }
        return false;
    }
}