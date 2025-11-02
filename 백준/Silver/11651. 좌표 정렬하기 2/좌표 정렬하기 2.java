import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);

            list.add(new Node(x, y));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.y > o2.y) {
                return 1;
            } else if (o1.y == o2.y) {
                if (o1.x > o2.x) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        });

        for(Node node : list) {
            sb.append(node.x + " " + node.y).append("\n");
        }

        System.out.print(sb.toString());
    }
}

class Node {
    int x;
    int y;

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}