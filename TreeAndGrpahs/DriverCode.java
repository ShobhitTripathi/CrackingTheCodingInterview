package TreesAndGraphs;

import static TreesAndGraphs.BinaryTreeNode.*;

public class DriverCode {


    private static void graphTest() {
        // Object of graph is created.
        Graph<Integer> g = new Graph<Integer>();

        // edges are added.
        // Since the graph is bidirectional,
        // so boolean bidirectional is passed as true.
        g.addEdge(0, 1, false);
        g.addEdge(0, 4, false);
        g.addEdge(1, 2, false);
        g.addEdge(1, 3, false);
        g.addEdge(1, 4, false);
        g.addEdge(2, 3, false);
        g.addEdge(3, 4, false);

        // print the graph.
        System.out.println("Graph:\n" + g.toString());

        // gives the no of vertices in the graph.
        g.getVertexCount();

        // gives the no of edges in the graph.
        g.getEdgesCount(true);

        // tells whether the edge is present or not.
        g.hasEdge(3, 4);

        // tells whether vertex is present or not
        g.hasVertex(5);

        int source = 0;
        int destination = 3;
        System.out.println("hasRoute(" + source  + ", " + destination + "): "
                + g.hasRoute(source,destination,true));

    }

    public  static void binaryTreeTest() {
//        insertNodeTest();
//        findNodeInTree();
//        deleteNodeTest();
//        getRandomNodeTest();
        getPathsCountWithTargetSumTest();
    }

    private static void getPathsCountWithTargetSumTest() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);

        TreeOperation to = new TreeOperation();
        to.show(root);
        int targetSum = 4;
        int totalPaths = countPathsWithSum(root, targetSum);
        System.out.println("Number of paths with sum : " + targetSum + " are : " + totalPaths);
    }


    public static void getRandomNodeTest () {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);

        TreeOperation to = new TreeOperation();
        to.show(root);

        //update tree with children count
        insertChildrenCount(root);

        int[] randomNodes = new int[getSize(root)];
        for (int i = 0;i < randomNodes.length;i++) {
            randomNodes[i] = getRandomNode(root);
        }
        System.out.println("RandomNodes generated");
        for (int n : randomNodes) {
            System.out.print(n + " ");
        }
    }

    private static void deleteNodeTest() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);

        TreeOperation to = new TreeOperation();
        System.out.println("Tree: ");
        to.show(root);

        int value = 3;
        System.out.println("After deleting the node " + value + ":");
        deleteNode(root, value);

        to.show(root);
    }

    private static void findNodeInTree() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);

        int value = 5;
        BinaryTreeNode node = findNode(root, value);
        System.out.println("Node is found in the tree : " + node.val);
    }

    public static void insertNodeTest () {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        TreeOperation to = new TreeOperation();
        System.out.println("Tree:");
        to.show(root);
        int val = 5;
        System.out.println("insert " + val + " in the existing tree.");
        insertNodeInBinaryTree(root, val);
        System.out.println("tree after insertion:");
        to.show(root);

    }

    public static void main(String[] args) {

//        graphTest();
        binaryTreeTest();

    }
}
