public class AVLTree<E extends Comparable<E>> {
    private static class Node<E> {
        E data;
        Node<E> right, left, parent;

        Node(E obj) {
            this.data = obj;
            right = left = parent = null;
        }
    }

    private int currentSize;
    private Node<E> root;

    public AVLTree() {
        root = null;
        currentSize = 0;
    }

    public void add(E obj) {
        Node<E> node = new Node<>(obj);
        if (root == null) {
            root = node;
            currentSize++;
            return;
        }
        add(root, node);
        checkBalance(node);
        currentSize++;
    }

    public void prettyPrint() {
        prettyPrint(root, "", true);
    }

    private void add(Node<E> parent, Node<E> node) {
        if (node.data.compareTo(parent.data) > 0) {
            if (parent.right == null) {
                parent.right = node;
                node.parent = parent;
            } else {
                add(parent.right, node);
            }
        } else {
            if (parent.left == null) {
                parent.left = node;
                node.parent = parent;
            } else {
                add(parent.left, node);
            }
        }
    }

    private void checkBalance(Node<E> node) {
        int differenceHeight = height(node.left) - height(node.right);
        if (differenceHeight > 1 || differenceHeight < -1) {
            reBalance(node);
        }
        if (node.parent != null) {
            checkBalance(node.parent);
        }
    }

    private void reBalance(Node<E> node) {
        if (height(node.left) - height(node.right) > 1) {
            if (height(node.left.left) > height(node.left.right)) {
                node = rightRotate(node);
            } else {
                node = leftRightRotate(node);
            }
        } else if (height(node.right.right) > height(node.right.left)) {
            node = leftRotate(node);
        } else {
            node = rightLeftRotate(node);
        }

        if (node.parent == null) {
            root = node;
        }
    }

    private int height(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    private Node<E> leftRotate(Node<E> node) {
        Node<E> tmp = node.right;
        node.right = tmp.left;
        if (tmp.left != null) {
            tmp.left.parent = node;
        }
        tmp.left = node;
        tmp.parent = node.parent;
        node.parent = tmp;
        return tmp;
    }

    private Node<E> rightRotate(Node<E> node) {
        Node<E> tmp = node.left;
        node.left = tmp.right;
        if (tmp.right != null) {
            tmp.right.parent = node;
        }
        tmp.right = node;
        tmp.parent = node.parent;
        node.parent = tmp;
        return tmp;
    }

    private Node<E> rightLeftRotate(Node<E> node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    private Node<E> leftRightRotate(Node<E> node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    private void prettyPrint(Node<E> node, String prefix, boolean isLeft) {
        if (node == null) {
            return;
        }
        if (node.right != null) {
            prettyPrint(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.data);
        if (node.left != null) {
            prettyPrint(node.left, prefix + (isLeft ? "    " : "│   "), true);
        }
    }
}
