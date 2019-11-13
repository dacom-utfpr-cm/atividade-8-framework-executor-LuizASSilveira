package ex1;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int tamVet = 10000;
        int qtdTarefas = 90;
        int fator = tamVet/qtdTarefas;

        Random gerador = new Random();
        Integer []vet = new Integer[tamVet];

        for(int i = 0; i < tamVet; i ++) {
            vet[i] = gerador.nextInt(1000000);
        }

        ExecutorService threads = Executors.newFixedThreadPool(qtdTarefas);
        Future[] futures = new Future[qtdTarefas];

        for(int i = 0; i < qtdTarefas; i ++) {
            futures[i] = threads.submit(new Procura(i*fator, (i+1)*fator, vet));
        }

        threads.shutdown();
        try {
            threads.awaitTermination(50000, TimeUnit.DAYS);
        } catch (InterruptedException ex) {
            System.out.println("Erro: " + ex);
        }

        try {
            Integer maior = 0;
            for(Future i : futures) {
                if((Integer) i.get() > maior) {
                    maior = (Integer) i.get();
                }
            }
            System.out.println("Maior valor: " + maior);
        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
        }
    }

}
