import java.util.*;
import java.io.*;

class Main {

    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] ground;
    static boolean[][] visited;
    static int M, N;
    
    public static void main(String[] args) throws IOException {

        int T, K;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            String[] split = br.readLine().split(" ");
    
            M = Integer.parseInt(split[0]);
            N = Integer.parseInt(split[1]);
            K = Integer.parseInt(split[2]);

            ground = new int[M][N];
            visited = new boolean[M][N];

            for(int j=0; j<K; j++) {
                split = br.readLine().split(" ");
                int X = Integer.parseInt(split[0]);
                int Y = Integer.parseInt(split[1]);

                ground[X][Y] = 1;
            }

            int answer = 0;
            
            for(int j=0; j<M; j++) {
                for(int k=0; k<N; k++) {
                    if (!visited[j][k] && ground[j][k] == 1) {
                        answer++;
                        dfs(j, k);
                    }
                }
            }

            System.out.println(answer);
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<move.length; i++) {
            int mx = x + move[i][0];
            int my = y + move[i][1];
            
            if (mx < M && my < N && mx > -1 && my > -1 && !visited[mx][my] && ground[mx][my] == 1) {
                dfs(mx, my);
            }
        }
    }
}