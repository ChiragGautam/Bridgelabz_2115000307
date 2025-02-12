class Book {
    String title, author, genre;
    int id;
    boolean isAvailable;
    Book next, prev;

    public Book(String title, String author, String genre, int id, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.id = id;
        this.isAvailable = isAvailable;
        this.next = this.prev = null;
    }
}

class Library {
    Book head, tail;
    int totalBooks;

    public void addBookAtBeginning(String title, String author, String genre, int id, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, id, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        totalBooks++;
    }

    public void addBookAtEnd(String title, String author, String genre, int id, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, id, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        totalBooks++;
    }

    public void addBookAtPosition(String title, String author, String genre, int id, boolean isAvailable, int position) {
        if (position <= 1) {
            addBookAtBeginning(title, author, genre, id, isAvailable);
            return;
        }
        if (position > totalBooks) {
            addBookAtEnd(title, author, genre, id, isAvailable);
            return;
        }
        Book newBook = new Book(title, author, genre, id, isAvailable);
        Book current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        newBook.next = current.next;
        newBook.prev = current;
        current.next.prev = newBook;
        current.next = newBook;
        totalBooks++;
    }

    public void removeBook(int id) {
        Book current = head;
        while (current != null) {
            if (current.id == id) {
                if (current == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                totalBooks--;
                return;
            }
            current = current.next;
        }
    }

    public Book searchByTitle(String title) {
        Book current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) return current;
            current = current.next;
        }
        return null;
    }

    public Book searchByAuthor(String author) {
        Book current = head;
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) return current;
            current = current.next;
        }
        return null;
    }

    public void updateAvailability(int id, boolean newStatus) {
        Book current = head;
        while (current != null) {
            if (current.id == id) {
                current.isAvailable = newStatus;
                return;
            }
            current = current.next;
        }
    }

    public void displayForward() {
        Book current = head;
        while (current != null) {
            System.out.println("ID: " + current.id + ", Title: " + current.title + ", Author: " + current.author + 
                               ", Genre: " + current.genre + ", Available: " + current.isAvailable);
            current = current.next;
        }
    }

    public void displayReverse() {
        Book current = tail;
        while (current != null) {
            System.out.println("ID: " + current.id + ", Title: " + current.title + ", Author: " + current.author + 
                               ", Genre: " + current.genre + ", Available: " + current.isAvailable);
            current = current.prev;
        }
    }

    public int countBooks() {
        return totalBooks;
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Library lib = new Library();
        
        lib.addBookAtBeginning("The Alchemist", "Paulo Coelho", "Fiction", 101, true);
        lib.addBookAtEnd("Inferno", "Dan Brown", "Thriller", 102, true);
        lib.addBookAtPosition("Harry Potter", "J.K. Rowling", "Fantasy", 103, true, 2);
        
        lib.displayForward();
        
        lib.removeBook(102);
        
        lib.updateAvailability(101, false);
        
        lib.displayReverse();
        
        System.out.println("Total Books: " + lib.countBooks());
    }
}
