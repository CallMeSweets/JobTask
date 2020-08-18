import configuration.TestConfig;
import logic.file.parsers.FileParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class FileParserTests {

    private final String filePath = "src/test/resources/testFile.txt";

    @Qualifier("fileParserBigFileReader")
    @Autowired
    FileParser fileParserBigFileReader;

    @Qualifier("fileParserSmallFileReader")
    @Autowired
    FileParser fileParserSmallFileReader;

    @Test
    public void parseFileBigReaderTest() throws IOException {

        assertNull(fileParserBigFileReader.getMapWordToPositionOfOccurence());

        assertTrue(fileParserBigFileReader.parseFile(filePath));

        assertNotNull(fileParserBigFileReader.getMapWordToPositionOfOccurence());

        assertTrue(fileParserBigFileReader.getMapWordToPositionOfOccurence().size() == 5);

        assertTrue(fileParserBigFileReader.getMapWordToPositionOfOccurence().get("witam").get(0) == 1
                && fileParserBigFileReader.getMapWordToPositionOfOccurence().get("witam").get(1) == 2);

    }

    @Test
    public void parseFileSmallReaderTest() throws IOException {

        assertNull(fileParserSmallFileReader.getMapWordToPositionOfOccurence());

        assertTrue(fileParserSmallFileReader.parseFile(filePath));

        assertNotNull(fileParserSmallFileReader.getMapWordToPositionOfOccurence());

        assertTrue(fileParserSmallFileReader.getMapWordToPositionOfOccurence().size() == 5);

        assertTrue(fileParserSmallFileReader.getMapWordToPositionOfOccurence().get("witam").get(0) == 1
                && fileParserSmallFileReader.getMapWordToPositionOfOccurence().get("witam").get(1) == 2);

    }

}
