package com.algorithms;

public class Main {

    public static void main(String[] args) {
	BST<Integer> bst = new BST<Integer>();
	bst.insert(1);
	bst.insert(10);
	bst.insert(100);
	bst.remove(1);
	System.out.println("INTEGER");
	System.out.println(bst.search(1));
	bst.insert(12);
	bst.insert(153);
	bst.insert(132);
	bst.insert(6);
	bst.traverse(bst.root);
	System.out.println(bst.size());

	/*
	bst.insert(null);
	System.out.println(bst.size());
	bst.clear();
	System.out.println(bst.size());
	*/
	BST<String> bst1 = new BST<String>();
	bst1.insert("a");
	bst1.insert("ab");
	bst1.insert("abc");
	bst1.remove("a");

	System.out.println("STRING");
	System.out.println(bst1.max());
	System.out.println(bst1.search("a"));
	bst1.traverse(bst1.root);
	bst1.clear();
	System.out.println(bst1.size());
    }
}
