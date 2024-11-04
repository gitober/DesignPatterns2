package Visitor;

public class Main {
    public static void main(String[] args) {
        // Luodaan hakemisto-objekti nimeltä "hakemisto"
        Directory root = new Directory("hakemisto");

        // Luodaan tiedosto-objekteja, joissa on nimi ja koko megatavuina
        File file1 = new File("tiedosto1.txt", 15);
        File file2 = new File("tiedosto2.java", 35);

        // Luodaan alihakemisto-objekti nimeltä "alihakemisto"
        Directory subDir = new Directory("alihakemisto");

        // Luodaan tiedosto alihakemistoon
        File file3 = new File("tiedosto3.doc", 10);

        // Lisätään tiedostot ja alihakemisto päähakemistoon
        root.addElement(file1);
        root.addElement(file2);
        subDir.addElement(file3); // Lisätään tiedosto alihakemistoon
        root.addElement(subDir);  // Lisätään alihakemisto päähakemistoon

        // Luodaan vierailija, joka laskee tiedostojen kokonaiskoon
        SizeCalculatorVisitor sizeCalculator = new SizeCalculatorVisitor();

        // Hyväksytään vierailija root-hakemistossa, jolloin lasketaan koko
        root.accept(sizeCalculator);

        // Tulostetaan tiedostojen kokonaiskoko
        System.out.println("Tiedostojen koko yhteensä: " + sizeCalculator.getTotalSize() + " MB");

        // Luodaan vierailija, joka etsii tietyn tiedostopäätteen mukaisia tiedostoja
        SearchVisitor searchVisitor = new SearchVisitor(".java");

        // Hyväksytään vierailija root-hakemistossa, jolloin etsitään tiedostoja
        root.accept(searchVisitor);

        // Tulostetaan kaikki löydetyt tiedostot
        System.out.println("Hakuehdot täyttävät tiedostot: ");
        for (File file : searchVisitor.getMatchingFiles()) {
            System.out.println(file.getName());
        }
    }
}
