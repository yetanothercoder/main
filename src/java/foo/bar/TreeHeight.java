package foo.bar;

/**
 * Let's assume that it's binary tree
 */
public class TreeHeight {

    public static void main(String[] args) {

        BinTree t4_1221 = new BinTree();
        BinTree t4_1222 = new BinTree();

        BinTree t3_122 = new BinTree(t4_1221, t4_1222);

        BinTree t2_12 = new BinTree(null, t3_122);
        BinTree t2_11 = new BinTree();

        BinTree t1_2 = new BinTree();
        BinTree t1_1 = new BinTree(t2_11, t2_12);
        BinTree t = new BinTree(t1_1, t1_2);


        System.out.println("check: " + (height(t) == 5));
        System.out.println("check: " + (height(t4_1221) == 1));
        System.out.println("check: " + (height(t3_122) == 2));
        System.out.println("check: " + (height(t2_12) == 3));
        System.out.println("check: " + (height(t1_2) == 1));
        System.out.println("check: " + (height(t2_11) == 1));
        System.out.println("check: " + (height(null) == 0));
    }

    public static int height(BinTree root) {
        if (root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    static class BinTree {
        BinTree left, right;

        public BinTree() { }

        public BinTree(BinTree left, BinTree right) {
            this.left = left;
            this.right = right;
        }
    }
}



