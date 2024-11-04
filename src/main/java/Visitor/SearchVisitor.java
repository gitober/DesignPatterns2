package Visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String searchCriteria;
    private List<File> matchingFiles;

    public SearchVisitor(String searchCriteria) {
        this.searchCriteria = searchCriteria;
        this.matchingFiles = new ArrayList<>();
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(searchCriteria)) {
            matchingFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        // Ei tarvita erityistoimintoja hakemistoille
    }

    public List<File> getMatchingFiles() {
        return matchingFiles;
    }
}