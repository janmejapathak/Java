import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WifiScanner {

    public static void main(String[] args) {
        scanWifiNetworks();
        showConnectedWifi();
    }

    // Scan all available WiFi networks
    public static void scanWifiNetworks() {
        try {
            Process process = Runtime.getRuntime().exec("netsh wlan show networks mode=bssid");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            System.out.println("Available WiFi Networks:\n");

            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith("SSID") ||
                    line.trim().startsWith("Signal") ||
                    line.trim().startsWith("Authentication")) {

                    System.out.println(line.trim());
                }
            }

        } catch (Exception e) {
            System.out.println("Error scanning WiFi networks: " + e.getMessage());
        }
    }

    //connected WiFi
    public static void showConnectedWifi() {
        try {
            Process process = Runtime.getRuntime().exec("netsh wlan show interfaces");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            System.out.println("\nConnected WiFi Details:\n");

            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith("SSID") ||
                    line.trim().startsWith("Signal") ||
                    line.trim().startsWith("State")) {

                    System.out.println(line.trim());
                }
            }

        } catch (Exception e) {
            System.out.println("Error getting connected WiFi: " + e.getMessage());
        }
    }
}
