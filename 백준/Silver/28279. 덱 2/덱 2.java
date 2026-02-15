import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> deque = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            String[] str = br.readLine().split(" ");

            int command = Integer.parseInt(str[0]);

            int data = 0;
            
            switch(command) {
                case 1:
                    data = Integer.parseInt(str[1]);

                    deque.offerFirst(data);
                    break;
                case 2:
                    data = Integer.parseInt(str[1]);

                    deque.offer(data);
                    break;
                case 3:
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.poll());
                    }
                    sb.append("\n");

                    break;
                case 4:
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.pollLast());    
                    }
                    sb.append("\n");

                    break;
                case 5:
                    sb.append(deque.size());
                    sb.append("\n");
                    
                    break;
                case 6:
                    if (deque.isEmpty()) {
                        sb.append(1);
                    } else {
                        sb.append(0);    
                    }

                    sb.append("\n");
                    break;
                case 7:
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.peek());    
                    }

                    sb.append("\n");
                    break;
                case 8:
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.peekLast());    
                    }

                    sb.append("\n");
                    break;
            }
        }

        System.out.print(sb.toString());
    }
}