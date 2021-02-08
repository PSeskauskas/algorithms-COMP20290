public class towersOfHanoi {
    public static void towersOfHanoi(int disk, char source, char dest, char auxiliary) {
        if(disk == 0) {  }
        else {
            towersOfHanoi(disk - 1, source, auxiliary, dest);
            System.out.println("Disk " + disk + " from " + source + " to " + dest);
            towersOfHanoi(disk - 1, auxiliary, dest, source);
        }
    }
    public static void main(String[] args) {
        int n = 64;
        towersOfHanoi(n, 'A', 'C', 'B');
    }
}