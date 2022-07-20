package com.hwani.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Utility {

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
}
