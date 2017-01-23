import java.util.*;

class Test {

    private static HashMap<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) {
        map.put("1234", 1);

        System.out.println(map.get("1234"));

        if (map.containsKey("1234")) {
            int aux = map.get("1234");
            map.put("1234", ++aux);
        }

        System.out.println(map.get("1234"));
    }
}
