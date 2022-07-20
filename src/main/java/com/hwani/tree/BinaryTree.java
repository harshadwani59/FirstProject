package com.hwani.tree;

import com.hwani.tree.*;

import java.util.*;

public class BinaryTree {
    /*public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }*/

    public static class BinaryTreeUtility {
        private static int idx = -1;

        public static Node createTreeFromPreOrder(int[] nodes) {
            idx++;
            if (nodes.length == 0)
                return null;

            if (nodes[idx] == -1) {
                return null;
            }

            Node node = new Node(nodes[idx]);
            node.left = createTreeFromPreOrder(nodes);
            node.right = createTreeFromPreOrder(nodes);

            return node;
        }

        public static void preOrder(Node root) {
            if (root == null)
                return;

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void levelOrder(Node root) {
            if (root == null)
                return;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty())
                        break;
                    q.add(null);
                } else {
                    System.out.print(currNode.data + " ");

                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }

                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }

        }

        public static int height(Node root) {
            if (root == null) {
                return 0;
            }
            return Math.max(height(root.left), height(root.right)) + 1;
        }

        //complexity is O(N^2) as we are scanning separately for Diameter and height
        public static int diameter(Node root) {

            if (root == null)
                return 0;

            int diam1 = diameter(root.left);
            int diam2 = diameter(root.right);
            int diam3 = height(root.left) + height(root.right) + 1;

            return Math.max(diam1, Math.max(diam2, diam3));
        }

        public static class TreeInfo {
            int height;
            int diameter;

            TreeInfo(int height, int diameter) {
                this.height = height;
                this.diameter = diameter;
            }
        }

        public static TreeInfo diameter2(Node root) {
            if (root == null)
                return new TreeInfo(0, 0);

            TreeInfo left = diameter2(root.left);
            TreeInfo right = diameter2(root.right);

            int myHeight = Math.max(left.height, right.height) + 1;

            int diam1 = left.diameter;
            int diam2 = right.diameter;
            int diam3 = left.height + right.height + 1;

            int myDiam = Math.max(diam1, Math.max(diam2, diam3));

            return new TreeInfo(myHeight, myDiam);
        }

        public static boolean isSubtree(Node root, Node subRoot) {
            if (subRoot == null) {
                return true;
            }
            if (root == null) {
                return false;
            }

            if (root.data == subRoot.data) {
                if (isIdentical(root, subRoot)) {
                    return true;
                }
            }

            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

        }

        private static boolean isIdentical(Node root, Node subRoot) {
            if (root == null && subRoot == null) {
                return true;
            }

            if (root == null || subRoot == null)
                return false;

            if (root.data == subRoot.data)
                return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);

            return false;
        }

        //Sum of nodes at kth level
        public static int sumOfNodesAtGivenLevel(Node root, int level) {
            if (root == null)
                return 0;

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            int actualLevel = 1;
            int sum = 0;

            while (!q.isEmpty() && actualLevel <= level) {

                Node currentNode = q.remove();
                if (currentNode == null) {
                    if (q.isEmpty())
                        break;
                    System.out.println();
                    q.add(null);
                    actualLevel++;
                } else {

                    if (actualLevel == level) {
                        sum = sum + currentNode.data;
                    }

                    System.out.print(currentNode.data + " ");
                    if (currentNode.left != null)
                        q.add(currentNode.left);

                    if (currentNode.right != null)
                        q.add(currentNode.right);
                }

            }
            System.out.println();
            return sum;
        }

    }

    public static void main(String[] args) {

        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BinaryTreeUtility.createTreeFromPreOrder(nodes);
        System.out.println("root.data = " + root.data);
        System.out.print("Preorder: ");
        BinaryTreeUtility.preOrder(root);
        System.out.println();
        System.out.println("Level Order: ");
        BinaryTreeUtility.levelOrder(root);
        System.out.println();
        System.out.println("Height :" + BinaryTreeUtility.height(root));
        System.out.println("Diameter :" + BinaryTreeUtility.diameter(root));
        System.out.println("Diameter2 :" + BinaryTreeUtility.diameter2(root).diameter);
        System.out.println("Sum of elements in given level :" + BinaryTreeUtility.sumOfNodesAtGivenLevel(root, 3));

    }

}
