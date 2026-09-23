class Solution {
    public class Pair{
        String node;
        double wt;
        public Pair(String node,double wt){
            this.node = node;
            this.wt = wt;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        HashMap<String,List<Pair>> graph = new HashMap<>();
        for(int i=0;i<n;i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double  wt = values[i];
            graph.putIfAbsent(a,new ArrayList<>());
            graph.putIfAbsent(b,new ArrayList<>());

            graph.get(a).add(new Pair(b,wt));
            graph.get(b).add(new Pair(a,1.0/wt));            
        }

        double ans[] = new double[queries.size()];
        for(int j=0;j<queries.size();j++){
            String curr = queries.get(j).get(0);
            String tar = queries.get(j).get(1);

            if(!graph.containsKey(curr) || !graph.containsKey(tar)){
                ans[j] = -1.0;
                continue;
            }
            Set<String> vis = new HashSet<>();
            ans[j] =dfs(graph,curr,tar,1.0,vis);
        }
        return ans;
    }
    public double dfs(HashMap<String,List<Pair>> graph,String curr,String tar,double product,Set<String> vis){
        if(curr.equals(tar)){
            return product;
        }
        vis.add(curr);

        for(Pair edge:graph.get(curr)){
            String nxt = edge.node;
            double wt = edge.wt;
           
            if(vis.contains(nxt)){
               continue;
            }
            double ans =  dfs(graph,nxt,tar,product*wt,vis);

            if(ans!=-1.0){
                return ans;
            }
        }
        return -1.0;
    }
}