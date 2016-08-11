class Gerador {

    public static void main(String[] args) {
        System.out.println(500);
        for (int i = 0; i < 500; i++)
         System.out.println(Math.round(Math.random()*10 + 1) + " " + Math.round(Math.random()*999999));
    }

}
