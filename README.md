# Data Structures in Java

This repository implements fundamental data structures in Java, including:

- `Stack`
- `Queue`
- `LinkedList`
- `Hash`
- `Tree` (Binary Search Tree)
- `Heap` (Max Heap)
- `AVLTree` (Self-Balancing Binary Search Tree)

---

## `Stack`

A generic stack implementation with automatic resizing.

- `Push(E n)`: Adds an element to the top. Resizes when full.
- `Pop()`: Removes and returns the top element.
- `Top()`: Returns the top element without removing it.
- `isEmpty()`: Checks if the stack is empty.
- `isFull()`: Checks if the stack is full.

> Initial capacity is 5. Stack resizes by multiples of 5 when full.

---

## `Queue`

A circular queue with a fixed size (default 101).

- `Enqueue(E n)`: Adds an element at the rear.
- `Dequeue()`: Removes and returns the element at the front.
- `Front()`: Returns the front element without removing it.
- `isEmpty()`: Checks if the queue is empty.
- `isFull()`: Checks if the queue is full.

---

## `LinkedList`

A singly linked list implementation with iterator support.

- `addFirst(E obj)`: Adds an element to the beginning.
- `addLast(E obj)`: Adds an element to the end.
- `removeFirst()`: Removes and returns the first element.
- `removeLast()`: Removes and returns the last element.
- `remove(E obj)`: Removes a specific element.
- `contain(E obj)`: Checks if an element exists.
- `size()`: Returns number of elements.
- `clear()`: Clears the list.
- `printList()`: Prints the contents of the list.

---

## `Hash`

A separate chaining hash table using `LinkedList`.

- `add(K key, V value)`: Adds a key-value pair. Resizes if load factor > 0.75.
- `remove(K key, V value)`: Removes a specific key-value pair.
- `getValue(K key)`: Returns value for a key.
- `resize(int newSize)`: Resizes and rehashes the table.
- Implements `Iterable<K>` for key traversal.

---

## `Tree`

A basic binary search tree.

- `add(E obj)`: Adds an element.
- `contains(E obj)`: Checks for presence of an element.
- `delete(E obj)`: Deletes an element if found.
- `size()`: Returns number of nodes.
- `isEmpty()`: Checks if tree is empty.

Supports binary search tree rules: Left < Root < Right

---

## `Heap`

A max heap implementation using an array.

- `add(E obj)`: Adds an element to the heap and reorders (heapify up).
- `remove()`: Removes and returns the maximum element (root), then reorders (heapify down).
- Internally uses:
  - `tickleUp(int position)`: Recursively compares and moves up to maintain heap property.
  - `tickleDown(int parent)`: Recursively compares and moves down the tree.
  - `swap(int from, int to)`: Swaps elements in the array.

> Fixed-size implementation with bounds checking. Default comparison assumes `E` is comparable.

---

## `AVLTree`

Self-balancing BST (AVL Tree).

- `add(E obj)`: Adds an element while maintaining balance.
- `prettyPrint()`: Prints the tree visually.
- Internally uses:
  - `checkBalance(Node)`
  - Rotations: `leftRotate`, `rightRotate`, `leftRightRotate`, `rightLeftRotate`
  - Parent pointers for upward tracking