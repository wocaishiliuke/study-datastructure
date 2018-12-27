package com.baicai.tree;

/**
 * 树
 * @Author yuzhou
 * @Date 18-12-14
 */
public interface Tree {

    /**
     * 查找节点
     * @param value
     * @return Node
     */
    Node find(int value);

    /**
     * 查找最大值
     * @return Node
     */
    Node findMax();

    /**
     * 查找最小值
     * @return Node
     */
    Node findMin();

    /**
     * 添加节点
     * @param value
     * @return boolean
     */
    boolean add(int value);

    /**
     * （先、中、后序）遍历
     * @return void
     */
    void iterate();

    /**
     * 层次遍历
     * @return void
     */
    void levelIterate();

    /**
     * 删除节点
     * @param value
     * @return boolean
     */
    boolean delete(int value);
}
