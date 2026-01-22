import java.util.*;
import java.io.*;

class Main {
    static int N;
    static List<List<Integer>> list;
    static List<Integer> result;
    static int[] input;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        
        N = Integer.parseInt(str[0]);  // 학생 수
        int M = Integer.parseInt(str[1]);  // 비교 횟수

        visited = new boolean[N + 1];   // 방문 체크용
        input = new int[N + 1];   // 진입 차수
        list = new ArrayList<>();
        result = new ArrayList<>();
        
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

        while(result.size() < N) {
            for(int i=1; i<=N; i++) {
                if (!visited[i] && input[i] == 0) {
                    func(i);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<N; i++) {
            sb.append(result.get(i) + " ");
        }

        System.out.print(sb.toString());
    }

    static public void func(int start) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;  // 방문 처리
        queue.offer(start);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for(int num : list.get(node)) {
                input[num]--;
            }

            for(int i=1; i<=N; i++) {
                if(!visited[i] && input[i] == 0) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}