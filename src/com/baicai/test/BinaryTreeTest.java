package com.baicai.test;

import com.baicai.tree.BinaryTree;
import com.baicai.tree.Tree;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试二叉（排序）树
 * @Author yuzhou
 * @Date 18-12-14
 */
public class BinaryTreeTest {

    private Tree bt = new BinaryTree();

    /**
     * 创建二叉排序树
     * @return void
     */
    @Before
    public void add() {
        bt.add(8);
        bt.add(3);
        bt.add(10);
        bt.add(1);
        bt.add(6);
        bt.add(14);
        bt.add(4);
        bt.add(7);
        bt.add(13);
    }
    
    /**
     * 测试BinaryTree.find()
     * @return void
     */
    @Test
    public void testFind() {
        System.out.println(bt.find(5));
        System.out.println(bt.find(10));
    }
    
    /**
     * 测试BinaryTree.findMax()
     * @return void
     */
    @Test
    public void testFindMax() {
        System.out.println(bt.findMax().getValue());
    }

    /**
     * 测试BinaryTree.findMin()
     * @return void
     */
    @Test
    public void testFindMin() {
        System.out.println(bt.findMin().getValue());
    }

    /**
     * 测试BinaryTree.iterate()
     * @return void
     */
    @Test
    public void testIterate() {
        bt.iterate();
    }

    /**
     * 测试BinaryTree.levelIterate()
     * @return void
     */
    @Test
    public void testLevelIterate() {
        bt.levelIterate();
    }

    /**
     * 测试BinaryTree.delete()
     * @return void
     */
    @Test
    public void testDelete() {
        bt.delete(13);
    }
}
