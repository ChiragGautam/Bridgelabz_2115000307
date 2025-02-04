public class Book {
    static String libraryName="CG";
    final String isbn;
    String title;
    String author;

    public Book(String author,String title, String isbn){
        this.author=author;
        this.title=title;
        this.isbn=isbn;
    }

    public static void displayLibraryName(){
        System.out.println("Library Name : "+libraryName);
    }

    public void displayBookDetail(){
        System.out.println("Title : "+title);
        System.out.println("Author : "+author);
        System.out.println("ISBN : "+isbn);
    }
    public void main(String args[]){
        Book b1=new Book("Chirag","The Life","1234");

        if(b1 instanceof Book){
            System.out.println("It is an instance of the book class");
        }

        b1.displayBookDetail();
        Book.displayLibraryName();


    }
}
