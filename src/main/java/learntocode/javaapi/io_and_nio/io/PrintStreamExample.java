package learntocode.javaapi.io_and_nio.io;
import learntocode.javaapi.io_and_nio.FilesCreator;

import java.io.*;

/**
 * PrintStream class is like System.out but can output into files!
 */
public class PrintStreamExample {
    public static void main(String[] args) throws IOException {
        File f = FilesCreator.createFilesIO()[0];
        try (PrintStream prs = new PrintStream(f)) {
            prs.printf("Character: %c \nInteger: %1$d", 107);
        }

        try (InputStream input = new FileInputStream(f)) {
            int b;
            while ( (b = input.read()) != -1) {
                System.out.print((char)b + " ");
            }
        }
    }
}
