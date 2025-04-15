import java.util.*;

class Process {
    int index;
    int priority;
    
    Process(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> q = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++) {
            q.add(new Process(i, priorities[i]));
        }
        
        int answer = 0;
                     
        while(!q.isEmpty()) {
            Process current = q.poll();
            
            if (check(current, q)) {
                q.offer(current);
            } else {
                answer++;
                
                if (current.index == location) {
                    break;
                }
            }
        }
        
        return answer;
    }
    
    
    boolean check(Process current, Queue<Process> q) {
        boolean flag = false;
        
        for(int i=0; i<q.size(); i++) {
            Process p = q.poll();
            
            if (!flag && p.priority > current.priority) {
                flag = true;
            }
            
            q.offer(p);
        }
        
        return flag;
        
    }
}