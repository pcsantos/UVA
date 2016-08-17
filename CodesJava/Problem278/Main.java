import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String 	in;
		int testCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCases; i++) {
            in = input.readLine();
            System.out.println(numberOfPieces(in));
        }

		input.close();
	}

    private static int numberOfPieces(String in) {
        StringTokenizer st = new StringTokenizer(in);
        String piece = st.nextToken();
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
    
        return 0;
    }
}
