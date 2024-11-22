package Prototype;

public class Main {
    public static void main(String[] args) {
        // Create Finnish books
        Book book1 = new Book("Aleksis Kivi", "Seitsemän veljestä", "Klassikko", 1870);
        Book book2 = new Book("Mika Waltari", "Sinuhe egyptiläinen", "Historiallinen romaani", 1945);

        // Create a recommendation
        Recommendation finnishClassics = new Recommendation("Suomalaiset klassikot");
        finnishClassics.addBook(book1);
        finnishClassics.addBook(book2);

        // Create a deep copy using the copy constructor
        Recommendation clonedRecommendation = new Recommendation(finnishClassics);
        clonedRecommendation.setTargetAudience("Kaikenikäisille lukijoille");

        System.out.println("Original Recommendation: " + finnishClassics);
        System.out.println("Cloned Recommendation: " + clonedRecommendation);
    }
}
