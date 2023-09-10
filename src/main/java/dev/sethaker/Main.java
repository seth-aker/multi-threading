package dev.sethaker;

import org.springframework.util.StopWatch;

import java.util.Arrays;



public class Main {
    public static final int MATRIX_MAX = 2000;
    public static final int THREAD_MAX = 4;
    public static final int INDICES_PER_THREAD = MATRIX_MAX/THREAD_MAX;
    static int[][] matrix1 = new int[MATRIX_MAX][MATRIX_MAX];
    static int[][] matrix2 = new int[MATRIX_MAX][MATRIX_MAX];
    static int[][] matrixResult = new int[MATRIX_MAX][MATRIX_MAX];

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        Thread[] threads = new Thread[THREAD_MAX];
        MatrixBuilder matrixBuilder = new MatrixBuilder();
        matrix1 = matrixBuilder.buildBasicMatrix(MATRIX_MAX, MATRIX_MAX, 1);
        matrix2 = matrixBuilder.buildBasicMatrix(MATRIX_MAX, MATRIX_MAX, 1);

        Multiplier oneThread = new Multiplier(0, MATRIX_MAX);
        stopWatch.start();
        oneThread.run();
        stopWatch.stop();
        System.out.println("Time for one thread to multiply in milliseconds: " + stopWatch.getLastTaskTimeNanos()/1000000.00);
//      printMatrix(matrixResult);

        //Multithreading
        stopWatch.start();
        for(int i = 0; i < THREAD_MAX; i++){
            threads[i] = new Thread(new Multiplier(i * INDICES_PER_THREAD, ((i + 1) * INDICES_PER_THREAD)));
            threads[i].start();
        }

        for(int i = 0; i < THREAD_MAX; i++){
            try{
                threads[i].join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        stopWatch.stop();
        System.out.println("Time for " + THREAD_MAX + " threads to multiply in milliseconds: " + stopWatch.getLastTaskTimeNanos()/1000000.00);
//      printMatrix(matrixResult);
    }
    public static void printMatrix(long[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
