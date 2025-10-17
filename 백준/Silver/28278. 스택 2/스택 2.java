import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<N; i++) {
            String[] str = br.readLine().split(" ");

            switch(str[0]) {
                case "1":
                    deque.offer(Integer.parseInt(str[1]));
                        break;
                case "2":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.pollLast());
                    }
                    sb.append("\n");
                    break;
                case "3":
                    sb.append(deque.size());
                    sb.append("\n");
                    break;
                case "4":
                    if (deque.isEmpty()) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;
                case "5":
                    if(deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.peekLast());
                    }
                    sb.append("\n");
                    break;
            }
            
        }
        
        System.out.println(sb.toString());
    }
}