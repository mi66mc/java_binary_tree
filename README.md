# Binary Search Tree in Java

This project implements a Binary Search Tree (BST) in Java with full functionality, including insertion, search, deletion, and tree balancing.

## 📁 Structure

- `Node.java`: Represents a node in the tree, containing the value (`data`) and links to left and right children.
- `BinarySearchTree.java`: Core logic of the BST:
    - Node insertion
    - Element search
    - Element removal
    - Tree display (visually formatted)
    - Tree balancing

## ✅ Features

- `insert(Node node)`: Inserts a new node into the tree.
- `search(int data)`: Returns `true` if the value exists in the tree.
- `remove(int data)`: Deletes a node while preserving BST structure.
- `display()`: Prints the tree in a visual sideways format.
- `balance()`: Rebuilds the tree to make it balanced.
- `fromList(List<Integer> list)`: Build the BST from a `List<Integer>`

## 🔧 How Balancing Works

1. Performs an **in-order traversal** to get the sorted list of values.
2. Recursively builds a new balanced tree using the middle value as the root.

## ▶️ Example

```java
BinarySearchTree bst = new BinarySearchTree();
bst.insert(new Node(10));
bst.insert(new Node(5));
bst.insert(new Node(15));
bst.insert(new Node(3));
bst.insert(new Node(7));

bst.display(); // Print the tree

bst.remove(5); // Remove a node
bst.balance(); // Balance the tree
