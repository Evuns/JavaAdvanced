package StreamsFilesDirectories;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String inputPath = userDir + "/res/input.txt";
        String outputPath = userDir + "/res/extractOutput.txt";


        try(Scanner scanner = new Scanner(new FileReader(inputPath));
        PrintWriter write = new PrintWriter(outputPath)){
            while(scanner.hasNext()) {
                scanner.next();
                if (scanner.hasNextInt()){
                   write.println(scanner.nextInt());
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
