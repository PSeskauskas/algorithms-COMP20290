public class russianPeasant {
    private russianPeasant() {}
    public static int calculation(int a, int b) {
        int result = 0;
        while(b > 0 || b < 0) {
            if(b % 2 == 1) {
                result += a;
            }
            a *= 2;
            b /= 2;
        }
        return result;
    }

    public static void main(String[] args)  {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        Stopwatch timer = new Stopwatch();
        for(int i = 0; i < a.length - 1; i++) {
            StdOut.println(calculation(a[i], a[i + 1]));
        }
        String formattedString = String.format("%.09f", timer.elapsedTime());
        StdOut.println("elapsed time = " + formattedString);
    }
}