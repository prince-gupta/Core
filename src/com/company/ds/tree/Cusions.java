package com.company.ds.tree;

/**
 * Created by princegupta on 04/09/18.
 */
public class Cusions {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TreeNode treeNode = (TreeNode) o;

            System.out.println( " Comparing " + this.data + " with " + treeNode.data);

            return (treeNode.data == this.data);
        }

        @Override
        public int hashCode() {
            int result = data;
            result = 31 * result + left.hashCode();
            result = 31 * result + right.hashCode();
            return result;
        }
    }

    private static int level(TreeNode node, TreeNode pointerN, int intialLevel) {
        if (pointerN == null)
            return 0;
        if (node.data == (pointerN.data)) {
            return intialLevel;
        }

        int leftLevel = level(node, pointerN.left, intialLevel + 1);
        if (leftLevel != 0) {
            return leftLevel;
        }
        return level(node, pointerN.right, intialLevel + 1);
    }

    private static boolean isSiblings(TreeNode nodeA, TreeNode nodeB, TreeNode pointerN) {
        System.out.println ( "Comparing : " + nodeA.data + " vs " + nodeB.data + " with pointer at " + pointerN.data);
        if(pointerN == null || pointerN.left == null || pointerN.right == null)
            return false;

        return (
                (
                        (pointerN.left.equals(nodeA) && pointerN.right.equals(nodeB))
                        ||
                        (pointerN.left.equals(nodeB) && pointerN.right.equals(nodeA))
                )
                ||
                        (isSiblings(nodeA, nodeB, pointerN.left))
                ||
                        (isSiblings(nodeA, nodeB, pointerN.right))
                );
    }

    private static boolean isCousins(TreeNode nodeA, TreeNode nodeB, TreeNode rootNode){
        return ((level(rootNode, nodeA, 0) == level(rootNode, nodeB, 0))
                && (!isSiblings(nodeA, nodeB, rootNode)));
    }

    public static TreeNode createBinaryTree() {

        TreeNode rootNode = new TreeNode(0);
        TreeNode node5 = new TreeNode(5);
        TreeNode node10 = new TreeNode(10);
        TreeNode node20 = new TreeNode(20);
        TreeNode node30 = new TreeNode(30);
        TreeNode node40 = new TreeNode(40);
        TreeNode node50 = new TreeNode(50);
        TreeNode node55 = new TreeNode(55);
        TreeNode node60 = new TreeNode(60);
        TreeNode node70 = new TreeNode(70);
        TreeNode node80 = new TreeNode(80);
        TreeNode node90 = new TreeNode(90);
        TreeNode node100 = new TreeNode(100);
        TreeNode node110 = new TreeNode(110);
        TreeNode node120 = new TreeNode(120);


        rootNode.left = node5;
        rootNode.right = node10;

        node5.left = node20;
        node5.right = node30;

        node10.left = node40;
        node10.right = node50;

        node20.left = node55;
        node20.right = node60;

        node30.left = node70;
        node30.right = node80;

        node40.left = node90;
        node40.right = node100;

        node50.left = node110;
        node50.right = node120;

        return rootNode;
    }

    public static void main(String[] args) {

        TreeNode nodeA = new TreeNode(30);
        TreeNode nodeB = new TreeNode(50);

        TreeNode rootNode = createBinaryTree();

        //System.out.println(nodeA.data + " : " + level(nodeA, rootNode, 0));
        //System.out.println(nodeB.data + " : " + level(nodeB, rootNode, 0));

        System.out.print(isCousins(nodeA, nodeB, rootNode));
    }
}
