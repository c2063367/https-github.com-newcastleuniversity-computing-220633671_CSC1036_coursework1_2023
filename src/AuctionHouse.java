import java.util.ArrayList;
import java.util.List;
public class AuctionHouse {

    private String name;
    private List<Item> soldItems;


/* soldItems represents the number of furniture separately in a array*/
    public AuctionHouse(String name, int soldItems) {
        this.name = name;
        this.soldItems = new ArrayList<>();


    }

    public void addSoldItem(Item item) {
        soldItems.add(item);

    }

    public Item getHighestPrice() {
        Item HighestPrice = null;
        for (Item item : soldItems) {
            if (item.getPrice() > HighestPrice.getPrice()) {
                HighestPrice = item;
            }

        }
        return HighestPrice;

    }

    /* To get an average Price, we would need to add all the sold items prices up(sum), and divide them by the total number of items sold(count)*/
    public double getAveragePrice(int Price) {
        int count = 0;
        double sum = 0;
        for (Item item : soldItems) {
            if (item.getPrice() == Price) {
                count++;
                sum += item.getPrice();
            }

        }
        return sum / count;
    }

    public List<Item> getItemsAbovePrice(double Price) {
        List<Item> ItemsAbovePrice = new ArrayList<>();
        for (Item item : soldItems) {
            boolean getPrice = true;
            if (item.getPrice() > Price) {
                ItemsAbovePrice.add(item);
            }
        }
        return ItemsAbovePrice;
    }

    public String getBuyerName() {
        return null;
    }

    public String getItems() {
        return null;
    }



}