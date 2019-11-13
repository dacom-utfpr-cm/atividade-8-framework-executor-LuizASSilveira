package ex2;

import java.util.concurrent.Callable;

class SomaLinha implements Callable<Integer> {

    private final Integer[][] mat;
    private final int linha;
    private final int size;

    public SomaLinha(Integer [][]mat, int linha, int size) {
        this.mat = mat;
        this.linha = linha;
        this.size = size;
    }

    @Override
    public Integer call() {
        Integer soma = 0;
        for(int i = 0; i < size; i ++) {
            soma += mat[linha][i];
        }
        return soma;
    }
}