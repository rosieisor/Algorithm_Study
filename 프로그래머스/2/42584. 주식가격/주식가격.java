class Solution {
    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length-1; i++) {
            int count = 1;
            for(int j=i+1; j<prices.length-1; j++) {
                if (prices[j] < prices[i]) {
                    break;
                }
                count++;
            }
            
            answer[i] = count;
        }
        
        return answer;
    }
}