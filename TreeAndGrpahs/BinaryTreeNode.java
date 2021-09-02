package TreesAndGraphs;

import java.util.*;

public class BinaryTreeNode {
    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public int children = 0;


    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.children = 1;
    }

    public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public static void preOrderTraversal(BinaryTreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(BinaryTreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    public static void levelOrderTraversal(BinaryTreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        list = getLevelOrderTraversal(root);
        System.out.println(list.toString());
    }

    public static List<List<Integer>> getLevelOrderTraversal (BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> curr = new ArrayList<>();

        while (!q.isEmpty()) {
            BinaryTreeNode temp = q.poll();
            if (temp != null) {
                curr.add(temp.val);
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
            else {
                List<Integer> c_curr = new ArrayList<>(curr);
                result.add(c_curr);
                curr.clear();
                if (!q.isEmpty()) {
                    q.offer(null);
                }

            }
        }
        return result;

    }


    //insert node into the existing binary tree
    public static BinaryTreeNode insertNodeInBinaryTree(BinaryTreeNode root, int val) {
        if (root == null) {
            return null;
        }
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            BinaryTreeNode temp = q.poll();
            if (temp != null) {
                if (temp.left != null) {
                    q.offer(temp.left);
                } else {
                    temp.left = new BinaryTreeNode(val);
                    return root;
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                } else {
                    temp.right = new BinaryTreeNode(val);
                    return root;
                }
            }
        }
        return root;
    }


    public static BinaryTreeNode findNode(BinaryTreeNode root, int value) {
       BinaryTreeNode nodeFound = null;
       if (root == null) {
           return nodeFound;
       }
       Queue<BinaryTreeNode> q = new LinkedList<>();
       q.offer(root);

       while(!q.isEmpty()) {
           BinaryTreeNode temp = q.poll();
           if (temp != null) {
               if (temp.val == value) {
                   nodeFound = temp;
                   break;
               }
               if (temp.left != null) {
                   q.offer(temp.left);
               }
               if (temp.right != null) {
                   q.offer(temp.right);
               }
           }
       }

        return nodeFound;
    }

    public static void deleteNode (BinaryTreeNode root, int val) {
        BinaryTreeNode nodeToBeDeleted = findNode(root, val);
        BinaryTreeNode deepestNode = getDeepestNode(root);
        swapNodes(deepestNode, nodeToBeDeleted);
        deleteDeepest(root, deepestNode);

    }

    // Function to delete deepest element in binary tree
    static void deleteDeepest(BinaryTreeNode root, BinaryTreeNode delNode) {
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);

        // Do level order traversal until last node
        while (!q.isEmpty()) {
            BinaryTreeNode temp = q.poll();

            if (temp == delNode) {
                temp = null;
                return;
            }
            if (temp.left != null) {
                if (temp.left == delNode) {
                    temp.left = null;
                    return;
                }
                else {
                    q.offer(temp.left);
                }
            }
            if (temp.right != null) {
                if (temp.right == delNode) {
                    temp.right = null;
                    return;
                }
                else {
                    q.offer(temp.right);
                }
            }
        }
    }
    private static void swapNodes(BinaryTreeNode node1, BinaryTreeNode node2) {
        if (node1 == null || node2 == null)
            return;
        int temp ;
        temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    private static BinaryTreeNode getDeepestNode(BinaryTreeNode root) {
        BinaryTreeNode node = null;
        if (root == null)
            return node;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            BinaryTreeNode temp = q.poll();
            if (temp.left != null) {
                q.offer(temp.left);
            }
            if (temp.right != null) {
                q.offer(temp.right);
            }
            node = temp;
        }
        return node;
    }

    //get size from the node
    public static int getSize(BinaryTreeNode root) {
        if (root == null)
            return 0;
        return getSize(root.left) + getSize(root.right) + 1;
    }


    // returns number of children for root
    private static int getChildrenCount(BinaryTreeNode root) {
        if (root == null)
            return 0;
        return root.children + 1;
    }

    // Inserts Children count for each node
    public static BinaryTreeNode insertChildrenCount(BinaryTreeNode root) {
        if (root == null)
            return null;

        root.children = getSize(root) - 1;
        root.left = insertChildrenCount(root.left);
        root.right = insertChildrenCount(root.right);
        return root;
    }

    // Helper Function to return a random node
    private static int randomNodeUtil(BinaryTreeNode root, int count) {
        if (root == null)
            return 0;

        if (count == getChildrenCount(root.left))
            return root.val;

        if (count < getChildrenCount(root.left))
            return randomNodeUtil(root.left, count);

        return randomNodeUtil(root.right, (count - getChildrenCount(root.left) - 1));
    }

    // Returns Random node
    public static int getRandomNode(BinaryTreeNode root) {
        Random random = new Random();
        int index = random.nextInt(getSize(root));
        return randomNodeUtil(root, index);
    }

    public static int countPathsWithSum(BinaryTreeNode root, int targetSum) {
        return countPaths(root, targetSum, 0, new HashMap<Integer, Integer>());
    }

    private static int countPaths(BinaryTreeNode root, int targetSum,int runningSum, HashMap<Integer, Integer> pathCount) {
        if (root == null)
            return 0;
        runningSum += root.val;
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);

        /* If runningSum equals targetSum, then one additional path starts at root. add to totalPaths count */
        if (runningSum == targetSum)
            totalPaths++;

        /* Increment pathCount, recurse, then decrement pathCount. */
        incrementHashTable(pathCount, runningSum, 1);
        totalPaths += countPaths(root.left, targetSum, runningSum, pathCount);
        totalPaths += countPaths(root.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1);

        return totalPaths;
    }

    private static void incrementHashTable(HashMap<Integer, Integer> pathCount, int key, int delta) {
        int newCount = pathCount.getOrDefault(key, 0) + delta;
        // Remove when zero to reduce space usage
        if (newCount == 0) {
            pathCount.remove(key);
        } else {
            pathCount.put(key, newCount);
        }
    }


}
