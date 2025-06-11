public class Tree<E extends Comparable<E>> {
    private Node<E> root;
    private int currentSize = 0;

    private static class Node<E> {
        E data;
        Node<E> right, left;

        Node(E obj) {
            this.data = obj;
            right = left = null;
        }
    }

    public Tree() {
        root = null;
    }

    public void add(E obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Null elements are not allowed.");
        }
        if (root == null) {
            root = new Node<>(obj);
        } else {
            add(obj, root);
        }
        currentSize++;
    }

    public boolean contains(E obj) {
        if (obj == null) {
            return false;
        }
        return contains(obj, root);
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    private void add(E obj, Node<E> node) {
        int comparison = obj.compareTo(node.data);
        if (comparison > 0) {
            if (node.right == null) {
                node.right = new Node<>(obj);
            } else {
                add(obj, node.right);
            }
        } else if (comparison < 0) {
            if (node.left == null) {
                node.left = new Node<>(obj);
            } else {
                add(obj, node.left);
            }
        } else {
            return; // Element already exists, no duplicates allowed.
        }
    }

    public Node<E> delete(E obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Null elements are not allowed.");
        }
        Node<E> deletedNode = delete(obj, root);
        if (deletedNode != null) {
            currentSize--;
        }
        return deletedNode;
    }

    private Node<E> delete(E obj, Node<E> node) {
        if (node == null) {
            return null;
        }
        if (obj.compareTo(node.data) < 0) {
            node.left = delete(obj, node.left);
        } else if (obj.compareTo(node.data) > 0) {
            node.right = delete(obj, node.right);
        } else {
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                Node<E> successor = getInOrderSuccessor(node);
                node.data = successor.data;
                node.right = delete(successor.data, node.right);
            }
        }
        return node;
    }

    private boolean contains(E obj, Node<E> node) {
        if (node == null) {
            return false;
        }
        int comparison = obj.compareTo(node.data);
        if (comparison == 0) {
            return true;
        } else if (comparison > 0) {
            return contains(obj, node.right);
        } else {
            return contains(obj, node.left);
        }
    }

    private Node<E> getInOrderSuccessor(Node<E> node) {
        Node<E> current = node.right;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }
}
