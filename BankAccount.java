public class BankAccount {
    private static String bankName="xyz";
    private static int totalCount=0;
    private final String accountNumber;
    private String accountHolderName;

    public BankAccount(String accountNumber,String accountHolderName){
        this.accountNumber=accountNumber;
        this.accountHolderName=accountHolderName;
        totalCount++;
    }
    static int getTotalCount(){
        return totalCount;
    }
    public void displayDetails(){
        if(this instanceof BankAccount){
            System.out.println("Bank Name - "+bankName);
            System.out.println("Account Number - "+accountNumber);
            System.out.println("Account Holder - "+accountHolderName);
        }
    }

    public static void main(String args[]){
        BankAccount a1=new BankAccount("001","Chirag");
        BankAccount a2=new BankAccount("002","Jayant");
        BankAccount a3=new BankAccount("003","Aman");
        a1.displayDetails();
        a2.displayDetails();
        a3.displayDetails();

        System.out.println("Total count = "+BankAccount.getTotalCount());
    }
}
