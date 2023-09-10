package dev.sethaker;

import static dev.sethaker.Main.*;

public class Multiplier implements Runnable {
    int rowIndexStart;
    int rowIndexStop;

    public Multiplier(int rowIndexStart, int rowIndexStop){
        this.rowIndexStart = rowIndexStart;
        this.rowIndexStop = rowIndexStop;
    }

    @Override
    public void run(){
        for(int i = rowIndexStart; i < rowIndexStop; i++ ){
            for(int j = 0; j < MATRIX_MAX; j++){
                for(int k = 0; k < MATRIX_MAX; k++){
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
    }
}
