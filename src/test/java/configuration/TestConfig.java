package configuration;

import logic.file.parsers.FileParser;
import logic.file.readers.SmallFileReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean(name = "fileParserSmallFileReader")
    public FileParser getFileParserSmallFileReader(){
        FileParser fileParser = new FileParser();
        fileParser.setFileReaderContext(new SmallFileReader());
        return  fileParser;
    }

    @Bean(name = "fileParserBigFileReader")
    public FileParser getFileParserBigFileReader(){
        FileParser fileParser = new FileParser();
        fileParser.setFileReaderContext(new SmallFileReader());
        return  fileParser;
    }

}
