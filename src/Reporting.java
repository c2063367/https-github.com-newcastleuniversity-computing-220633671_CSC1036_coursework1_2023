import java.util.List;
import java.util.ArrayList;

public class Reporting {

    private List<AuctionHouse> auctionHouses;

    public Reporting(List<AuctionHouse> auctionHouses) {
        this.auctionHouses = new ArrayList<>();

    }
    public Item getItemLargestPrice(){
        Item largestItem = null;
        double largestPrice = Double.NEGATIVE_INFINITY;
        for (AuctionHouse auctionHouse : auctionHouses) {
            for (Item item : auctionHouse.getItemsAbovePrice()){
                if (item.getPrice() > largestPrice){
                    largestPrice = item.getPrice();
                    largestItem = item;
                }
            }
        }
        return largestItem;
    }
public AuctionHouse getAuctionHouseWithLargestAveragePrice(int year){
    AuctionHouse largestAuctionHouse = null;
    double largestAveragePrice = Double.NEGATIVE_INFINITY;
    for(AuctionHouse auctionHouse : auctionHouses) {
        double sum = 0;
        int count = 0;
        for (Item item : auctionHouse.getItemsAbovePrice()) {
            if (item.getYear() == year) {
                sum += item.getPrice();
                count++;

            }
        }
        double averagePrice = count > 0 ?
                sum/count : 0;
        if (averagePrice > largestAveragePrice){
            largestAveragePrice = averagePrice;
            largestAuctionHouse = auctionHouse;
        }
        }
    return largestAuctionHouse;
    }
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
