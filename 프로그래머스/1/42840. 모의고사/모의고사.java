class Solution {
    public int[] solution(int[] answers) {
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] result = new int[3];
        int index;
        
        for(int i=0; i<answers.length; i++) {
            
            index = i % 5;
            if (answers[i] == p1[index]) {
                result[0]++;
            }
            
            index = i % 8;
            if (answers[i] == p2[index]) {
                result[1]++;
            }
            
            index = i % 10;
            if (answers[i] == p3[index]) {
                result[2]++;
            }
        }
        
        int max = 0;
        for(int i=0; i<result.length; i++) {
            max = Math.max(max, result[i]);
        }
        
        int size = 0;
        for(int i=0; i<result.length; i++) {
            if (result[i] == max) {
                size++;
            }
        }
        
        index = 0;
        int[] answer = new int[size];
        for(int i=0; i<result.length; i++) {
            if (result[i] == max) {
                answer[index++] = i + 1;
            }
        }
        
        return answer;
    }
}