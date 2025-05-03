import java.util.*;

class Solution {

    static List<String> list = new ArrayList<>();
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        dfs(0, "ICN", tickets, "ICN ");
        Collections.sort(list);
        
        return list.get(0).split(" ");
    }
    
    public void dfs(int count, String start, String[][] tickets, String routes) {
        if (count == tickets.length) {
            list.add(routes);
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if (!visited[i] && start.equals(tickets[i][0])) {
                visited[i] = true;
                
                String temp = routes;
                
                routes += tickets[i][1] + " ";
                dfs(count + 1, tickets[i][1], tickets, routes);
                
                routes = temp;
                visited[i] = false;
            }
        }
    }
}