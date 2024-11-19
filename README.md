AVL Tree Implementation:
Overview:
This project is a university project, implements an AVL Tree data structure in Java. 
An AVL Tree is a self-balancing binary search tree where the heights of the two child subtrees of any node differ by at most one.
Features
Insert elements with O(log n) time complexity
Delete elements with O(log n) time complexity
Search elements with O(log n) time complexity
Automatically maintains tree balance through rotations
Supports key-value pair storage

Methods
Tree Operations

empty(): Check if the tree is empty
search(int k): Find an element by key
insert(int k, String i): Insert a new element
delete(int k): Remove an element by key
min(): Get the minimum key's value
max(): Get the maximum key's value
size(): Get the number of nodes in the tree
keysToArray(): Get sorted array of keys
infoToArray(): Get sorted array of values
split(int x): Split tree into two trees around a key
join(IAVLNode x, AVLTree t): Join another tree with a node

Node Interface
The IAVLNode interface provides methods to interact with individual tree nodes, including:

getKey(): Retrieve node's key
getValue(): Retrieve node's value
getHeight(): Get node's height
Various setters and getters for tree structure
