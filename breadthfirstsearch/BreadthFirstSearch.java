package breadthfirstsearch;

/**
 *
 * @author Umar Mahmud IX-III-MMXXI
 */
public class BreadthFirstSearch {

    private final Node A;
    private final Node B;
    private final Node C;
    private final Node D;
    private final Node E;
    private final Node F;
    private final Node G;
    private final Node H;
    private final Node I;
    private final Node J;
    private final Node K;
    private final Node L;
    private final Node M;
    private final int treeDepth;

    public BreadthFirstSearch() {
        A = new Node('A');
        B = new Node('B');
        C = new Node('C');
        D = new Node('D');
        E = new Node('E');
        F = new Node('F');
        G = new Node('G');
        H = new Node('H');
        I = new Node('I');
        J = new Node('J');
        K = new Node('K');
        L = new Node('L');
        M = new Node('M');
        constructTree();
        levelOrderTraversal();
        System.out.println("Traversal till destination");
        treeDepth = heightOfTree(A);
        System.out.println("height is: " + treeDepth);
        for (int i = 1; i <= treeDepth; i++) {
            bFirstSearch(A, K, i);
            System.out.println();
        }
    }

    private void bFirstSearch(Node start, Node dest, int level) {
        if ((start == null)||(start ==dest)) {
            return;
        }
        if (level == 1) {
            System.out.print(start.value + "\t");
        } else if (level > 1) {
            bFirstSearch(start.left, dest, level - 1);
            bFirstSearch(start.right, dest, level - 1);
        }
    }

    private void levelOrderTraversal() { //BFS traversal of tree
        System.out.println("Level Order Traversal of the tree is: ");
        int treeHeight;
        treeHeight = heightOfTree(A);
        System.out.println("The height of the tree is: " + treeHeight);
        //printLevel(A, 1);
        for (int i = 1; i <= treeHeight; i++) {
            printLevel(A, i);
            System.out.println();
        }
    }

    private int heightOfTree(Node root) {  //Compute the "height" of a tree */
        if (root == null) {
            return 0;
        } else {
            /* compute  height of each subtree */
            int lheight = heightOfTree(root.left);
            int rheight = heightOfTree(root.right);

            /* use the larger one */
            if (lheight > rheight) {
                return (lheight + 1);
            } else {
                return (rheight + 1);
            }
        }
    }

    void printLevel(Node root, int level) {
        /* Print nodes at a  level */
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.value + "\t");
        } else if (level > 1) {
            printLevel(root.left, level - 1);
            printLevel(root.right, level - 1);
        }
    }

    private void constructTree() {   //hard codes the tree
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = F;
        E.right = G;
        G.left = H;
        G.right = I;
        H.left = J;
        H.right = K;
        J.left = L;
        J.right = M;
    }

    public static void main(String[] args) {
        BreadthFirstSearch bFS = new BreadthFirstSearch();
    }
}
