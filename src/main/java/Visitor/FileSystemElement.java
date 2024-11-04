package Visitor;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}