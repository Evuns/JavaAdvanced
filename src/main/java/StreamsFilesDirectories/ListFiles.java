package StreamsFilesDirectories;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\Mimi\\Desktop\\IT\\2.JavaAdvanced\\1.JavaAdvanced\\4.StreamsFilesDirectories\\Lab\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

      File[] files =  file.listFiles();
        for (File f:files) {
            if(f.isFile()){
                System.out.println(String.format("%s: [%d]",f.getName(), f.length()));
            }
        }
    }
}
