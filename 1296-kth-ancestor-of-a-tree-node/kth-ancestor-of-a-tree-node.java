class TreeAncestor {
    int log =1;
    int dp[][];
    public TreeAncestor(int n, int[] parent) {
        while(1<<log<=n){
            log++;
        }
        dp = new int[log][n];
        dp[0] = parent.clone();
        for(int j=1;j<log;j++){
            for(int node = 0;node<n;node++){
                int prev = dp[j-1][node];
                if(prev == -1){
                    dp[j][node] = -1;
                }else{
                    dp[j][node] = dp[j-1][prev];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for(int j=0;j<log;j++){
            if((k &(1<<j)) !=0){
                node = dp[j][node];
            }
            if(node == -1){
                return -1;
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */