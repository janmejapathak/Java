import java.io.*;
import java.net.URL;

public class MultiThreadedDownloader {

    static class DownloadTask extends Thread {
        private String fileURL;
        private String fileName;

        public DownloadTask(String fileURL, String fileName) {
            this.fileURL = fileURL;
            this.fileName = fileName;
        }

        public void run() {
            try (BufferedInputStream in = new BufferedInputStream(new URL(fileURL).openStream());
                 FileOutputStream out = new FileOutputStream(fileName)) {

                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = in.read(buffer, 0, 1024)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }

                System.out.println(fileName + " downloaded");
            } catch (Exception e) {
                System.out.println("Error: " + fileName);
            }
        }
    }

    public static void main(String[] args) {
        new DownloadTask("https://example.com/file1.jpg", "file1.jpg").start();
        new DownloadTask("https://example.com/file2.jpg", "file2.jpg").start();
    }
}
