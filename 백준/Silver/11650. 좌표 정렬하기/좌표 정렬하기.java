import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);

            list.add(new int[]{x, y});
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } 

            return o1[0] - o2[0];
        });

        for(int[] arr : list) {
            System.out.println(arr[0] + " " + arr[1]);
        }
    }
}