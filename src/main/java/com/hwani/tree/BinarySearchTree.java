package com.hwani.tree;

import javax.swing.*;
import java.util.ArrayList;

public class BinarySearchTree {

    public static Node insert(Node root, int value) {
        if(root == null) {
            root = new Node(value);
            return root;
        }

        if(root.data > value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key) {
        if(root == null)
            return false;

        if(root.data > key) {
            return search(root.left,key);
        } else if(root.data == key){
            return true;
        } else {
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int val) {
        if(root.data > val)
            root.left = delete(root.left, val);
        else if(root.data < val)
            root.right = delete(root.right, val);
        else {
            //case 1
            if(root.left == null && root.right == null)
                return null;
            //case 2
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;

            //case3
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);

        }
        return root;
    }

    static Node inorderSuccessor(Node root){
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int x, int y) {
        if(root == null) {
            return;
        }
        if(x <= root.data && root.data <= y){
            printInRange(root.left, x, y);
            System.out.print(root.data+" ");
            printInRange(root.right, x, y);
        }
        else if(x > root.data) {
            printInRange(root.right,x,y);
        } else {
            printInRange(root.left,x,y);
        }
    }

    public static void printRootToLeaf(Node root, ArrayList<Integer> path) {
        if(root == null)
            return;
        path.add(root.data);
        //leaf node
        if (root.left == null && root.right == null) {
            for(int val : path) {
                System.out.print(val+"-->");
            }
            System.out.println();
        }

        printRootToLeaf(root.left,path);
        printRootToLeaf(root.right,path);
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        int[] values = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for(int value : values) {
            root = insert(root, value);
        }
        inorder(root);
        System.out.println();
        /*if(search(root,7)) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }*/
        /*System.out.println();
        Utility.levelOrder(root);
        delete(root,4);
        inorder(root);
        System.out.println();
        Utility.levelOrder(root);*/

//        printInRange(root,3,11);
        printRootToLeaf(root, new ArrayList<>());

    }
}
