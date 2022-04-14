import java.io.File;
import java.nio.file.Files;

public class ListFiles {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\divanov\\Downloads\\1. Read File_Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        File[] files = file.listFiles();
        for (File currentFile : files){
            if (!currentFile.isDirectory()){
                System.out.printf("%s: [%d]%n",currentFile.getName(), currentFile.length());
            }
        }
    }
}
