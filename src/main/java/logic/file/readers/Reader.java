package logic.file.readers;

import java.io.IOException;

public interface Reader {

    String readFile(String filePath) throws IOException;

}
