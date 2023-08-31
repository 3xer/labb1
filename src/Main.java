// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

// Press Alt+Enter with your caret at the highlighted text to see how
// IntelliJ IDEA suggests fixing it.

// Press Shift+F10 or click the green arrow button in the gutter to run the code.

// Press Shift+F9 to start debugging your code. We have set one breakpoint
// for you, but you can always add more by pressing Ctrl+F8.

import java.util.Arrays;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        int[] resInmatning = {};
        int[] resMinMaxMedel = {};
        int[] ressorted = {};
        while(!exit){
            System.out.println(
                    "Hello \n" +
                            "1. inmatning \n" +
                            "2. Min, Max och Medel \n" +
                            "3. Sortera \n" +
                            "4. Bästa Laddningstid (4h) \n" +
                            "e. avsluta \n" +
                            "enter input:"
            );
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    resInmatning = inmatning();
                }
                case "2" -> {
                    resMinMaxMedel = minMaxMedel(resInmatning);
                }
                case "3" -> sorted(resInmatning);
                case "4" -> System.out.println(input);
                case "e", "E" -> exit = true;
            }
        }
        scanner.close();



    }
    public static int[] inmatning(){
        System.out.println("inmatning");
        Scanner scanner = new Scanner(System.in);
        int[] priceInCents = {2, 3, 5, 4, 1, 6, 7, 8, 9, 10 ,11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 0};
        //{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int endhour = 1;
        int input = 0;
        boolean enderTestArray = false;
        while (!enderTestArray){
            for (int i : priceInCents) {
                int j = 0;
                System.out.println(j + "i");
                printTimeWithPrice(j, endhour);
                input = scanner.nextInt();

                i = input;
                System.out.println(i);
                endhour++;
                if (input == 000000) {
                    enderTestArray = true;
                    priceInCents = priceInCents;
                }
                j++;
            }
        }

        return priceInCents;
    }
    public static void printTimeWithPrice(int i, int endhour){

        if(i < 9) {
            System.out.println("Pris under timmar "+("0" + i) + "-" + ("0" + endhour)+":");
        } else if (i == 9) {
            System.out.println("Pris under timmar "+("0" + i) + "-" +  endhour +":");
        } else {
            System.out.println("Pris under timmar "+ (i) + "-" + (endhour)+ ":");
        }

    }
    public static int[] minMaxMedel(int[] resinmatning){


        int smallestNumber = resinmatning[0];
        int biggestNumber = resinmatning[0];
        int[] minMaxAvg = {0,0,0};
        int totalPrice = 0;
        int averagePrice = 0;
        int arrayLength = resinmatning.length -1;
        System.out.println("array lenght: " + arrayLength);

        //find the lowest number and find highers number
        for(int i : resinmatning){
            if(resinmatning[i] <= smallestNumber){
                smallestNumber = resinmatning[i];
                minMaxAvg[0] = smallestNumber;

            }
            else if (resinmatning[i] >= biggestNumber) {
                biggestNumber = resinmatning[i];
                minMaxAvg[1] = biggestNumber;

            }
            //find average number
            totalPrice= totalPrice + resinmatning[i];
        }

        averagePrice = totalPrice/resinmatning.length;
        minMaxAvg[2] = averagePrice;
        System.out.println("lowest price: " + smallestNumber);
        System.out.println("highest price: "+ biggestNumber);
        System.out.println("average price: " + averagePrice);
        return minMaxAvg;

    }
    public static void sorted(int[] resinmatning){
        //int [] resinmatning = {2, 3, 5, 4, 1, 6, 7, 8, 9, 10 ,11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 0 };
        Arrays.sort(resinmatning);
        int endhour = 1;
        for (int j: resinmatning){
            printTimeWithPrice(j, endhour);
            System.out.println(resinmatning[j]);
            endhour++;
        }

    }
}