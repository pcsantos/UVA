/*N-rooks problem changed to permutation one string*/
public class Test {

    private int N;
    private char[] a;

    public static void main(String[] args) {
        String word = args[0];
        int N = word.length();
        Test t = new Test(N, word);
        t.enumerate(0);
    }

    public Test(int N, String a) {
        this.N = N;
        this.a = a.toCharArray();
    }

    private void exch(int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private void process() {
        for (int i = 0; i < N; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    private void enumerate(int k) {
        if (k == N) {
            process();
            return;
        }
        for (int i = k; i < N; i++) {
            exch(k, i);
            enumerate(k + 1);
            exch(k, i);
        }
    }
}

