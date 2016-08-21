public class Test {

    public static void main(String[] args) {
    
        String one = args[0];
        String two = args[1];

        if (one.compareTo(two) > 0)
            System.out.println(one);
    }
}
