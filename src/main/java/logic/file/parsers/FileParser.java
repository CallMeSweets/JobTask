package logic.file.parsers;


import logic.file.readers.Reader;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@AllArgsConstructor
public class FileParser{

    private Reader fileReader;

    private Map<String, Integer> mapWordToNumberOfOccurence;
    private Map<String, List<Integer>> mapWordToPositionOfOccurence;

    private final String REGEX_FOR_SEARCH = "[\\p{L}^0-9]+";

    public FileParser() {
    }

    public Boolean parseFile(String filePath) throws IOException {
        String input = fileReader.readFile(filePath);

        mapWordToNumberOfOccurence = new HashMap<>();
        mapWordToPositionOfOccurence = new HashMap<>();

        Pattern wordFindPattern = Pattern.compile(REGEX_FOR_SEARCH);
        Matcher wordMatcher = wordFindPattern.matcher(input);

        Integer position = 1;
        List<Integer> positionsOfOccurence;

        while (wordMatcher.find()) {
            String foundedWord = wordMatcher.group().toLowerCase();
            if(mapWordToNumberOfOccurence.containsKey(foundedWord)){
                mapWordToNumberOfOccurence.put(foundedWord, mapWordToNumberOfOccurence.get(foundedWord) + 1);
                positionsOfOccurence = mapWordToPositionOfOccurence.get(foundedWord);
            } else{
                mapWordToNumberOfOccurence.put(foundedWord, 1);
                positionsOfOccurence = new ArrayList<Integer>();
            }

            positionsOfOccurence.add(position);
            mapWordToPositionOfOccurence.put(foundedWord, positionsOfOccurence);
            position++;
        }

        return true;
    }

    public void printResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for(String key: mapWordToNumberOfOccurence.keySet()){
            stringBuilder.append(key);
            stringBuilder.append(" - ");
            stringBuilder.append(mapWordToNumberOfOccurence.get(key));
            stringBuilder.append(" - pozycje -> ");
            stringBuilder.append(mapWordToPositionOfOccurence.get(key));

            System.out.println(stringBuilder.toString());

            stringBuilder.setLength(0);
        }
    }

    public void setFileReaderContext(Reader fileReader) {
        this.fileReader = fileReader;
    }
}
