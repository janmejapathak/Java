import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WifiSecurityScanner {

    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("netsh wlan show networks mode=Bssid");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            String ssid = "";
            String security = "";

            System.out.println("Scanning WiFi Networks...\n");

            while ((line = reader.readLine()) != null) {

                line = line.trim();

                if (line.startsWith("SSID")) {
                    ssid = line.split(":")[1].trim();
                    System.out.println("\nWiFi Name: " + ssid);
                }

                if (line.startsWith("Authentication")) {
                    security = line.split(":")[1].trim();

                    String level = getSecurityLevel(security);

                    System.out.println("Security Type: " + security);
                    System.out.println("Security Level: " + level);
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to classify security level
    public static String getSecurityLevel(String security) {
        if (security.contains("WPA3"))
            return "Highly Secure";
        else if (security.contains("WPA2"))
            return "Secure";
        else if (security.contains("WPA"))
            return "Moderate";
        else if (security.contains("WEP"))
            return "Weak";
        else
            return "Open Network (Not Secure)";
    }
}
