class Solution {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        for(int i=n-1;i>=0;i--){
            if(digits[i] <9){
                digits[i]++;
                return digits;
            }

            
                digits[i] = 0;
            

            
        }
        int result[] = new int[n+1];
            result[0] = 1;
            return result;
    //     int n= digits.length;
    //     if(n==1){
    //         if(digits[0] == 9){
    //             return new int[]{1,0};
    //         }
    //         digits[n-1] = digits[n-1]+1;
    //         return digits;
    //     }
        
    //         if(digits[n-1] == 9){
    //         digits[n-1] = 0;
    //         digits[n-2] = digits[n-2] +1; 
    //         return digits;
    //     }

    //    digits[n-1] = digits[n-1] + 1;
    //    return digits;



        
        



    }


    public static void main (String args[]){
        int digits[] = {1,2,3};
       System.out.println(Arrays.toString(plusOne(digits)));
    }



}
