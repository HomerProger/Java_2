package lesson2;

public class MyArrayDataException extends NumberFormatException{
private int cellI;
private int cellJ;



    public MyArrayDataException(String s, int cellI, int cellJ) {
        super(s);
        this.cellI = cellI;
        this.cellJ = cellJ;
    }
}
