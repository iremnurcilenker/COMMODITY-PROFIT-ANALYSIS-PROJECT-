// Main.java — Students version
import java.io.*;
import java.util.*;

public class Main {
    static final int MONTHS = 12;
    static final int DAYS = 28;
    static final int COMMS = 5;
    static String[] commodities = {"Gold", "Oil", "Silver", "Wheat", "Copper"};
    static String[] months = {"January","February","March","April","May","June",
            "July","August","September","October","November","December"};

    static int [][][] profits = new int [MONTHS][DAYS][COMMS];


    // ======== REQUIRED METHOD LOAD DATA (Students fill this) ========
    public static void loadData() {
        profits = new int[MONTHS][DAYS][COMMS];

        for(int i = 0; i < MONTHS ; i++ ) {
            String fileName = "Data_Files/" + months[i] + ".txt";
            Scanner sc = new Scanner(fileName);
        }
    }

    // ======== 10 REQUIRED METHODS (Students fill these) ========

    public static String mostProfitableCommodityInMonth(int month) {

        if(month<0 || month>11){
            return "INVALID_MONTH";
        }

        int maxCommodityProfit = 0;
        for(int c = 0; c<COMMS; c++){
            int totalProfit = 0;

            for(int d = 0; d<DAYS; d++){
                totalProfit += profits[MONTHS][DAYS][COMMS];
            }
            if (totalProfit > maxCommodityProfit) {
                maxCommodityProfit = totalProfit;
        }

        return "Commodity totalProfit";
    }

    public static int totalProfitOnDay(int month, int day) {
            if (month < 0 || month > 12 || day < 1 || day > 28) {
                return -99999;
            }
            int dayIndex = day - 1; //???????????
            int total = 0;
            for(int c=0; c<COMMS; c++){
                total +=profits[MONTHS][DAYS][COMMS];
            }

        return total;
    }

    public static int commodityProfitInRange(String commodity, int from, int to) {

        }
        return 1234;
    }

    public static int bestDayOfMonth(int month) {
        if(month<0 || month>=12){
            return -1;

            int bestDay = 0;
            int maxProfit =0;
            for(int d = 0; d<28; d++){
                int total =0;
                for(int c =0; c<5; c++){
                    total +=profits[MONTHS][DAYS][COMMS];
                }
                if(total>maxProfit){
                    maxProfit = total;
                }
            }
        }
        return total;
    }

    public static String bestMonthForCommodity(String comm) {
        return "DUMMY";
    }

    public static int consecutiveLossDays(String comm) {
        return 1234;
    }

    public static int daysAboveThreshold(String comm, int threshold) {
        return 1234;
    }

    public static int biggestDailySwing(int month) {
        return 1234;
    }

    public static String compareTwoCommodities(String c1, String c2) {
        return "DUMMY is better by 1234";
    }

    public static String bestWeekOfMonth(int month) {
        return "DUMMY";
    }

    public static void main(String[] args) {
        loadData();
        System.out.println("Data loaded – ready for queries");
    }
}