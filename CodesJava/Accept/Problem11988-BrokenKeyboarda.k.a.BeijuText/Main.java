import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            System.out.println(process(in));
        }
        input.close();
    }

    private static String process(String in) {
        LinkedList<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        final String aux = "[]";
        boolean begin = false;
        boolean end = false;
        for (char ch : in.toCharArray()) {
            int index = aux.indexOf(ch);
            if (index == - 1) {
                sb.append(ch); 
            } else {
                if (begin) {
                    list.addFirst(sb.toString());
                    begin = false;
                } else if (end) {
                    list.addLast(sb.toString());
                    end = false;
                } else {
                    list.addFirst(sb.toString());
                }
                switch(index) {
                    case 0: 
                        begin = true; 
                        break;
                    case 1: 
                        end = true; 
                        break;
                }
                sb.setLength(0);
            }
        }
        if (begin)
            list.addFirst(sb.toString());
        else
            list.addLast(sb.toString());
        sb.setLength(0);
        for (String str : list)
            sb.append(str);
        return sb.toString().trim();
    }
}
