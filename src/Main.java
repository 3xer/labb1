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
        int[] resinput = {};
        double[] resMinMaxMedel = {};
        priceTime[] resSorted = {};
        int[] priceInCents = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        while (!exit) {
            System.out.println("Hello \n" + "1. inmatning \n" + "2. Min, Max och Medel \n" + "3. Sortera \n" + "4. Bästa Laddningstid (4h) \n" + "e. avsluta \n" + "enter input:");
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    resinput = inmatning(priceInCents);
                    System.out.println(Arrays.toString(resinput) + "case1 resinmatning");
                }
                case "2" -> {
                    minMaxMedel(resinput);
                }
                case "3" -> {
                    sorted(resinput);
                }
                case "4" -> bestChargeTime(resinput);
                case "e", "E" -> exit = true;
            }
        }
        scanner.close();
    }

    public static int[] inmatning(int[] priceInCents) {
        System.out.println("inmatning");
        Scanner scanner = new Scanner(System.in);
        int endhour = 1;
        int j = 0;
        int input = 0;
        boolean enderTestArray = false;
        for (int i = 0; i < priceInCents.length; i++) {
            System.out.println(Arrays.toString(priceInCents));
            printTimeWithPrice(i, endhour);
            input = scanner.nextInt();
            priceInCents[i] = input;
            System.out.println(i + " iteration");
            endhour++;
            j++;
        }
        return priceInCents;
    }

    public static void printTimeWithPrice(int i, int endhour) {
        if (i < 9) {
            System.out.println("Pris under timmar " + ("0" + i) + "-" + ("0" + endhour) + ":");
        } else if (i == 9) {
            System.out.println("Pris under timmar " + ("0" + i) + "-" + endhour + ":");
        } else {
            System.out.println("Pris under timmar " + (i) + "-" + (endhour) + ":");
        }
    }

    public static double[] minMaxMedel(int[] resInput) {
        int smallestNumber = resInput[0];
        int biggestNumber = resInput[0];
        double[] minMaxAvg = {0, 0, 0};
        int totalPrice = 0;
        double averagePrice = 0;
        int arrayLength = resInput.length;
        System.out.println("array lenght: " + arrayLength);
        //find the lowest number and find highers number
        for (int i = 0; i < resInput.length; i++) {
            if (resInput[i] <= smallestNumber) {
                smallestNumber = resInput[i];
                minMaxAvg[0] = smallestNumber;
            } else if (resInput[i] >= biggestNumber) {
                biggestNumber = resInput[i];
                minMaxAvg[1] = biggestNumber;
            }
            //find average number
            totalPrice = totalPrice + resInput[i];
        }
        averagePrice = (double) totalPrice / resInput.length;
        minMaxAvg[2] = averagePrice;
        System.out.println("lowest price: " + smallestNumber);
        System.out.println("highest price: " + biggestNumber);
        System.out.println("average price: " + averagePrice);
        return minMaxAvg;
    }

    public static void bestChargeTime(int[] resInput) {
        int fourHours = 4;
        for (int i = 0; i <= resInput.length - fourHours; i++) {
            int sum = 0;
            for (int j = i; j < i + fourHours; j++) {
                sum += resInput[j];
            }
            double average = (double) sum / fourHours;
            System.out.println(" average of the " + i + " set of 4 hours " + average);
        }
    }

    public static void sorted(int[] resInput) {
        String[] time = {"00-01", "01-02", "02-03", "03-04", "04-05", "05-06", "06-07", "07-08", "08-09", "09-10", "10-11", "11-12", "12-13", "13-14", "14-15", "15-16", "16-17", "17-18", "18-19", "19-20", "20-21", "21-22", "22-23", "23-24"};
        priceTime[] sortedPriceNTime = new priceTime[24];
        for (int i = 0; i < resInput.length; i++) {
            sortedPriceNTime[i] = new priceTime(resInput[i], time[i]);
        }
        for (priceTime i : sortedPriceNTime) {
            System.out.println(i.getPrice() + " : " + i.getTime());
        }
        System.out.println("sorted:");
        Arrays.sort(sortedPriceNTime);
        for (priceTime i : sortedPriceNTime) {
            System.out.println(i.getPrice() + " : " + i.getTime());
        }
    }

    public static class priceTime implements Comparable<priceTime> {
        private final String time;
        private final int price;

        public priceTime(int price, String time) {
            this.price = price;
            this.time = time;
        }

        public int getPrice() {
            return price;
        }

        public String getTime() {
            return time;
        }

        public String toPrint() {
            return "Price: " + price + "Time: " + time;
        }

        @Override
        public int compareTo(priceTime other) {
            return Integer.compare(this.price, other.price);
        }
    }
}