package structure.tree.binarytree.avl;

public class Node {

    int data;
    int hight;
    Node left;
    Node right;


    public Node(int data) {
        this.data = data;
        this.hight = 1;
        this.left = null;
        this.right = null;
    }
}
