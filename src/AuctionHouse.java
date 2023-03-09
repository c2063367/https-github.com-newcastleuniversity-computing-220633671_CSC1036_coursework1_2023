package src;

import java.util.ArrayList;
import java.util.List;

/**
 * Auction House
 */
public class AuctionHouse {

    private String name;
    private List<Item> soldItems;

    /**
     * The method is not used and instead used in src.Item class
     * @param
     * @return

    public static boolean validateItemType(String ItemType){
        if(ItemType.equals("Furniture")){
            return true;
        }
        if(ItemType.equals("Painting")){
            return true;
        }
        if(ItemType.equals("Sculpture")) {
            return true;
        }
        return false;
    }
     */

    @Override
    public String toString() {
        return "src.AuctionHouse {" +
                "name = '" + name + '\'' +
                ", soldItems = " + soldItems +
                '}';
    }

    /**
     * constructor
     * @param name
     * @param item
     */
    /* soldItems represents the number of items in*/
    public AuctionHouse(String name, Item item) {
        this.name = name;
        this.soldItems.add(item);
    }

    /**
     * constructor 2
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