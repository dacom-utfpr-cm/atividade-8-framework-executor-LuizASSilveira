package ex2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * aça um programa que calcule a soma dos elementos de uma matriz MxN. Divida o programa em tarefas que somam as linhas.
 * O programa deve possibilitar especificar o número de threads para resolver o problema.
 * @author Luiz A S Silveira
 */

public class Main {
    public static void main(String[] args) {
        int tamX = 100;
        int tamY = 100;
        int qtdTarefas = tamY;

        Random gerador = new Random();
        Integer [][]mat = new Integer[tamX][tamY];

        for(int i = 0; i < tamX; i ++) {
            for(int j = 0; j < tamY; j ++) {
                mat[i][j] = gerador.nextInt(100);
            }
        }

        ExecutorService threads = Executors.newFixedThreadPool(qtdTarefas);
        Future[] futures = new Future[qtdTarefas];

        for(int i = 0; i < tamY; i ++) {
            futures[i] = threads.submit(new SomaLinha(mat, i, tamY));
        }

        threads.shutdown();
        try {
            threads.awaitTermination(50000, TimeUnit.DAYS);
        } catch (InterruptedException ex) {
            System.out.println("Err: " + ex);
        }
        try {
            Integer soma = 0;
            for(Future f : futures) {
                soma += (Integer) f.get();
            }

            System.out.println("Somatorio: " + soma);
        } catch (Exception ex) {
            System.out.println("Error " + ex);
        }
    }

}
