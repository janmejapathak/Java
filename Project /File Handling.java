import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("data.txt");
            fw.write("Hello GitHub!");
            fw.close();

            FileReader fr = new FileReader("data.txt");
            int i;
            while ((i = fr.read()) != -1)
                System.out.print((char) i);

            fr.close();
        } catch (IOException e) {
            System.out.println("Error occurred");
        }
    }
}
