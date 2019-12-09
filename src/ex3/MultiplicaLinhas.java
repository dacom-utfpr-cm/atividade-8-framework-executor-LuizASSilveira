package ex3;

/**
 * @author Luiz A S Silveira
 */

import java.util.concurrent.Callable;

class MultiplicaLinhas implements Callable<Integer> {

    private final Integer[][] mat;
    private final Integer [][]mat2;
    private final int linha;
    private final int sizeX;
    private final int coluna;

    public MultiplicaLinhas(Integer [][]mat, Integer [][]mat2, int linha, int coluna, int sizeX) {
        this.mat = mat;
        this.mat2 = mat2;
        this.linha = linha;
        this.coluna = coluna;
        this.sizeX = sizeX;
    }
    @Override
    public Integer call() {

        int soma = 0;
        for(int i = 0; i < sizeX; i ++) {
            soma += mat[linha][i] * mat2[i][coluna];
        }
        return soma;
    }
}
