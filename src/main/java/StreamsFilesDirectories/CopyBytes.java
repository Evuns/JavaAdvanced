package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String inputPath = userDir + "/res/input.txt";
        String outputPath = userDir + "/res/copyOutput";

        try (FileInputStream fis = new FileInputStream(inputPath);
        FileOutputStream fos = new FileOutputStream(outputPath)){

            int oneByte = fis.read();

            while(oneByte >= 0 ){
                if(oneByte == 32 || oneByte == 10){
                    fos.write(oneByte);
                } else {
                    String byteAsText = String.valueOf(oneByte);
                    for (int i = 0; i < byteAsText.length(); i++) {
                        int symbol = byteAsText.charAt(i);
                        fos.write(symbol);
                    }
                }
                oneByte = fis.read();
            }

        } catch(IOException e){
            e.printStackTrace();

        }

    }

}
