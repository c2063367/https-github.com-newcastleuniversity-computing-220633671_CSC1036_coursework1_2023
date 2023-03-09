package src;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.HashMap;

/**
 * Main class interacts with Auction House program,
 * This main class provides the instructions for the user to provide inputs and interact with the program.
 * No database connection, user entered data available only at the runtime.
 * The user entered data will be lost after the program exit
 */
public class ReportingIO {
    /**
     * unique value mapping for all the auction houses created
     */
    private static HashMap<String, AuctionHouse> auctionHouseNameMap = new HashMap<>();
    /**
     *Hashmap in a static for the IO class, got example online:
     * https://stackoverflow.com/questions/507602/how-can-i-initialise-a-static-map
     */
    private static AuctionHouse auctionHouse = null; // Initialized based on the user input

    /**
     * empty constructor to be for a free test
     */
    public ReportingIO(HashMap<String,AuctionHouse> testAuctionHouseNameMap) {
        this.auctionHouseNameMap = testAuctionHouseNameMap;
    }

    /**
     * Main method for java command line interface
     */
    public static void main(String[] args) {
        Scanner scanUserInput = new Scanner(System.in);
        boolean runAuctionHouseProgram = true;
        int choice;
        while (runAuctionHouseProgram) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Enter AuctionHouse Data: ");
            System.out.println("2. Enter Item Data: ");
            System.out.println("3. Provide Reports: ");
            System.out.println("4. Exit");
            try {
                choice = scanUserInput.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter AuctionHouse data");
                        scanUserInput.nextLine();
                        System.out.print("Enter name:");
                        String auctionHouseName = scanUserInput.nextLine();
                         if (auctionHouseName!=null && auctionHouseName.length()>0 && !auctionHouseNameMap.containsKey(auctionHouseName)) {
                            auctionHouse = new AuctionHouse(auctionHouseName);
                            auctionHouseNameMap.put(auctionHouseName, auctionHouse);
                            System.out.println("AuctionHouse " +auctionHouseName+ " is added");
                        } else {
                            System.out.println(auctionHouseName + " AuctionHouse is already exists or you entered a wrong auction house name repeatedly");
                            System.out.println("Enter correct Auction House by entering 1 or exit by entering '4' or enter '2' to add new Items to the auction house");
                        }
                        break;
                    case 2:
                        enterItemInfo(scanUserInput);
                        break;
                    case 3:
                        provideReportingStatistics();
                        break;
                    case 4:
                        runAuctionHouseProgram = false;
                        System.out.println("Thank you for using the Auction House program!");
                        System.exit(0);
                }
            }catch (IllegalArgumentException e) {
                System.out.println("Error: Invalid AuctionHouse name, existing program");
                break;
            } catch (InputMismatchException eIM) {
                System.out.println("Entered incorrect value, exiting program");
                break;
            }
        }
    }

    /**
     * Enters item info for an auction house
     * ->Item information added to the program
     * @param scannerForItemInfo
     */
    private static void enterItemInfo(Scanner scannerForItemInfo){
        try {
            System.out.println("\nEnter Item data; ");
            scannerForItemInfo.nextLine();
            System.out.println("Name of Buyer: ");
            String BuyerName = scannerForItemInfo.nextLine();
            System.out.println("LotNumber: ");
            int LotNumber = scannerForItemInfo.nextInt();
            scannerForItemInfo.nextLine();
            System.out.print("Item Type:");
            String itemType = scannerForItemInfo.nextLine();
            if(!Item.validItemType(itemType)) {
                System.out.println("Valid Item types are: 'Furniture', or 'Painting' or 'Sculpture'");
                System.out.println("Re-Enter a valid Item Type:");
                itemType = scannerForItemInfo.nextLine();
            }
            System.out.print("Year: ");
            int year = scannerForItemInfo.nextInt();
            System.out.print("Price: ");
            double Price = scannerForItemInfo.nextDouble();
            scannerForItemInfo.nextLine();
            System.out.print("AuctionHouse name:");
            String itemAuctionHouseName = scannerForItemInfo.nextLine();
            if(auctionHouseNameMap.containsKey(itemAuctionHouseName)){ // checks if the auction house exists or if it doesn't
                auctionHouse = auctionHouseNameMap.get(itemAuctionHouseName);//gets the auction house by passing the name
            }else{
                auctionHouse = new AuctionHouse(itemAuctionHouseName);
            }
            System.out.println("Item added to the auction house :" + itemAuctionHouseName);
            if(Item.validItemType(itemType)) {
                Item item = new Item(LotNumber, BuyerName, itemType, Price, year);
                auctionHouse.addSoldItem(item);
                auctionHouseNameMap.put(itemAuctionHouseName,auctionHouse);
            }else{
                System.out.println("Auction House item data not added because the value of Item Type entered is not valid: exiting program");
            }

        }catch (NumberFormatException eNum) {
            System.out.println("entered incorrect value, exiting program");
        }catch (InputMismatchException eIM) {
            System.out.println("entered incorrect value, exiting program");
        }
    }

    /**
     * Auction House reporting interaction method.
     * 3 types of report interactions.
     * Desc- This method prompts the user to enter information about an item for auction.
     * It takes in a scanner object and uses it to read input from the user.
     * The user is asked to enter the name of the buyer, lot number, name of the item, year, price, and auction house name.
     * It then creates a AuctionHouse and Item object with the given information and adds the Item to the AuctionHouse.
     * If the AuctionHouse is not found, an error message is displayed.
     * If any input is invalid, a NumberFormatException/InputMismatchException is thrown and caught.
     * @return void
     * @throws NumberFormatException if any input is invalid
     * @throws InputMismatchException if the input does not match the pattern of the Scanner
     */
    public static boolean provideReportingStatistics() {
        Scanner scanner = new Scanner(System.in);
        // Instantiate the src.Reporting java class
        Reporting reporting = new Reporting(auctionHouseNameMap);
        boolean reportComplete = false;
        while (!reportComplete) {
            System.out.println("Please choose a reporting type:");
            System.out.println("a. Largest average item price for a given year");
            System.out.println("b. Highest price item ever reported (including all its details)");
            System.out.println("c. All items sold with a price greater than a given amount (including all their details)");
            System.out.println("d. Exit Reports");
            String choice = scanner.nextLine();
            switch (choice) {
                case "a" -> {
                    System.out.println("Please enter the year:");
                    int year = Integer.parseInt(scanner.nextLine());
                    AuctionHouse maxAvgPriceAuctionHouse = reporting.getAuctionHouseWithLargestAveragePrice(year);
                    if (maxAvgPriceAuctionHouse == null) {
                        System.out.println("No auction houses found for the given year.");
                    } else {
                        System.out.println("The auction house " + maxAvgPriceAuctionHouse.getAuctionHouseName() + " had the largest average item price of for the year " + year + ".");
                    }
                }
                case "b" -> {
                    Item maxPriceItem = reporting.getHighestPricedItem();
                    if (maxPriceItem == null) {
                        System.out.println("No items found.");
                    } else {
                        System.out.println("The item with the highest price ever reported is:");
                        System.out.println(maxPriceItem.toString());
                    }
                }
                case "c" -> {
                    System.out.println("Please enter the minimum price:");
                    double minPrice = Double.parseDouble(scanner.nextLine());//parseDouble helps to return a double from the user input
                    List<Item> itemsAboveMinPrice = reporting.getItemsWithPriceGreaterThan(minPrice);
                    if (itemsAboveMinPrice.isEmpty()) {
                        System.out.println("No items found above the given minimum price.");
                    } else {
                        System.out.println("The following items were sold with a price greater than " + minPrice + ":");
                        int i = 1; //to print each item with the array index starting from 1
                        for (Item item : itemsAboveMinPrice) {
                            System.out.println(i + ":" + item.toString());
                            i++;
                        }
                    }
                }
                case "d" -> {
                    reportComplete = true;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
        return true;
    }
}
/** This method provides a user interface for generating report statistics for auction houses and items, the user is prompted to choose three options:
 * A: Largest average item price for a given year
 * B: Highest Price Item ever reported
 * C: All items sold for the price greater than a given amount
 * Depending on the user's choice, the method calls different methods from the Reporting Class to generate the requested statistics. The Reporting Class is instantiated with the auctionHouse parameter.
 */