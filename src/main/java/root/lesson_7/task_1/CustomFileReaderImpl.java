package root.lesson_7.task_1;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomFileReaderImpl implements CustomFileReader {

    @Override
    public List<String> readAllLines(String path) {
        Set<String> setWords = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            while (reader.ready()) {
                String[] currentLine = reader.readLine().split("\\W");
                for (int i = 0; i < currentLine.length; i++) {

                    Pattern pattern = Pattern.compile("[a-zA-Z]");
                    Matcher matcher = pattern.matcher(currentLine[i]);

                    if (matcher.find())
                        setWords.add(currentLine[i].toLowerCase());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(setWords);
    }

    @Override
    public List<String> sort(List<String> list) {
        Collections.sort(list);
        return list;
    }

    @Override
    public void writeListWords(List<String> list, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (String s : list) {
                writer.write(s + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
