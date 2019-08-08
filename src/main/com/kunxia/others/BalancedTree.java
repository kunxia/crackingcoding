package com.kunxia.others;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class BalancedTree {

    class Node{
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
            left=right=null;
        }

    }

    Node root;

    public boolean isBalanced(Node node){
        int lh, rh;
        if(node==null){
            return true;
        }

        lh = height(node.left);
        rh = height(node.right);

        if((Math.abs(lh-rh)<=1) && isBalanced(node.left) && isBalanced(node.right)){
            return true;
        }

        return false;
    }

    public int height(Node node){
        if(node == null){
            return 0;
        }
        return 1+Math.max(height(node.left),height(node.right));
    }

    public static void main(String[] args) {
        JUnitCore.main("com.kunxia.others.BalancedTree");
    }

    BalancedTree s;

    @Before
    public void init(){
        s= new BalancedTree();
    }

    @Test
    public void nullTreeIsBalanced(){
        Assert.assertTrue(s.isBalanced(null));
    }

    @Test
    public void testWithSampleInput1(){
        s.root=new Node(1);
        s.root.left = new Node(2);
        s.root.right = new Node(3);
        s.root.left.left = new Node(4);
        s.root.left.right = new Node(5);
        s.root.left.left.left = new Node(8);
        Assert.assertFalse(s.isBalanced(s.root));
    }

    @Test
    public void testWithSampleInput2(){
        s.root = new Node(1);
        s.root.left = new Node(2);
        s.root.right = new Node(3);
        s.root.left.left = new Node(4);
        s.root.left.right = new Node(5);
        s.root.right.right = new Node(6);
        s.root.left.left.left = new Node(7);
        Assert.assertTrue(s.isBalanced(s.root));
    }
}
