import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<int[]> dp = new ArrayList<>();

        dp.add(new int[]{1, 0}); 

        for(int i=1; i<=N; i++) {
            int[] arr = dp.get(i-1);
            int a = arr[1];
            int b = arr[0] + arr[1];
            dp.add(new int[]{a, b});
        }

        int[] result = dp.get(N);
        
        System.out.println(result[0] + " " + result[1]);
    }
}