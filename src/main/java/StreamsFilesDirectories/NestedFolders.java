package StreamsFilesDirectories;

import java.io.File;
import java.util.ArrayDeque;

public class NestedFolders {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\Mimi\\Desktop\\IT\\2.JavaAdvanced\\1.JavaAdvanced\\4.StreamsFilesDirectories\\Lab\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        int count = 0;

        ArrayDeque<File> files = new ArrayDeque<>();
        files.offer(file);

        while(!files.isEmpty()){
            File current = files.poll();
            File[] nestedFiles = current.listFiles();

            for (File nF:nestedFiles) {
                if(nF.isDirectory()){
                    files.offer(nF);
                }
            }
            count++;
            System.out.println(current.getName());
        }
        System.out.println(count + " folders");
    }
}
