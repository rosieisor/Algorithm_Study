import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int M;
    static int[] selected;
    static Set<String> set = new LinkedHashSet<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        selected = new int[M];
        
        int[] arr = new int[N];

        split = br.readLine().split(" ");

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(arr);

        backTracking(0, 0, arr);

        StringBuilder sb = new StringBuilder();

        Iterator<String> iter = set.iterator();
        
        while(iter.hasNext()) {
            sb.append(iter.next() + "\n");
        }

        System.out.print(sb.toString());
    }

    public static void backTracking(int pick, int start, int[] arr) {
        String str = "";
        
        if (pick == M) {
            for(int i=0; i<selected.length; i++) {
                str += arr[selected[i]] + " ";
            }

            set.add(str);
            
            return;
        }

        for(int i=start; i<N; i++) {
            selected[pick] = i;
            backTracking(pick + 1, i, arr);
        }
    }
}