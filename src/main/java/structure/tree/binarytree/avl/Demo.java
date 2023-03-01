package structure.tree.binarytree.avl;

public class Demo {

    public static void run() {

        AVLTree avlTree = new AVLTree();

        avlTree.root = avlTree.insertNode(avlTree.root, 9);
        avlTree.root = avlTree.insertNode(avlTree.root, 5);
        avlTree.root = avlTree.insertNode(avlTree.root, 10);
        avlTree.root = avlTree.insertNode(avlTree.root, 0);
        avlTree.root = avlTree.insertNode(avlTree.root, 6);
        avlTree.root = avlTree.insertNode(avlTree.root, 11);
        avlTree.root = avlTree.insertNode(avlTree.root, -1);
        avlTree.root = avlTree.insertNode(avlTree.root, 1);
        avlTree.root = avlTree.insertNode(avlTree.root, 2);

        avlTree.preOrder(avlTree.root);

        avlTree.root = avlTree.deleteNode(avlTree.root, 10);
//        avlTree.root = avlTree.deleteNode(avlTree.root, 2);
//        avlTree.root = avlTree.deleteNode(avlTree.root, 6);
//        avlTree.root = avlTree.deleteNode(avlTree.root, 5);

        avlTree.preOrder(avlTree.root);
        avlTree.preOrder2(avlTree.root);
    }
}
