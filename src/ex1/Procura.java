package ex1;
/*
Faça um programa que localize o maior valor em um vetor. Divida o programa em tarefas que localizam o maior valor em um segmento do
vetor. O programa deve possibilitar especificar o número de tarefas e o número de threads para resolver o problema.
@author: Luiz A S Silveira
*/

import java.util.concurrent.Callable;

class Procura implements Callable<Integer> {

    private final int posInicial;
    private final int posFinal;
    private final Integer[] vet;

    public Procura(int posInicial, int posFinal, Integer []vet) {
        this.posInicial = posInicial;
        this.posFinal = posFinal;
        this.vet = vet;
    }

    @Override
    public Integer call() {
        Integer valMaior = 0;
        for(int i = posInicial; i < posFinal; i ++) {
            if(vet[i] > valMaior) {
                valMaior = vet[i];
            }
        }
        return valMaior;
    }
}
