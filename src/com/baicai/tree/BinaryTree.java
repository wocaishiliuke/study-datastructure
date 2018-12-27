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
     * @return boolean
     */
    @Override
    public boolean add(int value) {
        if (root == null) {
            root = new Node(value);
            return true;
        }else {
            return root.addChild(value);
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
     * 删除（删除后保证仍是排序树）
     * @param value
     * @return boolean
     */
    @Override
    public boolean delete(int value) {
        /** 方式1：假删除 */
        /*Node node = find(value);
        if (node != null) {
            node.setDelete(true);
            return true;
        } else {
            System.out.println("can't find this value...");
            return false;
        }*/

        /** 方式2：真删除 */
        // 当前节点，初始值：根节点
        Node current = root;
        // 当前节点的父节点
        Node parent = null;
        // 当前节点是父节点的左孩子?
        boolean isLeftChild = false;
        // 1.查找节点
        while (current.getValue() != value) {
            parent = current;
            if (current.getValue() > value) {
                current = current.getLeft();
                isLeftChild = true;
            } else {
              current = current.getRight();
              isLeftChild = false;
            }
            if (current == null) {
                System.out.println("can't find this value...");
                return false;
            }
        }
        // 2.删除的是叶子节点（断绝父子关系即可，剩余交由GC处理）
        if (current.getLeft() == null && current.getRight() == null) {
            // 该叶子节点又恰好是root
            if(current == root) {
                root = null;
            } else if(isLeftChild) {
                // 不是root，parent肯定不为null
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
            return true;
        }
        // 3.删除的是只有一个子节点的节点（只需要将父节点原本指向该节点的引用，改为指向该节点的子节点即可）
        if (current.getLeft() == null && current.getRight() != null) {
            if(current == root) {
                root = current.getRight();
            } else if (isLeftChild) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
            return true;
        }
        if (current.getLeft() != null && current.getRight() == null) {
            if(current == root) {
                root = current.getLeft();
            } else if (isLeftChild) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
            return true;
        }
        // 4.删除有两个子节点的节点（寻找继承者：被删除节点右子树的最小值（最左最深）或被删除节点左子树的最大值（最右最深））
        // 4.1 寻找继承者
        Node successorParent = current;
        Node successor = current.getRight();
        Node deepestLeft = successor.getLeft();
        while (deepestLeft != null) {
            successorParent = successor;
            successor = deepestLeft;
            deepestLeft = deepestLeft.getLeft();
        }
        // 4.2处理继承者被带走后的残局（设置继承者继承前的上下代关系）
        // successor = deepestLeft肯定没有左孩子；如果有右孩子，替补到successor的位置
        successorParent.setLeft(successor.getRight());
        // 4.3继承（设置继承者继承后的上下代关系）
        successor.setLeft(current.getLeft());
        successor.setRight(current.getRight());
        if(current == root) {
            root = successor;
        } else if (isLeftChild) {
            parent.setLeft(successor);
        } else {
            parent.setRight(successor);
        }
        return true;
    }
}