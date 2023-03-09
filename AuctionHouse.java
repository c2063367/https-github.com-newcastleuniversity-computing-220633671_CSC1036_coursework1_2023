package src;

import java.util.ArrayList;
import java.util.List;

/**
 * Auction House Class to retrieve the name of the auction house, and a list of items that it has sold.
 */
public class AuctionHouse {

    private String name;
    private List<Item> soldItems;

    @Override
    public String toString() {
        return "AuctionHouse {" +
                "name = '" + name + '\'' +
                ", soldItems = " + soldItems +
                '}';
    }

    /**
     * constructor for the item name and added to list of soldItems
     * @param name
     * @param item
     */
    /* soldItems represents the number of items sold under the a*/
    public AuctionHouse(String name, Item item) {
        this.name = name;
        this.soldItems.add(item);
    }

    /**
     * constructor 2 for the name of a auctionHouse
     * @param auctionHouseName
     */

    public AuctionHouse(String auctionHouseName) {
        this.name = auctionHouseName;
        this.soldItems = new ArrayList<>();
    }

    /**
     * add sold items
     * @param item
     */
    public void addSoldItem(Item item) {

        this.soldItems.add(item);
    }

    /**
     * get highest priced sold item
     * @return
     */
    public Item getHighestPricedItem() {
        Item highestPricedItem = null;
        for (Item item : soldItems) {
            if(highestPricedItem==null){
                highestPricedItem = item;
            }else if (item!=null && item.getPrice() > highestPricedItem.getPrice()) {
                highestPricedItem = item;
            }
        }
        return highestPricedItem;
    }

    /**
     * To get an average Price, we would need to add all the sold items prices up(sum)
     * and divide them by the total number of items sold(count)
     * @param Price
     * @return
     */

    public double getAveragePrice(int Price) {
        int count = 0;
        double sum = 0;
        for (Item item : soldItems) {
            if (item!=null && item.getPrice() == Price) {
                count++;
                sum += item.getPrice();
            }
        }
        return sum / count;
    }

    /**
     * get items above price given by previous input
     * @param Price
     * @return
     */
    public List<Item> getItemsAbovePrice(double Price) {
        List<Item> itemsAbovePrice = new ArrayList<>();
        for (Item item : soldItems) {
            boolean getPrice = true;
            if (item!=null && item.getPrice() > Price) {
                itemsAbovePrice.add(item);
            }
        }
        return itemsAbovePrice;
    }

    /**
     * get auction house name
     * @return
     */
    public String getAuctionHouseName() {

        return this.name;
    }

    /**
     * get sold items
     * @return
     */
    public List<Item> getItems() {

        return this.soldItems;
    }
}