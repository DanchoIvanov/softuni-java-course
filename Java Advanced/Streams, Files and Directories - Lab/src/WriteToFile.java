import java.io.*;

public class WriteToFile {
    public static void main(String[] args) throws IOException{

        String input = "C:\\Users\\divanov\\Downloads\\1. Read File_Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String output = "C:\\Users\\divanov\\Downloads\\1. Read File_Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";


        try (FileInputStream fileStream = new FileInputStream(input)) {
            InputStreamReader streamReader = new InputStreamReader(fileStream);
            BufferedReader reader = new BufferedReader(streamReader);

            FileOutputStream outputStream = new FileOutputStream(output);
            OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter writer = new BufferedWriter(streamWriter);

            String line = reader.readLine();
            int count =  1;
            while (line != null){
                if (count % 3 ==0){
                    writer.write(line + System.lineSeparator());
                }
                count++;
                line = reader.readLine();
        }
            writer.flush();
    } catch (IOException e){
            e.printStackTrace();
        }
    }
}
