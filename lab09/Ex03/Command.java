package lab09.Ex03;

interface Command<T> {
    public boolean execute(T element);
    public boolean undo();
}
