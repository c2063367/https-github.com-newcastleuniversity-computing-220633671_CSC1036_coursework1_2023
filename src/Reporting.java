import java.util.List;
import java.util.ArrayList;

public class Reporting {

    private List<AuctionHouse> auctionHouses;

    public Reporting(List<AuctionHouse> auctionHouses) {
        this.auctionHouses = new ArrayList<>();

    }

    /**
     * TOTO - change the method to be appropriate to reflect the actual requirement and the implementation
     * @returnkkhjklh
     */
    public Item getHighestPrice(){
        Item largestItem = null;
        double HighestPrice = 0.0;
        for (AuctionHouse auctionHouse : auctionHouses) {
            for (Item item : auctionHouse.getItemsAbovePrice(getHighestPrice().getPrice())){
                if (item.getPrice() > HighestPrice){
                    HighestPrice = item.getPrice();
                    largestItem = item;
                }
            }
        }
        return largestItem;
    }
public AuctionHouse getAuctionHouseWithLargestAveragePrice(int year){
    AuctionHouse largestAuctionHouse = null;
    double largestAveragePrice = 0.0;
    for(AuctionHouse auctionHouse : auctionHouses) {
        double sum = 0;
        int count = 0;
        for (Item item : auctionHouse.getItemsAbovePrice(year)) {
            if (item.getYear() == year) {
                sum += item.getPrice();
                count++;

            }
        } //KK-C2063367: for loop for all the items sold for an auction house
        double averagePrice = count > 0 ?
                sum/count : 0;
        if (averagePrice > largestAveragePrice){
            largestAveragePrice = averagePrice;
            largestAuctionHouse = auctionHouse;
        }
    } //KK-C2063367:for loop closing the auction houses
    return largestAuctionHouse;
    }

    /**
     * TODO- change the method name to reflect the implementation
     * @param amount
     * @return
     */
    public List<Item> getItemsWithPriceGreaterThan(double amount) {
        List<Item> result = new ArrayList<>();
        for (AuctionHouse auctionHouse : auctionHouses) {
            for (Item item : auctionHouse.getItemsAbovePrice(amount)) {
                if (item.getPrice() > amount) {
                    result.add(item);
                }
            }
        }
        return result;
    }
}
