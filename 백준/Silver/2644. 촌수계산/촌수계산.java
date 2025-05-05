import java.util.*;
import java.io.*;

public class Main {

    static boolean[] visited;
    static List<List<Integer>> family;
    static int answer = -1;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        
        int n, m; 
        int start, end;            

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        family = new ArrayList<>();

        for(int i=0; i<n; i++) {
            family.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken())-1;
        end = Integer.parseInt(st.nextToken())-1;

        m = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            family.get(x).add(y);
            family.get(y).add(x);
        }
        
        dfs(start, end, n);

        System.out.print(answer);
    }

    public static void dfs(int start, int end, int n) {
        if (start == end) {
            answer = sum;
            return;
        }

        List<Integer> list = family.get(start); 
        visited[start] = true;

        for(int p : list) {
            if (!visited[p]) {
                sum++;
                dfs(p, end, n);
                sum--;
            }
        }

    }
}