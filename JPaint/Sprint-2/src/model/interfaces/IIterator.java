package model.interfaces;

public interface IIterator<I> {
    boolean hasNext();
    IShape next();
}
