package softuni.exam.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtilImpl implements FileUtil {

    @Override
    public String readFile(Path path) throws IOException {

        return Files.readString(path);
    }
}