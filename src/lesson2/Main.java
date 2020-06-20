package lesson2;

public class Main {
    public static void main(String[] args) {

        String[][] array={
                {"1","1","1","2"},
                {"1","1","1","1"},
                {"1","1000","1","1"},
                {"1","1","1","1"}

        };



        try{
            rightArray(array);
        }catch (MyArraySizeException e){

            System.err.println(e.getMessage());
            e.printEqual();
        }catch (MyArrayDataException e){
            e.printStackTrace();
        }

    }

    public static void rightArray (String arr [][]){
        int sumOfAllElements;
        int sizeLine;
        int trueCount;
        int count;
        {
            sumOfAllElements=0;
            sizeLine=4;
            trueCount=16;
            count=0;
        }

        boolean linesEqualFour=true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                count++;
            }
        }
    for (int i = 0; i <arr.length; i++) {
        if(arr[i].length!=sizeLine){
            linesEqualFour=false;
            break;
        }
    }
    if(count!=trueCount||linesEqualFour==false){
        throw new MyArraySizeException("Некорректный массив. Число элементов "+count, count, linesEqualFour,sizeLine);
    }

        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try{
                    sumOfAllElements+=Integer.parseInt(arr[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("Невозможно конвертировать в числовой формат ячейку с номером "+i+" "+j, i,j);
                }

            }
        }

        System.out.println(sumOfAllElements);
}
}
