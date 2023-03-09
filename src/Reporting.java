package src;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * Reporting class is for holding information for every auctionHouse the user inputs
 */
public class Reporting {

    private HashMap<String, AuctionHouse> auctionHouseNameMap;

    public Reporting(HashMap<String, AuctionHouse> auctionHouseMap) {
        this.auctionHouseNameMap = auctionHouseMap;
    }

    /**
     * gets the highest priced auction house item of all the auction houses
     *
     * @return Item
     */
    public Item getHighestPricedItem() {
        Item largestItem = null;
        double highestPrice = 0.0;
        for (Map.Entry<String, AuctionHouse> entry : auctionHouseNameMap.entrySet()) {
            String keyAuctionHouseName = entry.getKey();
            AuctionHouse auctionHouse = entry.getValue();
            Item item = auctionHouse.getHighestPricedItem();
            if (item != null && item.getPrice() > highestPrice) {
                highestPrice = item.getPrice();
                largestItem = item;
            }
            System.out.println(keyAuctionHouseName + " has the highest priced item " + largestItem.getItemType() + " of the value of " + +highestPrice);
        }
        return largestItem;
    }

    /**
     * get the auction house name with the largest Average price for a given year
     *
     * @param year - auction year
     * @return
     */

    public AuctionHouse getAuctionHouseWithLargestAveragePrice(int year) {
        AuctionHouse largestAuctionHouse = null;
        double largestAveragePrice = 0.0;
        for (Map.Entry<String, AuctionHouse> entry : auctionHouseNameMap.entrySet()) {
            String key = entry.getKey();
            AuctionHouse auctionHouse = entry.getValue();
            double sum = 0;
            int count = 0;
            for (Item item : auctionHouse.getItemsAbovePrice(year)) {
                if (item.getYear() == year) {
                    sum += item.getPrice();
                    count++;

                }
            } // for loop for all the items sold for an auction house
            double averagePrice = count > 0 ?
                    sum / count : 0;
            if (averagePrice > largestAveragePrice) {
                largestAveragePrice = averagePrice;
                largestAuctionHouse = auctionHouse;
            }
        } //for loop closes the auction houses
        if(largestAuctionHouse!=null) {
            System.out.println(" The largest Average price is : " + largestAveragePrice);
        }
        return largestAuctionHouse;
    }

    /**
     * get all the items of all the auction houses for a minimum price it was sold
     *
     * @param amount
     */
    public List<Item> getItemsWithPriceGreaterThan(double amount) {
        List<Item> resultItems = new ArrayList<>();
        for (Map.Entry<String, AuctionHouse> entry : auctionHouseNameMap.entrySet()) {
            String key = entry.getKey();
            AuctionHouse auctionHouse = entry.getValue();
            for (Item item : auctionHouse.getItemsAbovePrice(amount)) {
                if (item.getPrice() > amount) {
                    resultItems.add(item);
                }
            }
        }
        return resultItems;
    }

    /**
     * Test method prints all test data, using a hashmap with a key and value, https://stackoverflow.com/questions/3973512/java-hashmap-how-to-get-a-key-and-value-by-index
     * prints all the items of all the auction houses
     * test purposes only -> for the developer to see all the data entered via testing classes
     */
    public void printData() {
        List<Item> resultItems = new ArrayList<>();
        int iAuctionHouseIndex = 1;
        for (Map.Entry<String, AuctionHouse> entry : auctionHouseNameMap.entrySet()) {
            String auctionHouseName = entry.getKey();
            AuctionHouse auctionHouse = entry.getValue();
            System.out.println("Auction House Name " + iAuctionHouseIndex + ": " + auctionHouseName);
            iAuctionHouseIndex++;
            int iItemIndex = 1;
            for (Item item : auctionHouse.getItems()) {
                System.out.println("List of sold Items" + iItemIndex + ": " + item.toString());
                iItemIndex++;
            }
        }
    }
}