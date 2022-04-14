import java.io.*;
import java.util.*;


public class WordCount {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\divanov\\Downloads\\1. Sum Lines_Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\Exercises Resources\\inputOne.txt");

        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\divanov\\Downloads\\1. Sum Lines_Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\Exercises Resources\\mergedFile.txt");
        OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter writer = new BufferedWriter(streamWriter);

        copyLines(fileInputStream, writer);
        fileInputStream = new FileInputStream("C:\\Users\\divanov\\Downloads\\1. Sum Lines_Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\Exercises Resources\\inputTwo.txt");
        copyLines(fileInputStream, writer);
    }

    private static void copyLines(FileInputStream fileInputStream, BufferedWriter writer) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line = reader.readLine();
        while (line != null){
            writer.write(line + System.lineSeparator());
            line = reader.readLine();
        }
        writer.flush();
    }
}