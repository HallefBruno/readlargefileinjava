package mavenproject.lerarquivogrande;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.IntStream;

public class LerArquivoGrande {
  
  private final static String TARGET_FILE = "C:\\Users\\stefanini\\Documents\\NetBeansProjects\\LerArquivoGrande\\teste.txt";
  
  public static void main(String[] args) throws IOException {
    //prepFile();
    //option0();
    //usingBufferedReader();
    //usingLines();
  }

  public static void prepFile() throws IOException {
    BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(TARGET_FILE), StandardOpenOption.CREATE);
    IntStream.rangeClosed(1, 100000000).forEach(a -> write(bufferedWriter, a));
    bufferedWriter.flush();
  }

  public static void write(BufferedWriter bufferedWriter, int a) {
    try {
      bufferedWriter.write(a + "\n");
    } catch (IOException e) {
      System.out.println("Exception: " + e);
      throw new RuntimeException(e);
    }
  }
  
  public static void option0() throws IOException {
    Files.readAllLines(Path.of(TARGET_FILE)).forEach(System.out::println);
  }
  
  public static void usingBufferedReader() throws IOException {
    try (FileReader fileReader = new FileReader(new File(TARGET_FILE))) {
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String readLine;
      while ((readLine = bufferedReader.readLine()) != null) {
        System.out.println(readLine);
      }
    }
  }
  
  public static void usingBufferedReaderAndLambda() throws IOException {
    Files.newBufferedReader(Path.of(TARGET_FILE)).lines().forEach(System.out::println);
  }
  
  public static void usingLines() throws IOException {
    Files.lines(Path.of(TARGET_FILE)).forEach(System.out::println);
  }
  
}
