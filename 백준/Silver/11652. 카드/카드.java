import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        Map<Long, Integer> map = new HashMap<>();
        int max = 0;
        long min = Long.MAX_VALUE;

        for(int i=0; i<N; i++) {
            long num = Long.parseLong(br.readLine());

            arr[i] = num;

            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            max = Math.max(max, map.get(num));
        }

        for(int i=0; i<N; i++) {
            if (max == map.get(arr[i])) {
                min = Math.min(min, arr[i]);
            }
        }

        System.out.println(min);
    }
}