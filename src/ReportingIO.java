import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class ReportingIO {

    private static List<AuctionHouse> auctionHouses = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean exit = false;

        int choice;
        while (!exit) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Enter AuctionHouse Data: ");
            System.out.println("2. Enter Item Date: ");
            System.out.println("3. Provide Reporting: ");
            System.out.println("4. Exit");

            choice = scan.nextInt();
            scan.nextLine();


        }
        switch (choice) {
            case 1:
                System.out.println("\n Enter AuctionHouse data");
                System.out.print("Enter name: ");
                String auctionHouseName = scan.nextLine();
                AuctionHouse auctionHouse = new AuctionHouse(auctionHouseName, new ArrayList<>());
                auctionHouses.add(auctionHouse);
                System.out.println("AuctionHouse added");
                break;
            case 2:
                System.out.println("\nEnter Item data: ");
                System.out.print("Name:");]
                String ItemType = scan.nextLine();
                System.out.print("Year: ");
                int year = scan.nextInt();
                System.out.print("Price: ");
                double Price = scan.nextDouble();
                scan.nextLine();
                System.out.print("AuctionHouse name: ");
                String itemAuctionHouseName = scan.nextLine();
                AuctionHouse itemAuctionHouse = getAuctionHouseByName(itemAuctionHouseName);
                if (itemAuctionHouse == null) {
                    System.out.println("Error: AuctionHouse not found");
                    break;
                }
                Item item = new Item(LotNumber, BuyerName, ItemType, year, Price);
                itemAuctionHouse.getItems().add(item);
                System.out.println("Item added");
                break;
            case 3:
                System.out.println("\nPlease choose a reporting statistic: ");
                System.out.println("1. AuctionHouse with largest average item price for a given year");
                System.out.println("2. Highest Price item reported");
                System.out.println("3. All items sold with a price greater than a given amount");

                int reportChoice = scan.nextInt();
                scan.nextLine();

                switch (reportChoice) {
                    case 1:
                        System.out.print("\nEnter the year");
                        int Year = scan.nextInt();
                        AuctionHouse largestAuctionHouse = getAuctionHouseWithLargestAveragePrice(year);
                        if (largestAuctionHouse == null) {
                            System.out.println("Error: no AuctionHouses found with items with specified year");
                            break;

                        }
                        System.out.println("\nAuctionHouse with largest average item price for year" + year + ":");
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
                        ;
                        System.out.print("\n Enter the price threshold: ");

                }
        }
    }
}
