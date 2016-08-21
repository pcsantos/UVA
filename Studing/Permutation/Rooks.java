/*N-rooks problem*/
public class Rooks {

    private int N;
    private int[] a;

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Rooks t = new Rooks(N);
        t.enumerate(0);
    }

    public Rooks(int N) {
        this.N = N;
        a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = i;
    }

    private void exch(int i, int j) {
        int t = a[i];
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
            exch(k, i); //clean up
        }
    }
}

