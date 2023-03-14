package squares;

public abstract class Square implements Cloneable{

    public abstract String getIndex();
    public abstract boolean isEmpty();
    public abstract void makeEmpty();
    public abstract void makeNotEmpty();

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
