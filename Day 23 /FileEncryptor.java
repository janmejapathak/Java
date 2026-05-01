import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.*;

public class FileEncryptor {

    private static final String KEY = "1234567890123456";

    public static void encrypt(String inputFile, String outputFile) throws Exception {
        byte[] keyBytes = KEY.getBytes();
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] inputData = Files.readAllBytes(Paths.get(inputFile));
        byte[] encryptedData = cipher.doFinal(inputData);

        Files.write(Paths.get(outputFile), encryptedData);
    }

    public static void decrypt(String inputFile, String outputFile) throws Exception {
        byte[] keyBytes = KEY.getBytes();
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] inputData = Files.readAllBytes(Paths.get(inputFile));
        byte[] decryptedData = cipher.doFinal(inputData);

        Files.write(Paths.get(outputFile), decryptedData);
    }

    public static void main(String[] args) throws Exception {
        encrypt("input.txt", "encrypted.dat");
        decrypt("encrypted.dat", "decrypted.txt");
    }
}
