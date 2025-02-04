public class Product {
    //using access modifiers on variables
    private static int discount=10;
    private static int count=0;
    private final int productId;
    private String productName;
    private int price;
    private int quantity;
    //constructor
    public Product(String productName, int price, int quantity){
        this.productId=++count;
        this.productName=productName;
        this.price=price;
        this.quantity=quantity;

    }

    //calculating final price after the discount
    public double finalPrice(){
        double discountAmount=(price*discount)/100;
        return price-discountAmount;
    }

    //displaying all the details
    public void display(){
       if(this instanceof Product){
           System.out.println("Product ID : "+productId);
           System.out.println("Product Name : "+productName);
           System.out.println("Product Price : "+price);
           System.out.println("Discount : "+discount+"%, So the final price is "+finalPrice());
           System.out.println("Total Price for " + quantity + " items: " + (finalPrice() * quantity) );
       }
    }

    public static void updateDiscount(int newDiscount){
        discount=newDiscount;
    }
    public static void main(String args[]){

    Product a1=new Product("Bike",5000,2);
    Product a2=new Product("Mobile", 10000, 3);
    Product a3=new Product("Car",20000,1);

    a1.display();
    a2.display();
    a3.display();

    //updating discount percentage from 10 to 15
    Product.updateDiscount(15);

        a1.display();
        a2.display();
        a3.display();

    }
}
