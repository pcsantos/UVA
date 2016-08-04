import java.util.*;
import java.io.*;

class Main {

    private static int numberOfInstructions = 0;
    private static int[] registers = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; 
    private static String[] ram = new String[1000];
    private static int ramIndex = 0;
    private static int ramContent = 0;

    public static void main(String[] args) throws IOException {
    
        setRamToDefault();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        int testCases = Integer.parseInt(input.readLine());
        String in;
        input.readLine();
        for (int i = 0; i < testCases; i++) {
            if (i > 0)
                System.out.println();
<<<<<<< HEAD
=======
            boolean flag = true;
>>>>>>> ff85e19d7661e387f766342a8315dfa4b537b2d3
            in = input.readLine();
            int j = 0;
            while(in != null && !in.equals("")) {
                ram[j++] = in;
                ramContent++;
                in = input.readLine();
            }
            setInstructions();
            System.out.println(numberOfInstructions);
            setRamToDefault();
            setRegistersToDefault();
            ramIndex = 0;
            ramContent = 0;
            numberOfInstructions = 0;
        }
        input.close();
    }

    private static void setInstructions() {
        boolean halt = false;
        for (int i = ramIndex; i < ramContent; i++) {
            switch (ram[i].charAt(0)) {
                case '0':
                    int newIndex = goToLocationInRegisterDIfSNotEqualZero(ram[i].charAt(1), ram[i].charAt(2));
                    if(newIndex != -1) 
                        i = newIndex-1;
                    numberOfInstructions++;
                    break;
                case '1':
                    numberOfInstructions++;
                    if (ram[i].equals("100"))
                        halt = true;
                    break;
                case '2':
                    setRegisterDtoN(ram[i].charAt(1), ram[i].charAt(2));
                    numberOfInstructions++;
                    break;
                case '3':
                    addNtoRegisterD(ram[i].charAt(1), ram[i].charAt(2));
                    numberOfInstructions++;
                    break;
                case '4':
                    multiplyRegisterDByN(ram[i].charAt(1), ram[i].charAt(2));
                    numberOfInstructions++;
                    break;
                case '5':
                    setRegisterDToValueOfRegisterS(ram[i].charAt(1), ram[i].charAt(2));
                    numberOfInstructions++;
                    break;
                case '6':
                    addValueRegisterStoRegisterD(ram[i].charAt(1), ram[i].charAt(2));
                    numberOfInstructions++;
                    break;
                case '7':
                    multiplyRegisterDByValueOfRegisterS(ram[i].charAt(1), ram[i].charAt(2));
                    numberOfInstructions++;
                    break;
                case '8':
                    setRegisterDWihtValueInRamWhoseAddressInA(ram[i].charAt(1), ram[i].charAt(2));
                    numberOfInstructions++;
                    break;
                case '9':
                    setValueInRamWhoseAddressIsInRegisterAToTheValueOfRegisterS(ram[i].charAt(1), ram[i].charAt(2));
                    numberOfInstructions++;
                    break;
            }
            if (halt) break;
        }
    }
   /*0ds means goto the location in register d unless register s contains 0*/ 
    private static int goToLocationInRegisterDIfSNotEqualZero(char d, char s) {
        int indexD = Integer.parseInt(d + "");
        int indexS = Integer.parseInt(s + "");
        if (registers[indexS] != 0) {
            return registers[indexD];
        }
        return -1;
    }
    /*2dn means set register d to n (between 0 and 9)*/
    private static void setRegisterDtoN(char d, char n) {
        int index = Integer.parseInt(d + "");
        int value = Integer.parseInt(n + "");
        registers[index] = value;
    }
    /*3dn means add n to register d*/ 
    private static void addNtoRegisterD(char d, char n) {
        int indexD = Integer.parseInt(d + "");
        int value = Integer.parseInt(n + "");
        int sum = registers[indexD] + value;
        registers[indexD] = sum % 1000;
    }
    /*4dn means multiply register d by n*/
    private static void multiplyRegisterDByN(char d, char n) {
        int indexD = Integer.parseInt(d + "");
        int value = Integer.parseInt(n + "");
        int mult = registers[indexD] * value;
        registers[indexD] = mult % 1000;
    }
    /*5ds means set register d to the value of register s*/ 
    private static void setRegisterDToValueOfRegisterS(char d, char s) {
        int indexD = Integer.parseInt(d + "");
        int indexS = Integer.parseInt(s + "");
        registers[indexD] = registers[indexS];
    }
    /*6ds means add the value of register s to register d*/
    private static void addValueRegisterStoRegisterD(char d, char s) {
        int indexD = Integer.parseInt(d + "");
        int indexS = Integer.parseInt(s + "");
        int sum = registers[indexS] + registers[indexD];
        registers[indexD] = sum % 1000;
    }
    /*7ds means multiply register d by the value of register s*/
    private static void multiplyRegisterDByValueOfRegisterS(char d, char s) {
        int indexD = Integer.parseInt(d + "");
        int indexS = Integer.parseInt(s + "");
        int mult = registers[indexD] * registers[indexS];
        registers[indexD] = mult % 1000;
    }
    /*8da means set register d to the value in RAM whose address is in register a*/ 
    private static void setRegisterDWihtValueInRamWhoseAddressInA(char d, char a) {
        int indexD = Integer.parseInt(d + "");
        int indexA = Integer.parseInt(a + "");
        registers[indexD] = Integer.parseInt(ram[registers[indexA]]);
    }
    /*9sa means set the value in RAM whose address is in register a to the value of register s*/ 
    private static void setValueInRamWhoseAddressIsInRegisterAToTheValueOfRegisterS(char s, char a) {
        int indexS = Integer.parseInt(s + "");
        int indexA = Integer.parseInt(a + "");
        
        String value = String.valueOf(registers[indexS]);
        if (value.length() == 1)
            ram[registers[indexA]] = "00" + value;
        if (value.length() == 2)
            ram[registers[indexA]] = "0" + value;
        if (value.length() == 3)
            ram[registers[indexA]] = value;
        /* if a bigger position in RAM is used is necessary change the initial
         * size to reach this position*/
        if(ramContent < registers[indexA])
            ramContent = registers[indexA] + 1;
    }

    
    private static void setRamToDefault() {
        for (int i = 0; i < 1000; i++) {
            ram[i] = "000";
        }
    }
    
    private static void setRegistersToDefault() {
        for (int i = 0; i < 10; i++) {
            registers[i] = 0;
        }
    }
}
