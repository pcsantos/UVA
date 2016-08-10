class Gerador {

    public static void main(String[] args) {
        System.out.println(5000);
        for (int i = 0; i < 5000; i++)
        System.out.println(Math.round(Math.random()*10) + " " + Math.round(Math.random()*1000000));
    }

}
