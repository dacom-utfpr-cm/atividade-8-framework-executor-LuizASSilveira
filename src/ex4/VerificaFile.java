package ex4;

import java.io.File;
import java.util.Date;

public class VerificaFile implements Runnable{

    private long timeStamp;
    private File file;

    public VerificaFile(String fileName) {
        this.file = new File(fileName);
        this.timeStamp = file.lastModified();
    }

    public final void run() {
        try {
            while (true) {
                long timeStamp = file.lastModified();
                if (this.timeStamp != timeStamp) {
                    this.timeStamp = timeStamp;
                    change(file);
                }
                Thread.sleep(1000);
            }
        } catch (Exception ex) {
            System.out.println("ErrorVerifica: " + ex);
        }
    }

    void change(File file) {
        System.out.println("Arquivo " + file.getAbsolutePath() + " alterado as " + new Date(file.lastModified()));
    }
}
