import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        List<Integer> list = new ArrayList<>();
        
        String[] str = br.readLine().split(" ");
        
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(str[i]);
            
            if (list.isEmpty() || num > list.get(list.size()-1)) {
                list.add(num);
            } else {
                int index = biarySearch(list, num);
                list.set(index, num);
            }
            
        }

        System.out.println(list.size());
    }

    public static int biarySearch(List<Integer> list, int num) {
        int startIdx = 0;
        int endIdx = list.size();
        
        while(startIdx < endIdx) {
            int mid = (endIdx + startIdx) / 2;

            if (list.get(mid) < num) {
                startIdx = mid + 1;
            } else {
                endIdx = mid;
            }
            
        }

        return startIdx;
    }
}