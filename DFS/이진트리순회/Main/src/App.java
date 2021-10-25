
import java.util.*;

class Node{
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}

public class App {

    public Node root;
    public void recursive(Node root) {
        if (root == null)
            return;
        else {
            recursive(root.lt);
            System.out.println(root.data + " ");
            recursive(root.rt);
        }
    }

    public static void main(String[] args) throws Exception {
        App tree = new App();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.recursive(tree.root);
    }
}
