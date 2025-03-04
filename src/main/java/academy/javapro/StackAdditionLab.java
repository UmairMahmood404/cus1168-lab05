package academy.javapro;

public class StackAdditionLab {
    public static void main(String[] args) {
        System.out.println("=== Test Case 1: Basic Addition ===");
        ArrayStack<Integer> stack = new ArrayStack<>();
        System.out.println("Is stack empty? " + stack.isEmpty());
        stack.push(10);
        stack.push(20);
        System.out.println("Stack size: " + stack.size());
        System.out.println(stack.getStats());
        System.out.println(ArrayStack.getGlobalStats());
        stack.addTopTwo();
        Integer result = stack.pop();
        System.out.println("Result of addition: " + result);

        System.out.println("\n=== Test Case 2: Array Resizing ===");
        ArrayStack<Integer> resizeStack = new ArrayStack<>();
        for (int i = 0; i < 15; i++) {
            resizeStack.push(i);
        }
        System.out.println("Stack size after pushing 15 elements: " + resizeStack.size());
        System.out.println(resizeStack.getStats());

        System.out.println("\n=== Test Case 3: Multiple Stack Instances ===");
        ArrayStack<Double> floatStack = new ArrayStack<>();
        floatStack.push(1.5);
        floatStack.push(2.5);
        floatStack.push(3.5);
        System.out.println("First stack stats: " + stack.getStats());
        System.out.println("Resize stack stats: " + resizeStack.getStats());
        System.out.println("Float stack stats: " + floatStack.getStats());
        System.out.println(ArrayStack.getGlobalStats());
    }
}