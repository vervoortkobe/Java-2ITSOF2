package labo4.labo4_1;

public class Chessboard {
    int size;

    char[][] board;

    public Chessboard(int size) {
        this.size = size;
        generateChessboard();
    }

    private void generateChessboard() {
        board = new char[size][size];
        boolean useFull = false;
        for(int i =0; i< size; i++) {
            for(int c =0; c< size; c++) {
                if(useFull) {
                    board[i][c] = '\u25A0';
                }else {

                    board[i][c] = '\u25A1';
                }
                useFull= !useFull;
            }
            useFull= !useFull;
        }
    }

    public void print() {
        for(int i =0 ; i< size ; i++){
            for(int j =0 ; j< size ; j++){
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }



}
