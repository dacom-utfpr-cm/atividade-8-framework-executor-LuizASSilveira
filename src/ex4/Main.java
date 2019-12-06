package ex4;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException {
        String patch = "C:\\Users\\luiz_\\OneDrive\\Imagens\\Documentos";
        File arquivos = new File(patch);
        int qtdArquivos = arquivos.list().length;

        ExecutorService threads = Executors.newFixedThreadPool(qtdArquivos);

        System.out.println("Arquivos na pasta " + arquivos.getCanonicalPath());
        for(String arquivo : arquivos.list()) {
            System.out.println(arquivo);
            threads.execute(new VerificaFile(patch + arquivo));
        }
        threads.shutdown();
        try {
            threads.awaitTermination(365, TimeUnit.DAYS);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }
}
