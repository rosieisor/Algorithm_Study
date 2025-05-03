import java.util.*;

class Airport {
    String end;
    boolean visited;
    
    Airport(String end) {
        this.end = end;
        this.visited = false;
    }
}

class Solution {
    
    static Map<String, List<Airport>> map = new HashMap<>();
    static List<String> routes;
    
    public String[] solution(String[][] tickets) {
        init(tickets);
        routes.add("ICN");
        dfs("ICN");
        
        
        String[] answer = new String[routes.size()];
        int index = 0;
        
        for (String s : routes) {
            answer[index++] = s;
        }
    
        return answer;
    }
    
    public void dfs(String start) {
        if (map.get(start) == null) {
            return;
        }
        
        List<Airport> airports = map.get(start);
        
        for(Airport a : airports) {
            if (!a.visited) {
                a.visited = true;
                routes.add(a.end);
                dfs(a.end);
            }
        }
    }
    
    public void init(String[][] tickets) {
        map = new HashMap<>();
        routes = new ArrayList<>();
        
        for(int i=0; i<tickets.length; i++) {
            if (map.get(tickets[i][0]) == null) {
                List<Airport> list = new ArrayList<>();
                list.add(new Airport(tickets[i][1]));
                
                map.put(tickets[i][0], list);
            } else {
                map.get(tickets[i][0]).add(new Airport(tickets[i][1]));
            }
        }
        
        for(String key : map.keySet()) {
            Collections.sort(map.get(key), (o1, o2) -> o1.end.compareTo(o2.end));
        }
    }
}