//Dutch National Flag
class Solution {
    public void sortColors(int[] nums) {
        int start=0;
        int mid=0;
        int end=nums.length-1;

        while(mid<=end){
            if(nums[mid]==0){
                swap(nums,start,mid);
                start++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else{ //nums[mid]==2
                swap(nums,mid,end);
                end--;
            }
        }        
    }

    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}