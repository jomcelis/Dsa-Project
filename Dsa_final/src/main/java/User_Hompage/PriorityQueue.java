package User_Hompage;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PriorityQueue<E extends Comparable<E>> {

    private ArrayList<QueueNode<E>> queue;

    public PriorityQueue() {
        queue = new ArrayList<>();
    }

    public void add(E item, int priority) {
        // Create a new node with the item and priority
        QueueNode<E> newNode = new QueueNode<>(item, priority);

        // Add the new node to the end of the queue.
        queue.add(newNode);

        // Heapify the queue to maintain the heap property.
        heapifyUp(queue.size() - 1);
    }

    public E remove() {
        // If the queue is empty, throw an exception.
        if (queue.isEmpty()) {
            throw new NoSuchElementException("PriorityQueue is empty.");
        }

        // Get the root element of the queue (which is the element with the highest priority).
        E rootElement = queue.get(0).getItem();

        // Replace the root element with the last element in the queue.
        queue.set(0, queue.get(queue.size() - 1));

        // Remove the last element from the queue.
        queue.remove(queue.size() - 1);

        // Heapify the queue to maintain the heap property.
        heapifyDown(0);

        // Return the root element.
        return rootElement;
    }

    public E peek() {
        // If the queue is empty, return null.
        if (queue.isEmpty()) {
            return null;
        }

        // Return the root element of the queue.
        return queue.get(0).getItem();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (QueueNode<E> node : queue) {
            sb.append(node.getItem()).append(" (Priority: ").append(node.getPriority()).append(")\n");
        }
        return sb.toString();
    }

    private void heapifyUp(int index) {
        // Get the parent index of the current node.
        int parentIndex = (index - 1) / 2;

        // While the current node has a higher priority than its parent, swap them.
        while (index > 0 && queue.get(index).getPriority() > queue.get(parentIndex).getPriority()) {
            swapNodes(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int maxPriorityChildIndex;

        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;

            maxPriorityChildIndex = index;

            if (leftChildIndex < queue.size() && queue.get(leftChildIndex).getPriority() > queue.get(maxPriorityChildIndex).getPriority()) {
                maxPriorityChildIndex = leftChildIndex;
            }

            if (rightChildIndex < queue.size() && queue.get(rightChildIndex).getPriority() > queue.get(maxPriorityChildIndex).getPriority()) {
                maxPriorityChildIndex = rightChildIndex;
            }

            if (maxPriorityChildIndex == index) {
                break;
            }

            swapNodes(index, maxPriorityChildIndex);
            index = maxPriorityChildIndex;
        }
    }

    private void swapNodes(int index1, int index2) {
        QueueNode<E> temp = queue.get(index1);
        queue.set(index1, queue.get(index2));
        queue.set(index2, temp);
    }

    private static class QueueNode<T> {
        private T item;
        private int priority;

        public QueueNode(T item, int priority) {
            this.item = item;
            this.priority = priority;
        }

        public T getItem() {
            return item;
        }

        public int getPriority() {
            return priority;
        }
    }

    public List<E> getItems() {
        List<E> items = new ArrayList<>();
        for (QueueNode<E> node : queue) {
            items.add(node.getItem());
        }
        return items;
    }

    public void clear() {
        queue.clear();
    }

    public void addAll(List<E> items, List<Integer> priorities) {
        if (items.size() != priorities.size()) {
            throw new IllegalArgumentException("Items and priorities lists must have the same size.");
        }

        for (int i = 0; i < items.size(); i++) {
            add(items.get(i), priorities.get(i));
        }
    }
}
