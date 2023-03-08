/**
 * Item - represents the Item bean , stores the type, lot number,item type,buyer name, price,highest price and year.
 */
public class Item {

    // the private variables to store Item information
    private int LotNumber;
    private String ItemType;
    private String BuyerName;
    private double Price;
    private double HighestPrice;
    private int year;

    /**
     * Item constructor
     * @param LotNumber
     * @param ItemType
     * @param BuyerName
     * @param Price
     * @param year
     */
    public Item(int LotNumber, String ItemType, String BuyerName, double Price, int year) {
        this.LotNumber = LotNumber;
        this.ItemType = ItemType;
        this.BuyerName = BuyerName;
        this.Price = Price;
        this.year = year;

    }

    /**
     * valid types equal to the corresponding Auction house name
     * @param ItemType
     * @return
     */
    public static boolean validItemType(String ItemType){
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

    /**
     * get lot number
     * @return
     */
    public int getLotNumber(){
        return LotNumber;
    }

    /**
     * set lot number
     */
    public void setLotNumber(){
        this.LotNumber = LotNumber;
    }

    /**
     * get item type
     * @return
     */
    public String getItemType(){
        return ItemType;
    }

    /**
     * set item type
     */
    public void setItemType(){
        this.ItemType = ItemType;

    }

    /**
     * get buyer name
     * @return
     */
    public String getBuyerName(){
        return BuyerName;
    }

    /**
     * set buyer name
     */
    public void setBuyerName(){
        this.BuyerName = BuyerName;

    }

    /**
     * get price
     * @return
     */
    public double getPrice(){
        return Price;
    }

    /**
     * set price
     */
    public void setPrice(){
        this.Price = Price;
    }

    /**
     * get highest price of the item sold
     * @return
     */
    public double getHighestPrice(){
        return HighestPrice;
    }

    /**
     * set the highest price of the item sold
     */
    public void setHighestPrice(){
        this.HighestPrice = HighestPrice;
    }

    /**
     * get item sold year
     * @return
     */
    public int getYear(){
        return year;
    }

    /**
     * set item year sold
     */
    public void setYear(){
        this.year = year;
    }

    /**
     * test and print purposes
     * @return all data string
     */
    public String toString() {
        return "Item{" +
                "LotNumber is:" + LotNumber + '\'' +
                "Type of Item:" + ItemType + '\'' +
                "Buyer Name='" + BuyerName + '\'' +
                ", Price of Item ='" + Price + '\'' +
                ", Year sold =" + year +
                '}';
    }

}
