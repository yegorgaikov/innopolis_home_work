package root.lesson_7.task_2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FilesGeneratorImpl implements FilesGenerator {

    /**
     * Создаются n текстовых файлов размером size в каталоге path. Делаем это методом getFiles, который помимо
     * указанных параметров принимает также массив слов words и вероятность вхождения слова из массива в
     * предложение probability.
     */
    @Override
    public void getFiles(String path, int n, int size, List<String> words, int probability) {
        StringBuilder sbText = new StringBuilder();
        for (int i = 0; i < n; i++) {
            ParagraphGenerator paragraphGenerator = new ParagraphGeneratorImpl(
                    new SentenceGeneratorImpl(
                            new WordGeneratorImpl(
                                    words, probability)));

            for (int j = 1; j < size; j++) {
                sbText.append(paragraphGenerator);
            }

            String text = new String(sbText);

            try (FileOutputStream fos = new FileOutputStream(path + "\\file" + (i + 1) + ".txt")) {
                byte[] buffer = text.getBytes();
                fos.write(buffer);
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
