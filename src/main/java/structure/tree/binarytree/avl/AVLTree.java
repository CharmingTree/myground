package structure.tree.binarytree.avl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AVLTree {

    public Node root;
    private StringBuilder sb;

    public void preOrder(Node node) {
        if (node == null)
            return;

        if (node.equals(root))
            sb = new StringBuilder();
        sb.append(node.data + ", ");
        preOrder(node.left);
        preOrder(node.right);

        if (node.equals(root)) {
            log.info(sb.toString());
        }
    }

    public int getHight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.hight;
    }

    public int getBalance(Node node) {
        if (node == null)
            return 0;
        return getHight(node.left) - getHight(node.right);
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.hight = Math.max(getHight(x.left), getHight(x.right)) + 1;
        y.hight = Math.max(getHight(y.left), getHight(y.right)) + 1;

        return y;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.hight = Math.max(getHight(y.left), getHight(y.right)) + 1;
        x.hight = Math.max(getHight(x.left), getHight(x.right)) + 1;

        return x;
    }

    public Node insertNode(Node node, int data) {

        // when root is null
        if (node == null) {
            node = new Node(data);
            return node;
        }

        if (node.data > data) {
            node.left = insertNode(node.left, data);
        }
        else if (node.data < data) {
            node.right = insertNode(node.right, data);
        }
        else {
            // 삽입 값과 같을 경우 node 리턴
            return node;
        }

        node.hight = Math.max(getHight(node.left), getHight(node.right)) + 1;

        int balance = getBalance(node);


        if (balance > 1 && node.left.data > data) {
            return rightRotate(node);
        }
        else if (balance < -1 && node.right.data < data) {
            return leftRotate(node);
        }
        else if (balance > 1 && node.left.data < data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        else if (balance < -1 && node.right.data > data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }


        return node;
    }

    public Node deleteNode(Node node, int data) {
        if (node == null)
            return node;

        if (node.data > data) {
            node.left = deleteNode(node.left, data);
        }
        else if (node.data < data) {
            node.right = deleteNode(node.right, data);
        }
        else {
            if (node.left == null || node.right == null) {

                Node temp = null;

                if (temp == node.left) {
                    temp = node.right;
                }
                else
                    temp = node.left;

                if (temp == null) {
                    temp = node;
                    node = null;
                }
                else {
                    node = temp;
                }
            }
            else {
                Node temp = getMinValueNode(node.right);

                node.data = temp.data;

                node.right = deleteNode(node.right, temp.data);
            }
        }

        if (node == null)
            return node;

        node.hight = Math.max(getHight(node.left), getHight(node.right)) + 1;

        int balance = getBalance(node);

        log.info("node : {}, balance : {}, height : {}", node.data, balance, node.hight);

        if (balance > 1 && getBalance(node.left) >= 0) {
            log.info("case #1");
            return rightRotate(node);
        }

        if (balance < -1 && getBalance(node.right) <= 0) {
            log.info("case #2");
            return leftRotate(node);
        }

        if (balance > 1 && getBalance(node.left) < 0) {
            log.info("case #3");
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && getBalance(node.right) > 0) {
            log.info("case #4");
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void preOrder2(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder2(node.left);
            preOrder2(node.right);
        }
    }

    private Node getMinValueNode(Node node) {
        return node.left == null ? node : getMinValueNode(node.left);
    }
}
