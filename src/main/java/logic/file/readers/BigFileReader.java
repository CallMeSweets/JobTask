package logic.file.readers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BigFileReader implements Reader {

    @Override
    public String readFile(String filePath) throws IOException {
        FileInputStream inputStream = null;
        Scanner sc = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                stringBuilder.append(sc.nextLine());
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
        return stringBuilder.toString();
    }
}
