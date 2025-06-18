import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void insert(Node node) {
        root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node) {
        int data = node.getData();

        if (root == null) {
            root = node;
            return root;
        }

        int rdata = root.getData();

        if (rdata > data) {
            root.setLeft(insertHelper(root.getLeft(), node));
        } else if (rdata < data) {
            root.setRight(insertHelper(root.getRight(), node));
        }

        return root;
    }

    public void display() {
        displayHelper(root, 0);
    }

    private void displayHelper(Node root, int level) {
        if (root == null) return;

        displayHelper(root.getRight(), level + 1);
        System.out.println("  ".repeat(level) + root.getData());
        displayHelper(root.getLeft(), level + 1);
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(Node root, int data) {
        if (root == null) return false;

        int rdata = root.getData();

        if (rdata == data) {
            return true;
        } else if (rdata > data) {
            return searchHelper(root.getLeft(), data);
        } else {
            return searchHelper(root.getRight(), data);
        }
    }

    public void remove(int data) {
        if (search(data)) {
            root = removeHelper(root, data);
        }
    }

    private Node removeHelper(Node root, int data) {
        int rdata = root.getData();

        if (rdata > data) {
            root.setLeft(removeHelper(root.getLeft(), data));
        } else if (rdata < data) {
            root.setRight(removeHelper(root.getRight(), data));
        } else {
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
            } else if (root.getRight() != null) {
                root.setData(successor(root));
                root.setRight(removeHelper(root.getRight(), root.getData()));
            } else {
                root.setData(predecessor(root));
                root.setLeft(removeHelper(root.getLeft(), root.getData()));
            }
        }

        return root;
    }

    private int predecessor(Node root) {
        root = root.getLeft();
        while (root.getRight() != null) {
            root = root.getRight();
        }

        return root.getData();
    }

    private int successor(Node root) {
        root = root.getRight();
        while (root.getLeft() != null) {
            root = root.getLeft();
        }

        return root.getData();
    }

    private void inOrder(Node root, List<Integer> list) {
        if (root == null) return;

        inOrder(root.getLeft(), list);
        list.add(root.getData());
        inOrder(root.getRight(), list);
    }

    public void balance() {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        root = balanceHelper(list, 0, list.size() - 1);
    }

    private Node balanceHelper(List<Integer> list, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;

        Node node = new Node(list.get(mid));

        node.setLeft(balanceHelper(list, start, mid - 1));
        node.setRight(balanceHelper(list, mid + 1, end));

        return node;
    }

    public void fromList(List<Integer> list) {
        Collections.sort(list);
        root = balanceHelper(list, 0, list.size() - 1);
    }
}
