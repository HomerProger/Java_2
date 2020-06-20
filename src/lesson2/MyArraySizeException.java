package lesson2;

public class MyArraySizeException extends RuntimeException{
private int numberElements;
private boolean linesEqual;
private int sizeLine;

    public int getNumberElements() {
        return numberElements;
    }
public void printEqual(){
        if(linesEqual==false){
            System.err.println("В одной или нескольких строках количество элементов не равно " +sizeLine);
        }
}
    public MyArraySizeException(String message, int numberElements, boolean linesEqual,int sizeLine) {
        super(message);
        this.numberElements = numberElements;
        this.linesEqual = linesEqual;
        this.sizeLine=sizeLine;
    }
}
