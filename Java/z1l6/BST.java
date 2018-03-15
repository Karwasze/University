package com.algorithms;

class BST <T extends Comparable<T>> implements Dict<T> {

    private class Node<T extends Comparable<T>> {
        Node<T> left, right, parent;
        T data;
        Node(T data)
        {
            this.data = data;
        }
    }

    public Node<T> root;

    public void insert(T data)
    {
        if(data == null)
            throw new NullPointerException();
        if (root == null)
            root = new Node<T>(data);
        else
        {
            Node actual = root;
            Node parent = null;
            while (actual != null)
            {
                parent = actual;
                if (actual.data.compareTo(data) > 0)
                {
                    actual = actual.left;
                } else
                    actual = actual.right;
            }
            if (parent.data.compareTo(data) > 0)
            {
                parent.left = new Node<T>(data);
                parent.left.parent = parent;
            } else
            {
                parent.right = new Node<T>(data);
                parent.right.parent = parent;
            }
        }
    }

    public boolean search(T data)
    {
        Node actual = root;
        while (actual != null && actual.data.compareTo(data) != 0)
        {
            if (actual.data.compareTo(data) > 0)
            {
                actual = actual.left;
            } else
                actual = actual.right;
        }
        if (actual == null)
            return false;
        else
            return true;
    }
    public Node<T> search_node(T data)
    {
        Node actual = root;
        while (actual != null && data.compareTo(data) != 0)
        {
            if (actual.data.compareTo(data) > 0)
            {
                actual = actual.left;
            } else
                actual = actual.right;
        }
        if (actual == null)
            return null;
        else
            return actual;
    }

    public void remove(T data)
    {
        Node<T> node = search_node(data);
        Node<T> y;
        Node<T> x;
        if(node == null)
            return;

        if(node.left == null || node.right == null)
        {
            y = node;
        }
        else
            y = successor(node);

        if(y.left != null)
            x = y.left;

        else
            x = y.right;

        if(x != null)
            x.parent = y.parent;

        if(y.parent == null)
            root = x;
        else
            if(y == y.parent.left)
                y.parent.left = x;
            else
                y.parent.right = x;
        if(y != node)
            node.data = y.data;
    }

    public T min()
    {
        if(root == null)
            return null;
        Node node = root;
        while(node.left != null)
            node = node.left;
        return (T) node.data;
    }

    public T max()
    {
        if(root == null)
            return null;
        Node node = root;
        while (node.right != null)
            node = node.right;
        return (T) node.data;
    }

    public Node<T> min(Node<T> node)
    {
        while(node.left != null)
            node = node.left;
        return node;
    }

    public Node<T> max(Node<T> node)
    {
        while(node.right != null)
            node = node.right;
        return node;
    }

    public Node<T> successor(Node<T> node)
    {
        if (node.right != null)
            return min(node.right);
        Node <T> node_tmp = node.parent;
        while(node_tmp != null && node_tmp.left != node)
        {
            node = node_tmp;
            node_tmp = node_tmp.parent;
        }
        return node_tmp;
    }

    public void traverse(Node<T> node)
    {
        if(node == null)
        {
            return;
        }
        traverse(node.left);
        System.out.println(node.data);
        traverse(node.right);
    }

    public int size()
    {
        Node<T> node = root;
        if(node == null)
            return 0;
        else
        {
            root = node.left;
            int left = size();
            root = node.right;
            int right = size();
            root = node;
            return 1 + left + right;
        }
    }

    public void clear()
    {
        root = null;
    }
}