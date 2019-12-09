package ex5;

/**
 * @author Luiz A S Silveira
 */

import java.util.concurrent.Callable;

class Despertador implements Callable {
    @Override
    public Object call() throws Exception {
        for(int i =0 ; i<10; i++){
            System.out.println("Piiii\n");
            Thread.sleep(2000);
        }
        return null;
    }
}
