class MovieNode {
    String title;
    String director;
    int yearOfRelease;
    double rating;
    MovieNode next;
    MovieNode prev;

    public MovieNode(String title, String director, int yearOfRelease, double rating) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieManagementSystem {
    MovieNode head;
    MovieNode tail;

    public MovieManagementSystem() {
        head = null;
        tail = null;
    }

    // Add movie at the beginning
    public void addMovieAtBeginning(String title, String director, int yearOfRelease, double rating) {
        MovieNode newMovie = new MovieNode(title, director, yearOfRelease, rating);
        if (head == null) {
            head = newMovie;
            tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add movie at the end
    public void addMovieAtEnd(String title, String director, int yearOfRelease, double rating) {
        MovieNode newMovie = new MovieNode(title, director, yearOfRelease, rating);
        if (tail == null) {
            head = newMovie;
            tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add movie at a specific position
    public void addMovieAtPosition(int position, String title, String director, int yearOfRelease, double rating) {
        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }

        MovieNode newMovie = new MovieNode(title, director, yearOfRelease, rating);

        if (position == 1) {
            addMovieAtBeginning(title, director, yearOfRelease, rating);
            return;
        }

        MovieNode current = head;
        int currentPosition = 1;

        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current == null) {
            System.out.println("Position exceeds the list size");
        } else {
            newMovie.next = current.next;
            if (current.next != null) {
                current.next.prev = newMovie;
            }
            current.next = newMovie;
            newMovie.prev = current;
        }
    }

    // Remove movie by title
    public void removeMovieByTitle(String title) {
        if (head == null) {
            System.out.println("Movie list is empty");
            return;
        }

        MovieNode current = head;

        while (current != null && !current.title.equalsIgnoreCase(title)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Movie not found");
            return;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
    }

    // Search movie by director or rating
    public void searchMovie(String searchQuery) {
        MovieNode current = head;
        boolean found = false;

        while (current != null) {
            if (current.director.equalsIgnoreCase(searchQuery) || Double.toString(current.rating).equals(searchQuery)) {
                System.out.println("Movie found: " + current.title + ", Director: " + current.director + ", Year: " + current.yearOfRelease + ", Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No movie found matching the search criteria.");
        }
    }

    // Update movie rating by title
    public void updateMovieRating(String title, double newRating) {
        MovieNode current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating of the movie \"" + title + "\" updated to: " + newRating);
                return;
            }
            current = current.next;
        }

        System.out.println("Movie with title \"" + title + "\" not found.");
    }

    // Display all movies in forward order
    public void displayMoviesForward() {
        if (head == null) {
            System.out.println("Movie list is empty");
            return;
        }

        MovieNode current = head;
        while (current != null) {
            System.out.println("Movie: " + current.title + ", Director: " + current.director + ", Year: " + current.yearOfRelease + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display all movies in reverse order
    public void displayMoviesReverse() {
        if (tail == null) {
            System.out.println("Movie list is empty");
            return;
        }

        MovieNode current = tail;
        while (current != null) {
            System.out.println("Movie: " + current.title + ", Director: " + current.director + ", Year: " + current.yearOfRelease + ", Rating: " + current.rating);
            current = current.prev;
        }
    }
}

public class MovieManagementApp {
    public static void main(String[] args) {
        MovieManagementSystem system = new MovieManagementSystem();

        system.addMovieAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        system.addMovieAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        system.addMovieAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        system.addMovieAtPosition(2, "Memento", "Christopher Nolan", 2000, 8.4);

        System.out.println("All movies (Forward Order):");
        system.displayMoviesForward();

        System.out.println("\nAll movies (Reverse Order):");
        system.displayMoviesReverse();

        System.out.println("\nSearch movie by director 'Christopher Nolan':");
        system.searchMovie("Christopher Nolan");

        System.out.println("\nUpdate rating for 'Inception':");
        system.updateMovieRating("Inception", 9.0);
        system.displayMoviesForward();

        System.out.println("\nRemove movie 'The Dark Knight':");
        system.removeMovieByTitle("The Dark Knight");
        system.displayMoviesForward();
    }
}
