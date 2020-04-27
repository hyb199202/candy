package com.candymanage.chapter2.treeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: hyb
 * @date: 2020-04-27 下午 4:30
 * @description: 二叉树的遍历：前序（递归，非递归），中序（递归，非递归），后序（递归，非递归），层序
 */
public class PG_6_TraversalOfBinaryTree {
    //前序--递归
    public static List<Integer> preoderRecursively(TreeNode<Integer> node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        list.add(node.val);
        list.addAll(preoderRecursively(node.left));
        list.addAll(preoderRecursively(node.right));
        return list;
    }

    //中序--递归
    public static List<Integer> inoderRecursively(TreeNode<Integer> node) {
        List<Integer> list = new ArrayList<>();
        if (node == null)
            return list;
        list.addAll(inoderRecursively(node.left));
        list.add(node.val);
        list.addAll(inoderRecursively(node.right));
        return list;
    }

    //后序--递归
    public static List<Integer> postroderRecursivly(TreeNode<Integer> node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        list.addAll(postroderRecursivly(node.left));
        list.addAll(postroderRecursivly(node.right));
        list.add(node.val);
        return list;
    }


    public static void main(String[] args) {
        //            1
        //              \
        //               2
        //              /
        //             3
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.right = new TreeNode<Integer>(2);
        root.right.left = new TreeNode<Integer>(3);
        List<Integer> preoderRecursively_list = preoderRecursively(root);
        System.out.print("preoderRecursively_list" + "\t");
        System.out.println(preoderRecursively_list.toString());

        List<Integer> inoderRecursively_list = inoderRecursively(root);
        System.out.print("inoderRecursively_list" + "\t");
        System.out.println(inoderRecursively_list.toString());

        List<Integer> postroderRecursivly_list = postroderRecursivly(root);
        System.out.print("postroderRecursivly_list"+"\t");
        System.out.println(postroderRecursivly_list.toString());

    }


   /* public static  int digui(int n){
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        return digui(n - 1) + digui(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(digui(9));
    }*/


}
