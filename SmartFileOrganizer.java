import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class SmartFileOrganizer {

    static Map<String, List<String>> categories = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        categories.put("Images",
                Arrays.asList(".jpg", ".jpeg", ".png", ".gif", ".webp", ".svg"));

        categories.put("Videos",
                Arrays.asList(".mp4", ".mkv", ".avi", ".mov", ".webm"));

        categories.put("Audio",
                Arrays.asList(".mp3", ".wav", ".aac", ".flac", ".ogg"));

        categories.put("Documents",
                Arrays.asList(".pdf", ".doc", ".docx", ".txt",
                        ".ppt", ".pptx", ".xls", ".xlsx"));

        categories.put("Code",
                Arrays.asList(".py", ".java", ".c", ".cpp",
                        ".js", ".html", ".css", ".sql"));

        categories.put("Archives",
                Arrays.asList(".zip", ".rar", ".7z", ".tar", ".gz"));

        System.out.print("Enter folder path: ");
        String folderPath = sc.nextLine();

        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("❌ Invalid folder!");
            return;
        }

        int moved = 0;

        File[] files = folder.listFiles();

        if (files == null) {
            System.out.println("❌ Unable to read folder!");
            return;
        }

        for (File file : files) {

            if (!file.isFile())
                continue;

            String fileName = file.getName();
            String extension = getExtension(fileName);

            String category = findCategory(extension);

            File categoryFolder = new File(folder, category);

            if (!categoryFolder.exists()) {
                categoryFolder.mkdir();
            }

            File destination = new File(categoryFolder, fileName);

            int counter = 1;

            while (destination.exists()) {

                String newName = getNameWithoutExtension(fileName)
                        + "_" + counter
                        + extension;

                destination = new File(categoryFolder, newName);
                counter++;
            }

            try {

                Files.move(
                        file.toPath(),
                        destination.toPath(),
                        StandardCopyOption.REPLACE_EXISTING
                );

                System.out.println(
                        "Moved: " + fileName + " → " + category + "/"
                );

                moved++;

            } catch (Exception e) {
                System.out.println(
                        "❌ Failed: " + fileName
                );
            }
        }

        System.out.println("\n✅ Organization completed!");
        System.out.println("📦 Files organized: " + moved);

        sc.close();
    }

    static String findCategory(String extension) {

        for (Map.Entry<String, List<String>> entry : categories.entrySet()) {

            if (entry.getValue().contains(extension)) {
                return entry.getKey();
            }
        }

        return "Others";
    }

    static String getExtension(String fileName) {

        int index = fileName.lastIndexOf('.');

        if (index == -1)
            return "";

        return fileName.substring(index).toLowerCase();
    }

    static String getNameWithoutExtension(String fileName) {

        int index = fileName.lastIndexOf('.');

        if (index == -1)
            return fileName;

        return fileName.substring(0, index);
    }
}
