import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "data.csv"; // Replace with your CSV file path
        String line;
        String delimiter = ","; // Set your delimiter

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, delimiter);
                List<String> columns = new ArrayList<>();

                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();
                    columns.add(token);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
