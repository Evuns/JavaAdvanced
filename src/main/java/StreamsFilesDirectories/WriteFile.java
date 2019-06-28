package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String path = userDir + "/res/input.txt";
        String outPath = userDir + "/res/output.txt";

        try(FileInputStream fis = new FileInputStream(path);
            FileOutputStream fos = new FileOutputStream(outPath)){

            int oneByte = fis.read();
            while(oneByte >= 0){
                if(oneByte != '.' &&
                        oneByte != ',' &&
                        oneByte != '?' &&
                        oneByte != '!'){
                    fos.write(oneByte);
                }
                oneByte = fis.read();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
