public class Item {

    // the private variables later to be used in the main method, are initialized outside the main method //
    private int LotNumber;
    private String ItemType;

    private String BuyerName;

    private double Price;
    private double HighestPrice;
    private int year;

    // Getting the variables under the class file 'Item', will ensure that these variables will be able to be fetched to other classes
    public Item(int LotNumber, String ItemType, String BuyerName, double Price, int year) {
        this.LotNumber = LotNumber;
        this.ItemType = ItemType;
        this.BuyerName = BuyerName;
        this.Price = Price;
        this.year = year;

    }
    private boolean validItemType(String ItemType){
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
    public int getLotNumber(){
        return LotNumber;
    }
    public void setLotNumber(){
        this.LotNumber = LotNumber;

    }

    public String getItemType(){
        return ItemType;
    }
    public void setItemType(){
        this.ItemType = ItemType;

    }
    public String getBuyerName(){
        return BuyerName;
    }
    public void setBuyerName(){
        this.BuyerName = BuyerName;

    }
    public double getPrice(){
        return Price;
    }
    public void setPrice(){
        this.Price = Price;

    }
    public double getHighestPrice(){
        return HighestPrice;
    }
    public void setHighestPrice(){
        this.HighestPrice = HighestPrice;
    }
    public int getYear(){
        return year;
    }
    public void setYear(){
        this.year = year;
    }
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
