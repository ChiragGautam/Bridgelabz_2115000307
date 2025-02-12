
class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    Ticket head;
    Ticket tail;
    int totalTickets;

    public TicketReservationSystem() {
        head = tail = null;
        totalTickets = 0;
    }

    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);
        
        if (head == null) {
            head = tail = newTicket;
            tail.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
        
        totalTickets++;
    }

    public void removeTicket(int ticketID) {
        if (head == null) return;
        
        Ticket current = head;
        Ticket previous = null;
        
        do {
            if (current.ticketID == ticketID) {
                if (current == head) {
                    if (head == tail) {
                        head = tail = null;
                    } else {
                        head = head.next;
                        tail.next = head;
                    }
                } else if (current == tail) {
                    tail = previous;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                }
                
                totalTickets--;
                return;
            }
            
            previous = current;
            current = current.next;
        } while (current != head);
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        
        Ticket current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketID + 
                               ", Customer: " + current.customerName + 
                               ", Movie: " + current.movieName + 
                               ", Seat: " + current.seatNumber + 
                               ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        
        Ticket current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(keyword) || current.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket ID: " + current.ticketID + 
                                   ", Customer: " + current.customerName + 
                                   ", Movie: " + current.movieName + 
                                   ", Seat: " + current.seatNumber + 
                                   ", Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);
        
        if (!found) System.out.println("No ticket found for the given search.");
    }

    public void totalBookedTickets() {
        System.out.println("Total Booked Tickets: " + totalTickets);
    }
}

public class TicketReservationApp {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        
        system.addTicket(101, "Chirag", "Movie A", "A1", "10:00 AM");
        system.addTicket(102, "Rhea", "Movie B", "B2", "12:00 PM");
        system.addTicket(103, "Neeraj", "Movie A", "A2", "10:00 AM");
        
        System.out.println("All Booked Tickets:");
        system.displayTickets();
        
        System.out.println("Search by Customer Name (Ritu):");
        system.searchTicket("Rhea");
        
        System.out.println("Search by Movie Name (Movie A):");
        system.searchTicket("Movie A");
        
        System.out.println("Total Booked Tickets:");
        system.totalBookedTickets();
        
        System.out.println("Removing Ticket with ID 102:");
        system.removeTicket(102);
        
        System.out.println("All Booked Tickets After Removal:");
        system.displayTickets();
        
        System.out.println("Total Booked Tickets After Removal:");
        system.totalBookedTickets();
    }
}






