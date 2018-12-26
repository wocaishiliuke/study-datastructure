package com.baicai.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉排序树节点
 * @Author yuzhou
 * @Date 18-12-14
 */
public class Node {

    /** 数据域 */
    private int value;
    /** 左子节点指针域（边）*/
    private Node left;
    /** 右子节点指针域（边）*/
    private Node right;
    /** 假删除（默认值false） */
    private boolean isDelete;

    public Node(int value) { this.value = value; }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    /**
     * 根据值，匹配该节点或子节点
     * @param value
     * @return Node
     */
    public Node find(int value) {
        /** 方式1：递归 */
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (left != null) {
                return left.find(value);
            }
        } else if (value > this.value) {
            if (right != null) {
                return right.find(value);
            }
        }
        // 该节点及其子节点都未能匹配到
        return null;

        /** 方式2：非递归 */
        /*Node current = this;
        while (current != null) {
            if (current.value > value) {
                current = current.left;
            } else if (current.value < value) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;*/
    }

    /**
     * 查找该节点下的最大值
     * @return Node
     */
    public Node findMax() {
        /** 方式1：递归 */
        /*if (right == null) {
            return this;
        }
        return right.findMax();*/

        /** 方式2：非递归 */
        Node current = this;
        Node max = this;
        while (current != null) {
            max = current;
            current = current.right;
        }
        return max;
    }

    /**
     * 查找该节点下的最小值
     * @return Node
     */
    public Node findMin() {
        /** 方式1：递归 */
        /*if (left == null) {
            return this;
        }
        return left.findMin();*/

        /** 方式2：非递归 */
        Node current = this;
        Node min = this;
        while (current != null) {
            min = current;
            current = current.left;
        }
        return min;
    }

    /**
     * 添加子节点
     * @param value
     * @return void
     */
    public void addChild(int value) {
        /** 方式1：递归 */
        /*if (this.value > value) {
            if (left == null) {
                left = new Node(value);
            }else {
                left.addChild(value);
            }
        }else {
            if (right == null) {
                right = new Node(value);
            }else {
                right.addChild(value);
            }
        }*/

        /** 方式2：非递归 */
        Node current = this;
        while (current != null) {
            if (current.value > value) {
                if (current.left == null) {
                    current.left = new Node(value);
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node(value);
                    return;
                }
                current = current.right;
            }
        }
    }

    /**
     * 遍历
     * @return void
     */
    public void iterate() {
        /** 方式1：递归 （先序、后序只需要改变this.value的输出位置）*/
        if (left != null) {
            left.iterate();
        }
        System.out.println(this.value);
        if (right != null) {
            right.iterate();
        }


        /** 方式2：非递归 */

        /** 中序 */
        //辅助栈
        /*Stack<Node> stack = new Stack<>();
        Node current = this;//根节点
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                System.out.println(current.value);
                current = current.right;
            }
        }*/

        /** 先序1 */
        //辅助栈
        /*Stack<Node> stack = new Stack<>();
        Node current = this;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                System.out.println(current.value);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                current = current.right;
            }
        }*/

        /** 先序2 */
        //辅助栈
        /*Stack<Node> stack = new Stack<>();
        stack.add(this);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            System.out.println(temp.value);
            //先压栈右孩子，FILO
            if (temp.right != null) {
                stack.add(temp.right);
            }
            if (temp.left != null) {
                stack.add(temp.left);
            }

        }*/

        /** 后序 */
        // 双栈：stack1保存树节点，stack2保存后序遍历的结果
        /*Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.add(this);
        while (!stack1.isEmpty()) {
            Node temp = stack1.pop();
            stack2.push(temp);
            // 左子树先入栈1，右子树后入栈1
            if (temp.left != null) {
                stack1.push(temp.left);
            }
            if (temp.right != null) {
                stack1.push(temp.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().value);
        }*/
    }
    
    /**
     * 层次遍历
     * @return void
     */
    public void levelIterate() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.println(temp.value);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }
}