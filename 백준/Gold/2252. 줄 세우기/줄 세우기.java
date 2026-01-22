import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        
        int N = Integer.parseInt(str[0]);  // 학생 수
        int M = Integer.parseInt(str[1]);  // 비교 횟수

        int[] input = new int[N + 1];   // 진입 차수
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int i=0; i<M; i++) {
            str = br.readLine().split(" ");

            int A = Integer.parseInt(str[0]);
            int B = Integer.parseInt(str[1]);
            list.get(A).add(B);

            input[B]++; 
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++) {
            if (input[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for(int n : list.get(node)) {
                input[n]--;

                if (input[n] == 0) {
                    queue.offer(n);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<N; i++) {
            sb.append(result.get(i) + " ");
        }

        System.out.print(sb.toString());
    }
}