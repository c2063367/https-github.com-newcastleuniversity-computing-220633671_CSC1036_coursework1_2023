import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

import static java.lang.System.exit;

public class ReportingIO {

    private static List<AuctionHouse> auctionHouses = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        boolean exit = true;
        int choice;
        while (exit) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Enter AuctionHouse Data: ");
            System.out.println("2. Enter Item Date: ");
            System.out.println("3. Provide Reporting: ");
            System.out.println("4. Exit");

            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    try {
                        choice = scan.nextInt();
                        System.out.println("\n Enter AuctionHouse data");
                        System.out.print("Enter name: ");
                        String auctionHouseName = scan.nextLine();
                        AuctionHouse auctionHouse = new AuctionHouse(auctionHouseName, scan.nextInt());
                        auctionHouses.add(auctionHouse);
                        System.out.println("AuctionHouse added");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: Invalid AuctionHouse name");
                    }
                    break;
                case 2:
                    System.out.println("\nEnter Item data: ");
                    System.out.println("LotNumber: ");
                    int LotNumber = scan.nextInt();
                    System.out.println("Name of buyer");
                    String BuyerName = scan.nextLine();
                    System.out.print("Name of Item:");
                    String ItemType = scan.nextLine();
                    System.out.print("Year: ");
                    int year = scan.nextInt();
                    System.out.print("Price: ");
                    double Price = scan.nextDouble();
                    scan.nextLine();
                    System.out.print("AuctionHouse name: ");
                    String itemAuctionHouseName = scan.nextLine();
                    AuctionHouse itemAuctionHouse = getAuctionHouse(itemAuctionHouseName);
                    if (itemAuctionHouse == null) {
                        System.out.println("Error: AuctionHouse not found");
                        break;
                    }
                    try {
                        Item item = new Item(LotNumber, BuyerName, ItemType, Price, year);
                        System.out.println("Item added");
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println();
                    }
                case 3:
                    System.out.println("\nPlease choose a reporting statistic: ");
                    System.out.println("1. AuctionHouse with largest average item price for a given year");
                    System.out.println("2. Highest Price item reported");
                    System.out.println("3. All items sold with a price greater than a given amount");

                    int reportChoice = scan.nextInt();
                    scan.nextLine();
                    try {
                        switch (reportChoice) {
                            case 1:
                                System.out.print("\nEnter the year");
                                int Year = scan.nextInt();
                                AuctionHouse largestAuctionHouse = getAuctionHouseWithLargestAveragePrice(Year);
                                if (largestAuctionHouse == null) {
                                    System.out.println("Error: no AuctionHouses found with items with specified year");
                                    break;

                                }
                                System.out.println("\nAuctionHouse with largest average item price for year" + Year + ":");
                                System.out.println(largestAuctionHouse.getBuyerName());
                                break;
                            case 2:
                                Item largestItem = getItemLargestPrice();
                                System.out.println("\nHighest price item ever reported:");
                                System.out.println("Name: " + largestItem.getBuyerName());
                                System.out.println("Year: " + largestItem.getYear());
                                System.out.println("Price:" + largestItem.getPrice());
                                System.out.println("AuctionHouse: " + getAuctionHouseByItem(largestItem));
                                break;
                            case 3:
                                System.out.print("\n Enter the price threshold: ");

                        }
                        exit(0);
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Invalid Input Type");
                    }
            }
        }
    }
    private static AuctionHouse getAuctionHouseWithLargestAveragePrice(int year) {
        return null;
    }

    private static String getAuctionHouseByItem(Item largestItem) {
        return null;
    }

    private static AuctionHouse getAuctionHouse(String itemAuctionHouseName) {
        return null;
    }

    private static Item getItemLargestPrice() {

    return null;
    }
}
