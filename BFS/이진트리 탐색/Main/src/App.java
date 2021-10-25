
import java.util.*;

public class App {

    Node root;

    public static void recursive(Node root){
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        int L = 0;

        while(!que.isEmpty()){
            int len = que.size();
            System.out.print(L + " : ");
            for(int i = 0; i < len; i ++){
                Node curr = que.poll();
                System.out.print(curr.data + "  ");
                if(curr.lt != null) que.offer(curr.lt);
                if(curr.rt != null) que.offer(curr.rt);
            }
            L ++;
        }
    }

    public static void main(String[] args) throws Exception {
        Node tree = new Node(1);
        tree.lt = new Node(2);
        tree.rt = new Node(3);
        tree.lt.lt = new Node(4);
        tree.lt.rt = new Node(5);
        tree.rt.lt = new Node(6);
        tree.rt.rt = new Node(7);
        recursive(tree);
    }
}

class Node{
    int data;
    Node lt, rt;

    public Node(int data){
        this.data = data;
        lt = rt = null;
    }
}
