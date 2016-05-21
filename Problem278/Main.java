import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
		String 	line;
		int 	testCases;

		line = inReader.readLine();
		testCases = Integer.parseInt(line);
		for(int i = 0; i < testCases; i++) {
			line = inReader.readLine();
			StringTokenizer st = new StringTokenizer(line);
			String pieceType = st.nextToken();
			String rows = st.nextToken();
			String columns = st.nextToken();
			int output = solve(pieceType, Integer.parseInt(rows), Integer.parseInt(columns));
			System.out.println(output);
		}
		inReader.close();
	}

	private static int solve(String pieceType, int rows, int columns) {
		
		char opc =  pieceType.charAt(0);
		System.out.println(opc + "   " + rows + "   " + columns);
		
		switch(opc) {
			case 'r': {
				if(rows <= columns) return rows;
				else  return columns;
			}
		}

		return 0;
	}
}
