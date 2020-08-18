package logic;

import logic.file.readers.BigFileReader;
import logic.file.parsers.FileParser;
import logic.file.readers.SmallFileReader;

import java.io.IOException;

public class StartPoint {

    public static void main(String[] args) throws IOException {
        FileParser fileParser = new FileParser();
        fileParser.setFileReaderContext(new BigFileReader());
        fileParser.parseFile("src/main/resources/zadanie.txt");
        fileParser.printResult();

        fileParser.setFileReaderContext(new SmallFileReader());
        fileParser.parseFile("src/main/resources/zadanie.txt");
//        fileParser.printResult();
    }

    // Krótki komentarz
    // Jesli chodzi o ten contex ustawianego Reader to tutaj go ustawiam na sztywno, ale mozna by utworzyc jakis context, który odpowiednio zarzadza
    // i mowi kontenerowi jakiego beana (context) ma wstrzyknac
    // sciezke pewnie bym w dalszym kroku wypchnal do propertisow
}
