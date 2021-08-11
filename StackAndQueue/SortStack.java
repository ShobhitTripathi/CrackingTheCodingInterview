package StackAndQueue;


/*Create a temporary stack say tmpStack.
While input stack is NOT empty do this:
    Pop an element from input stack call it temp
    while temporary stack is NOT empty and top of temporary stack is greater than temp,
        pop from temporary stack and push it to the input stack
    push temp in temporary stack
The sorted numbers are in tmpStack*/

public class SortStack {

    public static Stack<Integer> sortStackUsingTempStack (Stack<Integer> inputStack) {
        Stack<Integer> tempStack = new StackLinkedList<>();

        while (!inputStack.isEmpty()) {
            int temp = inputStack.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                inputStack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        return tempStack;
    }


    public static void main (String[] args) {
        Stack<Integer> S = new StackLinkedList<>();
        S.push(20);
        S.push(2);
        S.push(21);
        S.push(40);
        S.push(1);
        S.push(1);

        PrintStack(S);
        Stack<Integer> sortedStack = sortStackUsingTempStack(S);
        System.out.println("After Sorting");
        PrintStack(sortedStack);

    }


    public static void PrintStack(Stack<Integer> s)
        {
            // If stack is empty then return
            if (s.isEmpty())
                return;

            int x = s.peek();

            // Pop the top element of the stack
            s.pop();

            // Recursively call the function PrintStack
            PrintStack(s);

            // Print the stack element starting
            // from the bottom
            System.out.print(x + " ");

            // Push the same element onto the stack
            // to preserve the order
            s.push(x);
        }
}
