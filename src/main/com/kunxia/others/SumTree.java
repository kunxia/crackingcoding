package com.kunxia.others;

import org.junit.*;
import org.junit.runner.*;

public class SumTree {

    class Node{
        int data;
        Node left, right;
        Node(int item){
            data = item;
            left = right  = null;
        }
    }


    Node root;
    int sum(Node node){
        if(node == null){
            return 0;
        }
        return sum(node.left)+node.data+sum(node.right);
    }

    public boolean isSumTree(Node node){
        int ls, rs;
        if((node ==null || (node.left == null && node.right ==null))){
            return true;
        }
        ls = sum(node.left);
        rs = sum(node.right);

        if((node.data == ls+rs) && (isSumTree(node.left)) && (isSumTree(node.right))){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        JUnitCore.main("com.kunxia.others.SumTree");
    }

    SumTree s;
    @Before
    public void init(){
        s=new SumTree();
    }

    @Test
    public void nullInput(){
        Node n = null;
        Assert.assertTrue(s.isSumTree(n));
    }

    @Test
    public void sampleInput(){

        s.root = new Node(26);
        s.root.left = new Node(10);
        s.root.right = new Node(3);
        s.root.left.left = new Node(4);
        s.root.left.right = new Node(6);
        s.root.right.right = new Node(3);
        Assert.assertTrue(s.isSumTree(s.root));

    }

}
