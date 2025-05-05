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

// Great question — and yes, the line flowerbed[i] = 1; is absolutely necessary for this greedy algorithm to work correctly.

// Here's why:
// This line modifies the flowerbed in-place to simulate actually planting a flower at position i. Without it, the algorithm might count overlapping positions as valid for planting, which violates the problem constraint that no two flowers can be adjacent.

// Example (Why it's needed):
// Suppose the input is:

// java
// Copy
// Edit
// flowerbed = [0, 0, 0, 0, 0], n = 2
// Now let's walk through the algorithm with and without flowerbed[i] = 1;.

// ✅ With flowerbed[i] = 1;:
// At i = 0: both neighbors are empty ⇒ plant flower ⇒ flowerbed becomes [1, 0, 0, 0, 0], n = 1

// At i = 1: flowerbed[i-1] == 1, so can't plant

// At i = 2: both neighbors are 0 ⇒ plant ⇒ flowerbed becomes [1, 0, 1, 0, 0], n = 0 ⇒ return true

// ❌ Without flowerbed[i] = 1;:
// At i = 0: sees neighbors as empty ⇒ think it can plant ⇒ n = 1

// At i = 1: same logic applies since the array is unchanged ⇒ thinks it can plant again ⇒ n = 0 ⇒ return true (but that's invalid, because flowers would be adjacent in the real planting)

