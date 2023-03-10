package src;

import java.util.HashMap;

/**
 * Testing:
 *
 * This class adds some sample test data, where you can generate reports for this data and the ReportingIO class to enter your own data yourself and generate reports from your data.
 */
public class TestingClass {
    private static final HashMap<String, AuctionHouse> auctionHouseNameMap = new HashMap<>();
    public static void main(String[] args) {

        //This test class has 3 sample Auction houses , 1 for each item type i.e.( Furniture, Sculpture,and Painting) to demonstrate all item types being valid.
        String auctionHouseName="AH Leeds";
        AuctionHouse auctionHouseFurniture = new AuctionHouse(auctionHouseName);
        auctionHouseNameMap.put(auctionHouseName, auctionHouseFurniture);
        Item ItemF1 = new Item(1, "Furniture","KK",5000.00, 2003 );
        Item ItemF2 = new Item(2, "Furniture","C",100.00, 1999 );
        Item ItemF3 = new Item(3, "Furniture","D",5200.00, 1899 );
        Item ItemF4 = new Item(4, "Furniture","L",1000.00, 2020 );
        Item ItemF5 = new Item(5, "Furniture","Z",5.00, 2000 );
        auctionHouseFurniture.addSoldItem(ItemF1);
        auctionHouseFurniture.addSoldItem(ItemF2);
        auctionHouseFurniture.addSoldItem(ItemF3);
        auctionHouseFurniture.addSoldItem(ItemF4);
        auctionHouseFurniture.addSoldItem(ItemF5);
        auctionHouseName="AH Newcastle";
        AuctionHouse auctionHouseSculpture = new AuctionHouse(auctionHouseName);
        auctionHouseNameMap.put(auctionHouseName, auctionHouseSculpture);
        Item itemS1 = new Item(1, "Sculpture","KK",52000.00, 2003 );
        Item itemS2 = new Item(2, "Sculpture","C",1200.00, 1999 );
        Item itemS3 = new Item(3, "Sculpture","D",52200.00, 1899 );
        Item itemS4 = new Item(4, "Sculpture","L",12000.00, 2020 );
        Item itemS5 = new Item(5, "Sculpture","Z",52.00, 2000 );
        auctionHouseSculpture.addSoldItem(itemS1);
        auctionHouseSculpture.addSoldItem(itemS2);
        auctionHouseSculpture.addSoldItem(itemS3);
        auctionHouseSculpture.addSoldItem(itemS4);
        auctionHouseSculpture.addSoldItem(itemS5);

        auctionHouseName="AH Sheffield";
        AuctionHouse auctionHousePainting = new AuctionHouse(auctionHouseName);
        auctionHouseNameMap.put(auctionHouseName, auctionHousePainting);
        Item itemP1 = new Item(1, "Painting","KK",523000.00, 2003 );
        Item itemP2 = new Item(2, "Painting","C",12030.00, 1999 );
        Item itemP3 = new Item(3, "Painting","D",3300.00, 1899 );
        Item itemP4 = new Item(4, "Painting","L",120300.00, 2020 );
        Item itemP5 = new Item(5, "Painting","Z",523.00, 2000 );
        auctionHousePainting.addSoldItem(itemP1);
        auctionHousePainting.addSoldItem(itemP2);
        auctionHousePainting.addSoldItem(itemP3);
        auctionHousePainting.addSoldItem(itemP4);
        auctionHousePainting.addSoldItem(itemP5);

        System.out.println("Below test data Added for reporting statistics testing :");
        Reporting reporting = new Reporting(auctionHouseNameMap);
        reporting.printData();
        ReportingIO reportingIO = new ReportingIO(auctionHouseNameMap);
        reportingIO.provideReportingStatistics();
    }
}
