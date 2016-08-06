import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        int testCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCases; i++) {
            int days = Integer.parseInt(input.readLine());
            int hartals = Integer.parseInt(input.readLine());
            int[] hartalList = new int[hartals];
            for (int j = 0; j < hartals; j++) {
                int h = Integer.parseInt(input.readLine());
                hartalList[j] = h;
            }
            ArrayList<Integer> hartalListReduce = reduceList(hartalList);
            int daysLost = getDaysLost(hartalListReduce, days);
            System.out.println(daysLost);
        }
        input.close();
    }

    private static ArrayList<Integer> reduceList(int[] list) {
        
        ArrayList<Integer> newList = new ArrayList<>();
        newList.add(list[0]);
        for (int i = 1; i < list.length; i++) {
            boolean insert = true;
            for (Integer value : newList) {
                if ((list[i] % value) == 0) {
                    insert = false;
                    break;
                }
            }
            if (insert)
                newList.add(list[i]);
        }
        return newList; 
    }

    private static int getDaysLost(ArrayList<Integer> list, int days) {
    
        int daysLost = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 1; i <= days; i++) {
            for (Integer number : list) {
                if ((i % number == 0) && (i % 7) != 6 && (i % 7) != 0)
                    hashSet.add(i);
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            it.next();
            daysLost++;
        }
        return daysLost;
    }
}
