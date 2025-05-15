import java.util.*;

class Solution {
    
    static List<int[]> list;
    static int[] reverse;
    
    public int solution(int[] people, int limit) {
    
        reverse = new int[people.length];
        
        reverseOrder(people);
        
        list = new ArrayList<>();
        
        for(int i=0; i<people.length; i++) {
            list.add(new int[2]);
        }
        
        func(limit);
        
        int answer = 0;
        
        for(int[] arr : list) {
            if (arr[0] > 0 && arr[1] >= 0) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void func(int limit) {
        
        for(int i=0; i<reverse.length; i++) {
            int[] array;
            
            if (reverse[i] > limit / 2) {
                array = list.get(i);
                array[0] = reverse[i];
            } else {
                for(int j=0; j<list.size(); j++) {
                    array = list.get(j);
                    
                    if (array[1] == 0 && array[0] + reverse[i] <= limit) {
                        if (array[0] > 0) {
                            array[1] = reverse[i];
                            break;
                        } else {
                            array[0] = reverse[i];
                            break;
                        }
                    }
                }
            }   
        }
    }
    
    public void reverseOrder(int[] people) {
        Arrays.sort(people);
        
        int index = 0;
        for(int i=people.length-1; i>= 0; i--) {
            reverse[index++] = people[i];
        }
    }
    
}