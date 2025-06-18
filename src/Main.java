import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bb = new BinarySearchTree();
        bb.insert(new Node(1));
        bb.insert(new Node(2));
        bb.insert(new Node(3));
        bb.insert(new Node(4));
        bb.insert(new Node(5));
        bb.insert(new Node(6));
        bb.insert(new Node(7));
        bb.insert(new Node(8));
        bb.insert(new Node(9));
        bb.insert(new Node(10));
        bb.display();
        /*
        * 1
        *  \
        *   2
        *    \
        *     3
        *      \
        *       4
        *        ...
        * */
        System.out.println(bb.search(5));
        System.out.println(bb.search(3));
        bb.remove(9);
        bb.display();
        System.out.println(bb.search(8));
        System.out.println(bb.search(3));

        bb.balance();
        /*
        *
        *                   5
        *                 /   \
        *                2     7
        *              /  \   /  \
        *             1    3 6    8
        *                   \      \
        *                    4      10
        *
        * */
        bb.display();

        List<Integer> l = new ArrayList<>();

        l.add(1);
        l.add(7);
        l.add(6);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);

        bb.fromList(l);

        bb.display();
    }
}