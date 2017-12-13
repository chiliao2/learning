package com.cdz.binarytree;

public class Tree {
    public Node root;

    public Node find(Integer key) {
        Node current = root;
        while (current != null && current.data != key) {
            if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return current;
    }

    public void insert(Integer key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = current;
        boolean left = true;
        while (current != null) {
            parent = current;
            if (current.data > key) {
                current = current.left;
                left = true;
            } else {
                current = current.right;
                left = false;
            }
        }
        if (left) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    public void displayTree() {
        displayInternalNode(root);
    }

    private void displayInternalNode(Node node) {
        if (node != null) {
            node.displayNode();
            displayInternalNode(node.left);
            displayInternalNode(node.right);
        }
    }

    public Node findMinNode() {
        if (root == null) {
            return null;
        }
        Node curent = root;
        Node parent = curent;
        while (curent != null) {
            parent = curent;
            curent = curent.left;
        }
        return parent;
    }

    public Node findMaxNode() {
        if (root == null) {
            return null;
        }
        Node curent = root;
        Node parent = curent;
        while (curent != null) {
            parent = curent;
            curent = curent.right;
        }
        return parent;
    }

    public Node delete(Integer key) {
        if (root == null) {
            return null;
        }

        Node current = root;
        Node parent = current;
        boolean left = true;
        while (current != null && current.data != key) {
            parent = current;
            if (current.data > key) {
                left = true;
                current = current.left;
            } else {
                current = current.right;
                left = false;
            }
        }
        if (current == null) {
            return null;
        }
        if (current.left == null && current.right == null) {
            if (left) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.left == null) {
            if (left) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.right == null) {
            if (left) {
                parent.right = current.left;
            } else {
                parent.left = current.left;
            }
        } else if (current.left != null && current.right != null) {
            Node right = current.right;
            Node minRight = right;
            Node parentRight = minRight;
            Node ppRight = parentRight;
            while (minRight != null) {
                ppRight = parentRight;
                parentRight = minRight;
                minRight = minRight.left;
            }

            //叶节点
            if (parentRight.left == null && parentRight.right == null) {
                ppRight.left = null;
                parentRight.left = current.left;
                parentRight.right = current.right;
                if (left) {
                    parent.left = parentRight;
                } else {
                    parent.right = parentRight;
                }
            } else if (current.right == parentRight) {
                parentRight.left = current.left;
                if (left) {
                    parent.left = parentRight;
                } else {
                    parent.right = parentRight;
                }
            } else {
                ppRight.left = parentRight.right;
                parentRight.right = current.right;
                parentRight.left = current.left;
                if (left) {
                    parent.left = parentRight;
                } else {
                    parent.right = parentRight;
                }
            }
        }
        return current;
    }

    public boolean deleteFake(Integer key) {
        if (root == null) {
            return false;
        }
        Node current = root;
        Node parent = null;
        while (current.data != key) {
            parent = current;
            if (current.data > key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (parent != null) {
            parent.isDeleted = false;
            return true;
        }
        return false;
    }

}
