package cis233midterm;

import lib.src.docs.legacyalgo.Node;

public class BinarySearchTree {
        Node root;

        public BinarySearchTree() {
            root = null;
        }

        public void insert(int value) {
            root = insertRec(root, value);
        }

        private Node insertRec(Node root, int value) {
            if (root == null) {
                return new Node(value);
            }
            if (value < root.data) {
                root.left = insertRec(root.left, value);
            } else if (value > root.data) {
                root.right = insertRec(root.right, value);
            }
            return root;
        }
}   
