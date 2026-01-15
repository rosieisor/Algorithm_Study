import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[N+1];

        for(int i=2; i<=N; i++) {
            arr[i] = i;
        }

        for(int i=2; i<=N; i++) {
            if (arr[i] == 0) {
                continue;
            }

            for(int j=i*2; j<=N; j+=i) {
                arr[j] = 0;
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i=2; i<=N; i++) {
            if (arr[i] != 0) {
                list.add(i);
            }
        }
        
        long[] sum = new long[list.size()];
        
        Map<Long, Long> map = new HashMap<>();
        
        for(int i=0; i<list.size(); i++) {
            if (i == 0) {
                sum[i] = (long)list.get(i);
            } else {
                sum[i] = (long)(sum[i-1] + list.get(i));
            }
            
            map.put((long)sum[i], (long)sum[i]);
        }

        int result = 0;

        for(int i=sum.length-1; i > -1; i--) {
            if (sum[i] == N) {
                result++;
                continue;
            }
            
            if (map.get(sum[i] - N) != null) {
                result++;
            }
        }

        System.out.println(result);
    }
}