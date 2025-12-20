// Main.java — Students version
import java.io.*;
import java.util.*;

public class Main {
    static final int MONTHS = 12;
    static final int DAYS = 28;
    static final int COMMS = 5;
    static String[] commodities = new String[]{"Gold", "Oil", "Silver", "Wheat", "Copper"};
    static String[] months = new String[]{"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

    static int [][][] profits = new int [MONTHS][DAYS][COMMS];


    // ======== REQUIRED METHOD LOAD DATA (Students fill this) ========
    public static void loadData() {

        for (int m = 0; m < MONTHS; m++) {

            String fileName = "Data_Files/" + months[m] + ".txt";

            try {
                Scanner sc = new Scanner(new File(fileName));

                while (sc.hasNextLine()) {
                    String line = sc.nextLine().trim();
                    if (line.isEmpty()) continue;

                    String[] parts = line.split(",");

                    int dayFromFile = Integer.parseInt(parts[0]);
                    String commName = parts[1];
                    int profit = Integer.parseInt(parts[2]);

                    int dayIndex = dayFromFile - 1;
                    int commIndex = -1;
                    for (int c = 0; c < COMMS; c++) {
                        if (commodities[c].equals(commName)) {
                            commIndex = c;
                            break;
                        }
                    }
                    if (dayIndex >= 0 && dayIndex < DAYS && commIndex != -1) {
                        profits[m][dayIndex][commIndex] = profit;
                    }
                }

                sc.close();

            } catch (Exception e) {
                System.out.println("File could not be read: " + fileName);
            }
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
        return maxProfit + " " + maxCommodityProfit;

    }
    public static int commodityProfitInRange(String commodity, int from, int to) {
        if(from<0 || to<0 || to>28 || from>to ){
            return -99999;
        }
        int cc=0;
        int check=0;
        for(int i=0;i<COMMS;i++) {
            if (commodities[i].equals(commodity)) {
                cc=i;
                check++;
                break;
            }
        }
        if (check==0){
            return -99999;
        }
        int totalProfit=0;
        for(int i=from;i<to;i++){
            totalProfit+=profits[4][i][cc];
        }

        return totalProfit;
    }


    public static int totalProfitOnDay(int month, int day) {
        if (month < 0 || month > 11 || day < 0 || day > 27) {
            return -99999;
        }
        int total = 0;
        for(int c=0; c<COMMS; c++){
            total +=profits[month][day][c];
        }

        return total;
    }

    public static int bestDayOfMonth(int month) {
        if(month<0 || month>=12) {
            return -1;
        }
            int bestDay = 0;
            int maxProfit =0;
            for(int d = 0; d<28; d++){
                int total =0;
                for(int c =0; c<5; c++){
                    total +=profits[month][d][c];
                }
                if(total>maxProfit){
                    maxProfit = total;
                }
            }
        return bestDay+1;
        }



    public static String bestMonthForCommodity(String comm) {
        int cc=0;
        int check=0;
        for(int i=0;i<COMMS;i++) {
            if (commodities[i].equals(comm)) {
                cc=i;
                check++;
                break;
            }
        }
        if (check==0){
            return "INVALID_COMMODITY";
        }

        int month=0;
        int bestMonth = 0;
        for(int m = 0; m<MONTHS; m++){
            int totalComm = 0;
            for(int d = 0; d<DAYS; d++){
                totalComm += profits[m][d][cc];
            }
            if(totalComm>bestMonth){
                bestMonth=totalComm;
                month=m;
            }

        }
        return months[month];
    }

    public static int consecutiveLossDays(String comm) {
        int cc=0;
        int check=0;
        for(int i=0;i<COMMS;i++) {
            if (commodities[i].equals(comm)) {
                cc=i;
                check++;
                break;
            }
        }
        if (check==0){
            return -1;
        }
        int loss=0;
        int biggestLoss=0;
        int daily;
        for (int i = 0; i < MONTHS; i++) {

            for (int j = 0; j < DAYS; j++) {


                    daily = profits[i][j][cc];

                if(daily<0){
                    loss++;
                }
                else {
                    if(loss>biggestLoss){
                        biggestLoss=loss;
                    }
                    loss=0;
                }
            }
        }
        return biggestLoss;
    }

    public static int daysAboveThreshold(String comm, int threshold) {
        int cc=0;
        int check=0;
        for(int i=0;i<COMMS;i++) {
            if (commodities[i].equals(comm)) {
                cc=i;
                check++;
                break;
            }
        }
        if (check==0){
            return -1;
        }
        int count = 0;
        for(int m =0; m<MONTHS; m++){
            for(int d =0; d<DAYS; d++){
                if(threshold<profits[m][d][cc]){
                    count++;
                }
            }
        }
        return count;
    }

    public static int biggestDailySwing(int month) {
        if(month <0 || month>= MONTHS){
            return -99999;
        }
        int prevTotal = 0;
        int maxSwing =0;
        for(int d=0; d<DAYS; d++){
            int currentTotal =0;
            for(int c =0; c<COMMS; c++){
            currentTotal+=profits[month][d][c];
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

        int total1=0;
        int total2=0;
        int cc1=0;
        int check1=0;
        for(int i=0;i<COMMS;i++) {
            if (commodities[i].equals(c1)) {
                cc1=i;
                check1++;
                break;
            }
        }
        if (check1==0){
            return "INVALID_COMMODITY";
        }
        int cc2=0;
        int check2=0;
        for(int i=0;i<COMMS;i++) {
            if (commodities[i].equals(c2)) {
                cc2=i;
                check2++;
                break;
            }
        }
        if (check2==0){
            return "INVALID_COMMODITY";
        }
        for(int m=0; m<MONTHS; m++) {
            for (int d = 0; d < DAYS; d++) {
                total1 +=profits[m][d][cc1];
                total2 +=profits[m][d][cc2];
            }
        }
        if(total1==total2){
            return "Equal";
        } else if(total1>total2){
            int diff =total1-total2;
            return c1 +" is better by " + diff;
        } else{
            int diff= total2-total1;
            return c2+" is better by " + diff;
        }
    }

    public static String bestWeekOfMonth(int month) {
        if(month<0 || month>=12){
            return "INVALID_MONTH";
        }
        int bestWeekIndex = 0;
        int bestWeekProfit =0;

        for(int week = 0; week<4; week++){
            int weeklyProfit=0;
            for(int i=week*7;i<week*7+7;i++){
                for(int c=0;c<COMMS;c++){
                    weeklyProfit+=profits[month][i][c];
                }
            }
            if(weeklyProfit>bestWeekProfit){
                bestWeekProfit=weeklyProfit;
                bestWeekIndex=week+1;
            }

        }

        return "Week" + bestWeekIndex;
    }

    public static void main(String[] args) {
        loadData();
        System.out.println("Data loaded – ready for queries");
        System.out.println(mostProfitableCommodityInMonth(4));
        System.out.println(commodityProfitInRange("Silver",4,16));
        System.out.println(totalProfitOnDay(0,7));
        System.out.println(bestDayOfMonth(7));
        System.out.println(bestMonthForCommodity("Gold"));
        System.out.println(consecutiveLossDays("Wheat"));
        System.out.println(daysAboveThreshold("Copper",300));
        System.out.println(biggestDailySwing(10));
        System.out.println(bestWeekOfMonth(7));
        System.out.println(compareTwoCommodities("Gold","Oil"));
    }
}