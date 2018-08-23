package codesample.data_structures.queues;

import codesample.data_structures.stacks.StackOnArray;

/**
 * @param <Item> - Generic item type for this queue
 * @author Pavel Bukhmatov (buhmatov@gmail.com; github.com/aquatir)
 */
public class QueueOnTwoStacks<Item> {

    private final StackOnArray<Item> inputStack;
    private final StackOnArray<Item> outputStack;

    public QueueOnTwoStacks() {
        inputStack = new StackOnArray<>();
        outputStack = new StackOnArray<>();
    }

    public void enqueue(Item item) {
        inputStack.push(item);
    }

    public Item dequeue() {
        if (outputStack.isEmpty() && inputStack.isEmpty())
            throw new IllegalArgumentException("Attempting to dequeue from empty queue");

        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.pop();
    }

}
