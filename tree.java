package project;

import java.util.Stack;
import static project.Tree.*;

class Tree {

    
    Node tree;
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static Tree insert(Tree tree, int data) {
        Node root = tree.tree;
        Node prev = null;
        if(root == null) {
            tree.tree = new Node(data);
        } else {
            while(root != null) {
                if(root.data == data) return null;
                if(data > root.data) {
                    prev = root;
                    root = root.right;
                } else {
                    prev = root;
                    root = root.left;
                }
            }
            if(data > prev.data) {
                prev.right = new Node(data);
            } else {
                prev.left = new Node(data);
            }
        }
        return tree;
    }
    static Node parent(Tree tree, int data) {
        Node prev = null;
        Node root = tree.tree;
        if(tree.tree.data == data) {
            System.out.println("No parent!!");
        } else {
            while(root != null) {
                if(data == root.data) break;
                if(data > root.data) {
                    prev = root;
                    root = root.right;
                } else if(data < root.data) {
                    prev = root;
                    root = root.left;
                }
            }
        }
        if(root.data + "" != null) {
            return prev;
        }
        return null;
    }
    static Node sibling(Tree tree, int data) {
        Node parent = parent(tree, data);
        if(data > parent.data) {
            return parent.left != null ? parent.left : null;
        } else if(data < parent.data){
            return parent.right != null ? parent.right : null;
        } else {
            return null;
        }
    }
    static void inOrder(Node tree) { 
        if(tree != null) {
            inOrder(tree.left);
            System.out.print(tree.data + " ");
            inOrder(tree.right);
        }
    }
    static void postOrder(Node tree) { 
        if(tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.data + " ");
        }
    }
    static void preOrder(Node tree) { 
        if(tree != null) {
            System.out.print(tree.data + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }
    static Node search(Tree tree, int data) {
        Node root = tree.tree;
        int count = 0;
        while(root != null) {
            if(root.data == data) {
                System.out.println("Iterations: " + count);
                return root;
            }
            if(data > root.data) {
                root = root.right;
            } else {
                root = root.left;
            }
            count++;
        }
        return null;
    }
}


public class Project {

    public static void main(String[] args) {

        Tree Tree = new Tree();
        int[] arr = {14, 15, 7, 18, 3, 5, 16, 20, 17, 9};
        
        for(int i : arr)
            Tree = insert(Tree, i);
        
        System.out.print("inOrder: ");
        inOrder(Tree.tree);
        System.out.println("");
        System.out.print("postOrder: ");
        postOrder(Tree.tree);
        System.out.println("");
        System.out.print("preOrder: ");
        preOrder(Tree.tree);
        System.out.println("");
        System.out.println(search(Tree, 17).data);
    }
    
}
