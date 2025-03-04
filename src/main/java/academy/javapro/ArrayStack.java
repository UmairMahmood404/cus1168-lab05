package academy.javapro;

/**
 * Array-based implementation of the CustomStack interface.
 * @param <T> the type of elements in the stack
 */
public class ArrayStack<T extends Number> implements CustomStack<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final double GROWTH_FACTOR = 1.5;


    private static int totalStacks = 0;
    private static int totalElements = 0;


    private Object[] elements;
    private int top;
    private int operationCount;
    private final int stackId;


    public ArrayStack() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.top = -1;
        this.operationCount = 0;
        this.stackId = ++totalStacks;
    }

    @Override
    public void push(T element) {
        operationCount++;
        if (top == elements.length - 1) {
            resize();
        }
        elements[++top] = element;
        totalElements++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        operationCount++;
        if (isEmpty()) {
            return null;
        }
        T element = (T) elements[top];
        elements[top--] = null;
        totalElements--;
        return element;
    }

    @Override
    public T peek() {
        operationCount++;
        return isEmpty() ? null : (T) elements[top];
    }

    @Override
    public boolean isEmpty() {
        operationCount++;
        return top == -1;
    }

    @Override
    public int size() {
        operationCount++;
        return top + 1;
    }

    private void resize() {
        int newCapacity = (int) (elements.length * GROWTH_FACTOR);
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }

    public void addTopTwo() {
        if (size() < 2) {
            return;
        }
        T first = pop();
        T second = pop();
        Number result = first.doubleValue() + second.doubleValue();
        if (first instanceof Integer && second instanceof Integer) {
            push((T) Integer.valueOf(result.intValue()));
        } else {
            push((T) Double.valueOf(result.doubleValue()));
        }
    }

    public String getStats() {
        return "Stack #" + stackId + ": Size=" + size() + ", Operations=" + operationCount;
    }

    public static String getGlobalStats() {
        return "Total stacks: " + totalStacks + ", Total elements: " + totalElements;
    }
}


