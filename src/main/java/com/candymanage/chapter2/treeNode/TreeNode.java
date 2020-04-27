package com.candymanage.chapter2.treeNode;

/**
 * @author: hyb
 * @date: 2020-04-27 下午 4:24
 * @description: 树节点
 */
public class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode(T val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

}
