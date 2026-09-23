class Solution {
    HashMap<String,PriorityQueue<String>> graph = new HashMap<>();
    List<String> result = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
         
         for(List<String> ticket: tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);

            graph.computeIfAbsent(from,k->new PriorityQueue<>()).add(to);

           
         }
          dfs("JFK");
          Collections.reverse(result);
         return result;
    }
    public void dfs(String airport){
        PriorityQueue<String> pq = graph.get(airport);

        while( pq!=null && !pq.isEmpty()){
            String s = pq.poll();

            dfs(s);
        }
        result.add(airport);

    }
}
