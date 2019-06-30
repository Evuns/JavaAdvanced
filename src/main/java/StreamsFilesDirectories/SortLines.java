package StreamsFilesDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\Mimi\\Desktop\\IT\\Soft_Uni\\src\\1.JavaAdvanced\\res\\input.txt");
        Path pathOut = Paths.get("C:\\Users\\Mimi\\Desktop\\IT\\Soft_Uni\\src\\1.JavaAdvanced\\res\\sortedOutput.txt");

        Files.newBufferedReader(path);
        List<String> lines = Files.readAllLines(path);
        Collections.sort(lines);
        Files.write(pathOut,lines);
    }
}
