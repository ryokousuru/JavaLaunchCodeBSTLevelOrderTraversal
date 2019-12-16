package com.launchcode.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static void levelOrder(Node root){
        Queue<Node> queue = new LinkedList();
        if (root != null){
            //enqueueing the current root
            queue.add(root);

            //while there are nodes to process
            while (!queue.isEmpty()) {
                Node cur = queue.remove();

                //Process the tree's root
                System.out.print(cur.data + " ");

                //enqueue child elements from next level in order
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);}
            } //end of while loop
        } //end of if statement

    } //end of method

    public static Node insert(Node root, int data){
        if (root == null){
         return new Node(data);
        }
        else {
            Node cur;
            if (data <= root.data){
                cur = insert(root.left, data);
                root.left = cur;
            }
            else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        } // end of outer else
    } //end of method

    public static void main(String[] args) {
	// write your code here
        System.out.println("Enter the number of test cases followed by the carriage return key.");
        System.out.println("Then enter the actual test cases.");
        System.out.println("Press the carriage return key after each test case.");
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T --> 0){
            int data = sc.nextInt();
            root = insert(root, data);
        }
        levelOrder(root);
    }
}
