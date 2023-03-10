package src;
/**
 * Item - represents the Item class, lot number,item type,buyer name, price,the highest price and year.
 */
public class Item {

    // the private variables store an Item's information
    private int LotNumber;
    private String ItemType;
    private String BuyerName;
    private double Price;
    private double HighestPrice;
    private int year;

    /**
     * Item constructors
     * @param LotNumber is the number of the auctionHouse
     * @param ItemType type of item in auctionHouse
     * @param BuyerName name of Buyer
     * @param Price Price of auctionHouse
     * @param year Year the auctionHouse was sold
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
     * @param ItemType could be furniture, painting or a sculpture
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
     * gets lot number of auctionHouse
     */
    public int getLotNumber(){

        return LotNumber;
    }

    /**
     * sets lot number
     */
    public void setLotNumber(){

        this.LotNumber = LotNumber;
    }

    /**
     * gets item type
     */
    public String getItemType(){

        return ItemType;
    }

    /**
     * sets item type
     */
    public void setItemType(){
        this.ItemType = ItemType;

    }

    /**
     * gets buyer name
     * @return
     */
    public String getBuyerName(){

        return BuyerName;
    }

    /**
     * sets buyer name
     */
    public void setBuyerName() {
        this.BuyerName = BuyerName;

    }

    /**
     * gets the price
     * @return
     */
    public double getPrice(){
        return Price;
    }

    /**
     * sets the price
     */
    public void setPrice(){

        this.Price = Price;
    }

    /**
     * gets the highest price of the item sold
     * @return
     */
    public double getHighestPrice(){

        return HighestPrice;
    }

    /**
     * sets the highest price of the item sold
     */
    public void setHighestPrice(){
        this.HighestPrice = HighestPrice;
    }

    /**
     * gets the item that was sold in the year
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
