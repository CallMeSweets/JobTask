package logic.file.parsers;


import logic.file.readers.Reader;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@AllArgsConstructor
public class FileParser{

    private Reader fileReader;

    private Map<String, List<Integer>> mapWordToPositionOfOccurence;

    private final String REGEX_FOR_SEARCH = "[\\p{L}^0-9]+";

    public FileParser() {
    }

    public Boolean parseFile(String filePath) throws IOException {
        String input = fileReader.readFile(filePath);

        mapWordToPositionOfOccurence = new TreeMap<>();

        Pattern wordFindPattern = Pattern.compile(REGEX_FOR_SEARCH);
        Matcher wordMatcher = wordFindPattern.matcher(input);

        Integer position = 1;
        List<Integer> positionsOfOccurence;

        while (wordMatcher.find()) {
            String foundedWord = wordMatcher.group().toLowerCase();
            if(mapWordToPositionOfOccurence.containsKey(foundedWord)){
                positionsOfOccurence = mapWordToPositionOfOccurence.get(foundedWord);
            } else{
                positionsOfOccurence = new ArrayList<>();
            }

            positionsOfOccurence.add(position);
            mapWordToPositionOfOccurence.put(foundedWord, positionsOfOccurence);
            position++;
        }

        return true;
    }

    public void printResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for(String key: mapWordToPositionOfOccurence.keySet()){
            stringBuilder.append(key);
            stringBuilder.append(" - ");
            stringBuilder.append(mapWordToPositionOfOccurence.get(key).size());
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
