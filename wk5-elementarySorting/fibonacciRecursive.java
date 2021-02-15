public class fibonacciRecursive {
    static int fibonacciRecursive(int n) {
        if(n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    public static void main (String args[])
    {
        int n = 32;
        Stopwatch timer = new Stopwatch();
        System.out.println(fibonacciRecursive(n));
        String formattedString = String.format("%.09f", timer.elapsedTime());
        StdOut.println("elapsed time = " + formattedString);
    }
}