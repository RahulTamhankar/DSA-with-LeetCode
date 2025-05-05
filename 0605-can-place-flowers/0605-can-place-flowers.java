class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l=flowerbed.length;
        if(n==0) return true; //no flowers

        for(int i=0;i<l;i++){
            if(flowerbed[i]==0){
                boolean left_khali=(i==0) || (flowerbed[i-1]==0);
                boolean right_khali=(i==l-1) || (flowerbed[i+1]==0);

                //when can i place flower
                if(left_khali && right_khali){
                    flowerbed[i]=1;
                    n--;
                    if(n==0){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}