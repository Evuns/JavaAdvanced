package StreamsFilesDirectories;

import java.io.*;

public class EveryThirdLine {
    public static void main(String[] args) throws IOException {

        String userDir = System.getProperty("user.dir");
        String pathIn = userDir + "/res/input.txt";
        String pathOut = userDir + "/res/output5.txt";

        BufferedReader bf = new BufferedReader(new FileReader(pathIn));
        BufferedWriter wr = new BufferedWriter(new FileWriter(pathOut));

        String line;
        int lineNum = 1;
        while ((line = bf.readLine()) != null) {
            if (lineNum % 3 == 0) {
                wr.write(line);
                wr.append(System.lineSeparator());
            }
            wr.flush();
            lineNum++;
        }

    }
}
