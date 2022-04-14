import java.io.File;


public class GetFolderSize {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\divanov\\Downloads\\1. Sum Lines_Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\Exercises Resources");
        File[] files = file.listFiles();
        long size = 0;
        for (File currentFile : files){
            size += currentFile.length();
        }
        System.out.println(size);


    }
}
