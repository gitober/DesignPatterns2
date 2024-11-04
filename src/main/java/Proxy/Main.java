package Proxy;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Pekka");
        User user2 = new User("Kalevi");
        User user3 = new User("Jaska");

        Library library = new Library();
        library.createProtectedDocument("doc1", "Secret Content for doc1");
        library.createProtectedDocument("doc2", "Secret Content for doc2");
        library.createUnprotectedDocument("doc3", "Public Content for doc3");

        try {
            System.out.println("User Pekka accessing doc1: " + library.getDocument("doc1").getContent(user1));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("User Kalevi accessing doc1: " + library.getDocument("doc1").getContent(user2));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("User Jaska accessing doc3: " + library.getDocument("doc3").getContent(user3));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}