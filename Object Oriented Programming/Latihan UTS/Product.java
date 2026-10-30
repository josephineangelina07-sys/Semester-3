public class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock){
        this.name = name;
        setPrice(price);
        setStock(stock);
    }

    public void setPrice(double price){
        if(price < 0){
            System.out.println("Invalid input");
        }else{
            this.price = price;
        }
    }

    public void setStock(int stock){
        if(stock < 0){
            System.out.println("Invalid inpit");
        }else{
            this.stock = stock;
        }
    }

    @Override 
    public String toString(){
        return "Product Name: " + name + " | Price: $" + price + " | Stock: " + stock;
    }
}
