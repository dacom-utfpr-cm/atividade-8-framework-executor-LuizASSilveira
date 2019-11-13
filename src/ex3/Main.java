package ex3;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Faça um programa concorrente para multiplicar duas matrizes
 * @author luiz A S Silveira
 */
public class Main {
    public static void main(String[] args){
        int tamX = 100;
        int tamY = 100;

        Random gerador = new Random();
        Integer [][]mat = new Integer[tamX][tamY];
        Integer [][]mat2 = new Integer[tamX][tamY];

        for(int i = 0; i < tamX; i ++) {
            for(int j = 0; j < tamY; j ++) {
                mat[i][i] = gerador.nextInt(100) ;
                mat2[i][i] = gerador.nextInt(100);
            }
        }

        ExecutorService threads = Executors.newFixedThreadPool(tamX * tamY);
        Future[][] futures = new Future[tamX][tamY];

        for(int i = 0; i < tamX; i ++) {
            for(int j = 0; j < tamY; j ++) {
                futures[i][j] = threads.submit(new MultiplicaLinhas(mat, mat2, i, j, tamX));

            }
        }

        try {
            threads.awaitTermination(50000, TimeUnit.DAYS);
        } catch (InterruptedException ex) {
            System.out.println("Error: " + ex);
        }
    }

}
