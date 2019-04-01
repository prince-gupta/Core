package com.company.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by princegupta on 05/09/18.
 */
public class TreeCreation {

    Node root = null;

    TreeCreation(){

    }
    TreeCreation(Node root){
        this.root = root;
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            System.out.println( " Comparing " + this.data + " with " + node.data);

            return (node.data == this.data);
        }

        @Override
        public int hashCode() {
            int result = data;
            result = 31 * result + left.hashCode();
            result = 31 * result + right.hashCode();
            return result;
        }
    }

    private Node insertNewNodeByData(int data, Node pntr){
        Node newNode = new Node(data);
        if (pntr == null){
            return newNode;
        }
        if(pntr.left == null) {
            pntr.left = newNode;
            return pntr;
        }

       else  if(pntr.right == null) {
            pntr.right = newNode;
            return pntr;
        }


        pntr = insertNewNodeByData(data, pntr.left);
        if(pntr == null)
            pntr = insertNewNodeByData(data, pntr.right);

        return pntr;
    }

    /*function to insert element in binary tree */
    static void insert( int key, Node temp)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(temp);

        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            } else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            } else
                q.add(temp.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        TreeCreation treeCreation = new TreeCreation(root);
        treeCreation.insert(20, root);
        treeCreation.insert(30, root);
        treeCreation.insert(50, root);
        treeCreation.insert(70, root);
        treeCreation.insert(90, root);
        Object k = root;

    }
}
