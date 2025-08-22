import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        int answer = 0;
        
        while(pq.peek() < K) {
            if (pq.size() == 1) {
                answer = -1;
                break;
            }
            
            int num1 = pq.poll();
            int num2 = pq.poll();
            
            pq.offer(num1 + (num2 * 2));
            answer++;
        }
        
        return answer;
    }
}