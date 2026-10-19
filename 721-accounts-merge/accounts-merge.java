class Solution {
    public int size[];
    public int par[];
    public int find(int x){
        if(par[x] ==(x)){
            return x;
        }
        par[x] = find(par[x]);
        return par[x];
    }
    public boolean union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB){
            return false;
        }
        if(size[rootA] < size[rootB]){
            par[rootA] = rootB;
            size[rootB] +=size[rootA];
        }else{
            par[rootB] = rootA;
            size[rootA] +=size[rootB];
        }
        return true;
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        par = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            size[i] = 1;
            par[i] =i;
        }


        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(map.containsKey(mail)){
                    union(i,map.get(mail));
                }else{
                    map.put(mail,i);
                }
            }
        }


        HashMap<Integer,List<String>> merged = new HashMap<>();

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            int root = find(entry.getValue());
            String email = entry.getKey();

            merged.putIfAbsent(root,new ArrayList<>());
            merged.get(root).add(email);


        }


        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<Integer,List<String>> entry:merged.entrySet()){
            int key = entry.getKey();
            List<String> emails = entry.getValue();
            
            Collections.sort(emails);
            List<String> account = new ArrayList<>();
            account.add(accounts.get(key).get(0));
            account.addAll(emails);
            ans.add(account);
        }
        return ans;
    }
}