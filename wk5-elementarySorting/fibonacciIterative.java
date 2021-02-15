public class fibonacciIterative {
    static int fibonacciIterative(int n) {
        if (n<=1)
            return 1;

        int fib = 1;
        int prevFib =  1;

        for (int i = 2; i < n; i++) {
            int temp = fib;
            fib = fib + prevFib;
            prevFib = temp;
        }
        return fib;
    }

    public static void main (String args[])
    {
        int n = 32;
        Stopwatch timer = new Stopwatch();
        System.out.println(fibonacciIterative(n));
        String formattedString = String.format("%.09f", timer.elapsedTime());
        StdOut.println("elapsed time = " + formattedString);
    }
}