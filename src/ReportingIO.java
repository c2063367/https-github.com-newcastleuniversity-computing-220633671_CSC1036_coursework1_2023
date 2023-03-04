import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.HashMap;

import static java.lang.System.exit;

public class ReportingIO {

    private static List<AuctionHouse> auctionHouses = new ArrayList<>();
    /**
     * EVK Kalirajan - unique value mapping for all the auction houses created for testing
     */
    private static HashMap<String, ArrayList> auctionHouseNameMap = new HashMap<>();

        public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        boolean exit = true;
        int choice;
        while (exit) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Enter AuctionHouse Data: ");
            System.out.println("2. Enter Item Data: ");
            System.out.println("3. Provide Reports: ");
            System.out.println("4. Exit");
            AuctionHouse actionHouse = null;
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    try {
                        System.out.println("\nEnter AuctionHouse data");
                        System.out.print("Enter name: ");
                        String auctionHouseName = scan.nextLine();
                        if(!auctionHouseNameMap.containsKey(auctionHouseName)){
                            AuctionHouse auctionHouse = new AuctionHouse(auctionHouseName);
                            auctionHouses.add(auctionHouse);
                        }else{
                            System.out.println(auctionHouseName +" AuctionHouse already exists");
                        }
                        System.out.println("AuctionHouse added");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: Invalid AuctionHouse name");
                    }
                    break;
                case 2:
                    enterItemInfo(scan);
                case 3:
                    provideReportingStatistics();
                case 4:
                     exit = false;
            }
        }
    }

    private static void enterItemInfo(Scanner scannerForItemInfo){
        System.out.println("\nEnter Item data; ");
        scannerForItemInfo.nextLine();
        System.out.println("Name of Buyer: ");
        String BuyerName = scannerForItemInfo.nextLine();
        System.out.println("LotNumber: ");
        int LotNumber = scannerForItemInfo.nextInt();
        System.out.print("Name of Item:");
        String ItemType = scannerForItemInfo.nextLine();
        System.out.print("Year: ");
        int year = scannerForItemInfo.nextInt();
        System.out.print("Price: ");
        double Price = scannerForItemInfo.nextDouble();
        scannerForItemInfo.nextLine();
        System.out.print("AuctionHouse name:");
        String itemAuctionHouseName = scannerForItemInfo.nextLine();
        try {
            AuctionHouse itemAuctionHouse = new AuctionHouse(itemAuctionHouseName);
            if (itemAuctionHouse != null) {
                System.out.println("Error: AuctionHouse not found");
            }
            Item item = new Item(LotNumber, BuyerName, ItemType, Price, year);
            System.out.println("Item added");
        } catch (NumberFormatException e) {
            System.out.println();
        }
    }

    /** TODO
     * Name - Ezhilvijaykarthik kalirajan - CC
     * Desc- This method
     */

    public static void provideReportingStatistics() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a reporting type:");
        System.out.println("a. Largest average item price for a given year");
        System.out.println("b. Highest price item ever reported (including all its details)");
        System.out.println("c. All items sold with a price greater than a given amount (including all their details)");
        String choice = scanner.nextLine();
        //KK - instantiate the Reporting java class
        Reporting reporting = new Reporting(auctionHouses);
        switch (choice) {
            case "a":
                System.out.println("Please enter the year:");
                int year = Integer.parseInt(scanner.nextLine());
                AuctionHouse maxAvgPriceAuctionHouse = reporting.getAuctionHouseWithLargestAveragePrice(year);
                if (maxAvgPriceAuctionHouse == null) {
                    System.out.println("No auction houses found for the given year.");
                } else {
                    System.out.println("The auction house with the largest average item price for the year " + year + " is " + maxAvgPriceAuctionHouse.getAuctionHouseName() + ".");
                }
                break;
            case "b":
                Item maxPriceItem = reporting.getHighestPrice();
                if (maxPriceItem == null) {
                    System.out.println("No items found.");
                } else {
                    System.out.println("The item with the highest price ever reported is:");
                    System.out.println(maxPriceItem.toString());
                }
                break;
            case "c":
                System.out.println("Please enter the minimum price:");
                double minPrice = Double.parseDouble(scanner.nextLine());
                List<Item> itemsAboveMinPrice = reporting.getItemsWithPriceGreaterThan(minPrice);
                if (itemsAboveMinPrice.isEmpty()) {
                    System.out.println("No items found above the given minimum price.");
                } else {
                    System.out.println("The following items were sold with a price greater than " + minPrice + ":");
                    for (Item item : itemsAboveMinPrice) {
                        System.out.println(item.toString());
                    }
                }
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
}