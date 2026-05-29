class Solution {

    public void helper(int image[][], int sr,int sc, boolean vis[][], int color, int orgColor){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length ||vis[sr][sc] || image[sr][sc] != orgColor ){
            return;
        }

        vis[sr][sc] = true;
        image[sr][sc] = color;

        //left
        helper(image,sr,sc-1,vis,color,orgColor);

        //right
        helper(image,sr,sc+1,vis,color,orgColor);

        //up
        helper(image,sr-1,sc,vis,color,orgColor);

        //down
        helper(image,sr+1,sc,vis,color,orgColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image,sr,sc,vis,color,image[sr][sc]);
        return image;
    }
}