public class testing {
    public static void main(String[] args) {
        Item Item1 = new Item(1, "Furniture","KK",5000.00, 2003 );
        Item Item2 = new Item(2, "Sculpture","C",100.00, 1999 );
        Item Item3 = new Item(3, "Painting","D",5200.00, 1899 );
        Item Item4 = new Item(4, "Carpet","L",1000.00, 2020 );
        Item Item5 = new Item(5, "Lamp","Z",5.00, 2000 );

        AuctionHouse a = new AuctionHouse("Building 1", 5 );
        a.addSoldItem(Item1);
        a.addSoldItem(Item2);
        a.addSoldItem(Item3);
        a.addSoldItem(Item4);
        a.addSoldItem(Item5);
        AuctionHouse b = new AuctionHouse("Building 2", 2 );
        b.addSoldItem(Item1);
        b.addSoldItem(Item2);
        b.addSoldItem(Item3);
        b.addSoldItem(Item4);
        b.addSoldItem(Item5);
        AuctionHouse c = new AuctionHouse("Building 3", 1 );
        c.addSoldItem(Item1);
        c.addSoldItem(Item2);
        c.addSoldItem(Item3);
        c.addSoldItem(Item4);
        c.addSoldItem(Item5);


        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
