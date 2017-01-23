import java.util.*;
import java.io.*;

class Main {

    private static final HashMap<Character, Integer> map = new HashMap<Character, Integer>();

    public static void main(String[] args) throws IOException {
    
        initMap();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String phoneAux;
        int testCases = Integer.parseInt(input.readLine().trim());
        for (int i = 0; i < testCases; i++) {
            if (i > 0)
                System.out.println();
            input.readLine();
            ArrayList<Phone> arrList = new ArrayList<>();
            int directory = Integer.parseInt(input.readLine().trim());
            for (int j = 0; j < directory; j++) {
                phoneAux = processPhone(input.readLine().trim());
                boolean flag = true;
                for (Phone aux : arrList) {
                    if (aux.getPhone().equals(phoneAux)) {
                        flag = false;
                        aux.addTimes();
                        break;
                    }
                }
                if (flag) {
                    Phone phone = new Phone(processPhone(phoneAux));
                    arrList.add(phone);
                }
            }

            ArrayList<Phone> newList = new ArrayList<>();
            for (Phone p: arrList)
                if (p.getTimes() > 1)
                    newList.add(p);

            Collections.sort(newList);
            for (Phone p : newList) {
                System.out.println(p.getPhone().substring(0,3) + "-" + p.getPhone().substring(3) + " " + p.getTimes());
            }
            if (newList.isEmpty())
                System.out.println("No duplicates.");
        }
        input.close();
    }

    private static void initMap() {
        map.put('A', 2);
        map.put('B', 2);
        map.put('C', 2);
        map.put('D', 3);
        map.put('E', 3);
        map.put('F', 3);
        map.put('G', 4);
        map.put('H', 4);
        map.put('I', 4);
        map.put('J', 5);
        map.put('K', 5);
        map.put('L', 5);
        map.put('M', 6);
        map.put('N', 6);
        map.put('O', 6);
        map.put('P', 7);
        map.put('R', 7);
        map.put('S', 7);
        map.put('T', 8);
        map.put('U', 8);
        map.put('V', 8);
        map.put('W', 9);
        map.put('X', 9);
        map.put('Y', 9);
    }

    private static String processPhone(String phone) {
        String aux = phone.replace("-", "");
        StringBuilder p = new StringBuilder();
        for (int i = 0; i < aux.length(); i++) {
            if (map.containsKey(aux.charAt(i))) {
                p.append(map.get(aux.charAt(i)));
            } else
                p.append(aux.charAt(i));
        }
        return p.toString();
    }

    private static class Phone implements Comparable<Phone> {
        private String phone;
        private int times;

        Phone(String phone) {
            this.phone = phone;
            this.times = 1;
        }
        private void addTimes() {
            this.times++;
        }

        private int getTimes() {
            return this.times;
        }
        
        private String getPhone() {
            return this.phone;
        }

        public int compareTo(Phone another) {
            return this.phone.compareTo(another.getPhone());
        }
    }
}
