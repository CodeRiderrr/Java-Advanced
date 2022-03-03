//import java.util.Scanner;
//
//public class ExamType2 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        char[][] matrix = new char[8][8];
//        int rowWhite = 0;
//        int colWhite = 0;                                      //DAVA 50/100
//        int rowBlack = 0;
//        int colBlack = 0;
//        boolean blackQueen = false;
//        boolean whiteQueen = false;
//        boolean whiteWin = false;
//        boolean blackWin = false;
//
//
//        for (int i = 0; i < 8; i++) {
//            char[]inputRow = scanner.nextLine().toCharArray();    //fill matrix
//            matrix[i] = inputRow;
//
//        }
//
//        for (int row = 0; row < 8; row++) {
//            for (int col = 0; col < 8; col++) {
//                if (matrix[row][col]=='w'){
//                    rowWhite = row;
//                    colWhite = col;
//                    break;                               //find white start
//                }
//            }
//        }
//        for (int row = 0; row < 8; row++) {
//            for (int col = 0; col < 8; col++) {
//                if (matrix[row][col]=='b'){
//                    rowBlack = row;
//                    colBlack = col;                           //find black start
//                    break;
//                }
//            }
//        }
//
//       while (true){
//
//                if (rowWhite - 1 >= 0 && rowWhite + 1 <= 7 ) {
//
//                    if (rowBlack == rowWhite - 1 && (colBlack == colWhite - 1 || colBlack == colWhite + 1)) {
//                        //wzima
//                        whiteWin = true;
//                        colWhite = colBlack;
//                        rowWhite = rowBlack;
//                        matrix[rowWhite][colWhite] = 'w';
//                        break;
//                    }
//                    matrix[rowWhite][colWhite] = '-';
//                    rowWhite--;
//                    matrix[rowWhite][colWhite] = 'w';
//
//                    if (rowWhite == 0) {
//                        whiteQueen = true;
//                        matrix[rowWhite][colWhite] = 'w';                 //ako e na kraq
//                        break;
//                    }
//                }
////            if (matrix[rowBlack][colBlack] == matrix[rowWhite + 1][colWhite + 1]){    //wzima
////                whiteWin = true;
////                matrix[rowWhite + 1][colWhite + 1] = 'w';
////                break;
////            }
//
//                if (rowWhite - 1 >= 0 && colBlack - 1 >= 0 && colBlack + 1 <= 7) {
//
//                    if (rowWhite == rowBlack + 1 && (colWhite == colBlack - 1 || colWhite == colBlack + 1)) {    //wzima
//                        blackWin = true;
//                        colBlack = colWhite;
//                        rowBlack = rowWhite;
//                        matrix[rowBlack][colBlack] = 'b';
//                        break;
//                    }
//                    matrix[rowBlack][colBlack] = '-';
//                    rowBlack++;
//                    matrix[rowBlack][colBlack] = 'b';
//
//                    if (rowBlack == 7) {
//                        blackQueen = true;
//                        matrix[rowBlack][colBlack] = 'b';
//                        break;
//                    }
//                }
//
////            if (matrix[rowWhite][colWhite] == matrix[rowBlack + 1][colBlack + 1]){
////                blackWin = true;
////                matrix[rowBlack + 1][colBlack + 1] = 'b';
////                break;
////            }
//
//        }//end while
//
//        if (whiteWin){
//            for (int row = 0; row < 7; row++) {
//                for (int col = 0; col < 7; col++) {
//                    if (matrix[row][col]=='w') {
//                        String position = setPosition(row,col);
//                        System.out.printf("Game over! White capture on %s.",position);
//                        return;
//                    }
//                }
//            }
//
//        }
//        if (blackWin){
//            for (int row = 0; row < 7; row++) {
//                for (int col = 0; col < 7; col++) {
//                    if (matrix[row][col]=='b') {
//                        String position = setPosition(row,col);
//                        System.out.printf("Game over! Black capture on %s.",position);
//                        return;
//                    }
//                }
//            }
//
//        }
//        if (whiteQueen){
//            for (int row = 0; row < 7; row++) {
//                for (int col = 0; col < 7; col++) {
//                    if (matrix[row][col]=='w') {
//                        String position = setPosition(row,col);
//                        System.out.printf("Game over! White pawn is promoted to a queen at %s.",position);
//                    }
//                }
//            }
//
//        }
//        if (blackQueen){
//            for (int row = 0; row < 7; row++) {
//                for (int col = 0; col < 7; col++) {
//                    if (matrix[row][col]=='b') {
//                        String position = setPosition(row, col);
//                        System.out.printf("Game over! Black pawn is promoted to a queen at %s.", position);
//                    }
//                }
//            }
//        }
//    }
////    private static boolean IsInMatrix(int row,int col)
////    {
////        return row >= 0 && row <= 7 && col >= 0 && col <= 7;
////    }
//
//    private static String setPosition(int row, int col)
//    {
//
//        var sb = new StringBuilder();
//
//        for (int i = 8; i >= 0; i--)
//        {
//            if (col == i)
//            {
//                sb.append((char)(i + 97));
//            }
//        }
//
//        int counter = 8;
//        for (int i = 0; i < 8; i++)
//        {
//            if (row == i)
//            {
//                sb.append(counter);
//            }
//            counter--;
//        }
//        return sb.toString();
//    }
//}
