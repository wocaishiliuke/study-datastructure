package com.baicai.tree;

/**
 * 二叉（排序）树
 * @Author yuzhou
 * @Date 18-12-14
 */
public class BinaryTree implements Tree {

    /** 根节点 */
    private Node root;

    /**
     * 查找节点
     * @param value
     * @return Node
     */
    @Override
    public Node find(int value) {
        if (root == null) {
            System.out.println("empty tree...");
            return null;
        }
        return root.find(value);
    }

    /**
     * 查找最大值（右到底）
     * @return Node
     */
    @Override
    public Node findMax() {
        if (root == null) {
            System.out.println("empty tree...");
            return null;
        }
        return root.findMax();
    }

    /**
     * 查找最小值（左到底）
     * @return Node
     */
    @Override
    public Node findMin() {
        if (root == null) {
            System.out.println("empty tree...");
            return null;
        }
        return root.findMin();
    }

    /**
     * 添加
     * @param value
     * @return void
     */
    @Override
    public void add(int value) {
        if (root == null) {
            root = new Node(value);
        }else {
            root.addChild(value);
        }
    }
    

    /**
     * 遍历
     * @return void
     */
    @Override
    public void iterate() {
        if (root == null) {
            System.out.println("empty tree...");
        }else {
            root.iterate();
        }
    }
    
    /**
     * 层次遍历
     * @return void
     */
    @Override
    public void levelIterate() {
        if (root == null) {
            System.out.println("empty tree...");
        }else {
            root.levelIterate();
        }
    }

    /**
     * 删除
     * @param value
     * @return void
     */
    @Override
    public void delete(int value) {
        /** 方式1：假删除 */
        /*Node node = find(value);
        if (node != null) {
            node.setDelete(true);
        }*/

        /** 方式2：真删除 */
        /*Node current = root;
        Node parent = null;
        boolean isLeftChild = false;
        while (current.getValue() != value) {
            parent = current;
            if (current.getValue() > value) {
                current = current.getLeft();
                isLeftChild = true;
            } else {
              current = current.getRight();
              isLeftChild = false;
            }
        }*/
    }
}