class Solution {
    public int largestRectangle(int height[]){
        int n = height.length;
        Stack<Integer> s  = new Stack<>();
        int leftMin[] = new int[n];
        int rightMin[] = new int[n];

        for(int i=0;i<n;i++){
            while(!s.isEmpty() && height[i] <=height[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                leftMin[i] = -1;
            }else{
                leftMin[i] = s.peek();
            }
            s.push(i);
        }
    



        while(!s.isEmpty()){
            s.pop();
        }





        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && height[i] <=height[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                rightMin[i] = n;
            }else{
                rightMin[i] = s.peek();
            }
            s.push(i);
        }
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int width = rightMin[i]-leftMin[i]-1;
            int area = height[i] *width;
            maxArea = Math.max(area,maxArea);
        }

        return maxArea;


    }
    public int maximalRectangle(char[][] matrix) {
        int[] height = new int[matrix[0].length];

        int maxArea = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                    height[j]++;
                }else{
                    height[j] = 0;
                }
            }
            int area = largestRectangle(height);
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
        



    }
}