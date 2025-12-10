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

        if (month < 0 || month > 11) {
            return "INVALID_MONTH";
        }
        String maxProfit = "";
        int maxCommodityProfit = 0;
        for (int c = 0; c < COMMS; c++) {
            int totalProfit = 0;
            
            for (int d = 0; d < DAYS; d++) {
                totalProfit += profits[month][d][c];

            }
            if (totalProfit > maxCommodityProfit) {
                maxCommodityProfit = totalProfit;
                maxProfit =commodities[c];
            }


        }
        return maxProfit+" "+Integer.toString(maxCommodityProfit);

    }
        public static int commodityProfitInRange(String commodity, int from, int to) {
        if(from<0 || from>28 || to<0 || to>28 || from>to ){
            return -99999;
        }
        int cc=0;
        for(int i=0;i<COMMS;i++) {
            if (commodities[i].equals(commodity)) {
                cc=i;
                break;
            } else {
                return -99999;
            }
        }
        int totalProfit=0;
        for(int i=from;i<to;i++){
            totalProfit+=profits[MONTHS][i][cc];
        }

            return totalProfit;
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
        if(comm<0 || comm>=5){
            return "INVALID_COMMODITY"
        }

        int bestMonth = 0;
        for(int c = 0; c<COMMS; c++){
            int totalComm = 0;

            if(int m = 0; m<MONTHS; m++){
                totalComm += profits[MONTHS][DAYS][COMMS];
            }
            if()
        }
        return "DUMMY";
    }

    public static int consecutiveLossDays(String comm) {
        return 1234;
    }

    public static int daysAboveThreshold(String comm, int threshold) {
        int commIndex = -1;
        for(int c = 0; c<COMMS; c++){
            if(commodities)
        }
        if(commIndex == -1){
            return -1;
        }
        int count = 0;

        for(int m =0; m<MONTHS; m++){
            for(int d =0; d<DAYS; d++){

            }
        }
        return 1234;
    }

    public static int biggestDailySwing(int month) {
        if(month <0 || month>= MONTHS){
            return -99999;
        }
        int prevTotal = 0;
        for(int c= 0; c<COMMS; c++){
            prevTotal +=
        }
        int maxSwing =0;
        for(int d=1; d<DAYS; d++){
            int currentTotal =0;
            for(int c =0; c<COMMS; c++){

            }
            int diff = currentTotal -prevTotal;
            if (diff<0){
                diff= -diff;
            }
            if(diff>maxSwing){
                maxSwing = diff;
            }
            prevTotal=currentTotal;
        }
        return maxSwing;
    }

    public static String compareTwoCommodities(String c1, String c2) {
        int index1 =-1;
        int index2 =-1;

        if(index1==-1 || index2==-1){
            return "INVALID_COMMODITY";
        }
        int total1=0;
        int total2=0;

        for(int m=0; m<MONTHS; m++) {
            for (int d = 0; d < DAYS; d++) {
                total1 +=;
                total2 +=;
            }
        }
        if(total1==total2){
            return "Equal";
        } else if(total1>total2){
            int diff =total1-total2;
            return c1 +"is better by" + diff;
        } else{
            int diff= total2-total1;
            return c2+"is better by" + diff;
        }
        return "DUMMY is better by 1234";
    }

    public static String bestWeekOfMonth(int month) {
        if(month<0 || month>=12){
            return "INVALID_MONTH";
        }
        int bestWeekIndex = 0;
        int bestWeekProfit =0;

        for(int week = 0; week<=4; week++){

        }

        return "DUMMY";
    }

    public static void main(String[] args) {
        loadData();
        System.out.println("Data loaded – ready for queries");
    }
}