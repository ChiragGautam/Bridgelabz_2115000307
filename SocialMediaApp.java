
import java.util.ArrayList;
class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    User head;

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    public void addFriend(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            if (!user1.friendIds.contains(userId2)) {
                user1.friendIds.add(userId2);
            }
            if (!user2.friendIds.contains(userId1)) {
                user2.friendIds.add(userId1);
            }
        }
    }

    public void removeFriend(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            user1.friendIds.remove(Integer.valueOf(userId2));
            user2.friendIds.remove(Integer.valueOf(userId1));
        }
    }

    public void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            System.out.print(user.name + "'s Friends: ");
            for (int friendId : user.friendIds) {
                User friend = findUserById(friendId);
                System.out.print(friend.name + " ");
            }
            System.out.println();
        }
    }

    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            System.out.print("Mutual Friends of " + user1.name + " and " + user2.name + ": ");
            for (int friendId1 : user1.friendIds) {
                if (user2.friendIds.contains(friendId1)) {
                    User mutualFriend = findUserById(friendId1);
                    System.out.print(mutualFriend.name + " ");
                }
            }
            System.out.println();
        }
    }

    public void searchUser(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("User Found: ID = " + temp.userId + ", Name = " + temp.name + ", Age = " + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User Not Found");
    }

    public void searchUser(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            System.out.println("User Found: ID = " + user.userId + ", Name = " + user.name + ", Age = " + user.age);
        } else {
            System.out.println("User Not Found");
        }
    }

    public void countFriends(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            System.out.println(user.name + " has " + user.friendIds.size() + " friend(s).");
        }
    }

    private User findUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void displayAllUsers() {
        User temp = head;
        while (temp != null) {
            System.out.print("ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age + " | Friends: ");
            for (int friendId : temp.friendIds) {
                User friend = findUserById(friendId);
                System.out.print(friend.name + " ");
            }
            System.out.println();
            temp = temp.next;
        }
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 22);
        sm.addUser(3, "Charlie", 24);
        sm.addUser(4, "Diana", 23);

        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.addFriend(2, 4);

        System.out.println("All Users and their Friends:");
        sm.displayAllUsers();

        System.out.println("Display Friends:");
        sm.displayFriends(1);

        System.out.println("Mutual Friends:");
        sm.findMutualFriends(1, 2);

        System.out.println("Search User by Name:");
        sm.searchUser("Alice");

        System.out.println("Search User by ID:");
        sm.searchUser(3);

        System.out.println("Count Friends:");
        sm.countFriends(1);

        System.out.println("Remove Friend:");
        sm.removeFriend(1, 2);
        sm.displayFriends(1);
        sm.displayFriends(2);
    }
}

