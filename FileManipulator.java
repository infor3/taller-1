package logica;

import java.io.*;
import java.nio.file.Files;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorge on 27/02/2016.
 */
public class FileManipulator {
    public static List<String> fileReader(File file){
        List<String> result = new ArrayList<>();
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file.getPath()),"unicode");
             BufferedReader br = new BufferedReader(isr)) {
            String line;

            while ((line = br.readLine()) != null)
                result.add(line);

        } catch (IOException x) {
            System.err.println(x);
        }
        return result;
    }

    public static void fileWriter(File file, String data){
        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(file.toPath(), CREATE, APPEND))) {
            out.write(data.getBytes(), 0, data.length());
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}
