package ex5;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Faça um programa que possibilite agendar uma tarefa para ser executada em um horário especı́fico.
 * @author luiz_ A S Silveira
 */

public class Main {
    public static void main(String[] args) {
        int qtdHorarios = 10;
        ScheduledExecutorService threads = Executors.newScheduledThreadPool(qtdHorarios);
        Random num = new Random();
        try {
            for(int i = 0; i < qtdHorarios; i ++) {
                Despertador d = new Despertador();
                threads.schedule(d, 5, TimeUnit.SECONDS);
                Thread.sleep(num.nextInt(2000));
            }
        } catch (Exception ex) {
            System.out.println("Erroor: " + ex);
        }
        threads.shutdown();
    }

}
