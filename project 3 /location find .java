import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;
import java.util.Locale;

/**
 * A utility class that retrieves the geographic location (country/city)
 * of a phone number using Google's libphonenumber library.
 * 
 * Compile & Run:
 *   - Add dependency: com.googlecode.libphonenumber:geocoder:2.205
 *   - javac PhoneNumberLocation.java
 *   - java PhoneNumberLocation <phoneNumber> <countryCode>
 * 
 * Example: java PhoneNumberLocation 15555520934 86
 * Output:  Location: China, Beijing
 */
public class PhoneNumberLocation {

    private static final PhoneNumberOfflineGeocoder GEOCODER = 
            PhoneNumberOfflineGeocoder.getInstance();

    public static void main(String[] args) {
        // Expect two arguments: phone number (digits only) and country code (e.g., 86 for China)
        if (args.length < 2) {
            System.err.println("Usage: java PhoneNumberLocation <phoneNumber> <countryCode>");
            System.err.println("Example: java PhoneNumberLocation 15555520934 86");
            System.exit(1);
        }

        String phoneNumber = args[0];
        int countryCode;
        try {
            countryCode = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Country code must be an integer.");
            System.exit(1);
            return;
        }

        String location = getLocation(phoneNumber, countryCode);
        System.out.println("Location: " + location);
    }

    /**
     * Returns the geographic description of the given phone number.
     *
     * @param phoneNumber digits only (e.g., "15555520934")
     * @param countryCode international dialing code (e.g., 86 for China)
     * @return a string like "China, Beijing" or "Unknown" if parsing fails
     */
    public static String getLocation(String phoneNumber, int countryCode) {
        try {
            long nationalNumber = Long.parseLong(phoneNumber);
            Phonenumber.PhoneNumber pn = new Phonenumber.PhoneNumber();
            pn.setCountryCode(countryCode);
            pn.setNationalNumber(nationalNumber);

            // Get location in English (you can change Locale.ENGLISH to Locale.CHINESE, etc.)
            return GEOCODER.getDescriptionForNumber(pn, Locale.ENGLISH);
        } catch (NumberFormatException e) {
            return "Invalid phone number format";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}



// Add the library – if you use Maven, add this to your pom.xml:
// xml
// <dependency>
//     <groupId>com.googlecode.libphonenumber</groupId>
//     <artifactId>geocoder</artifactId>
//     <version>2.205</version>
// </dependency>

// If you are not using Maven, download the JAR files for libphonenumber and geocoder from Maven Central and include them in your classpath.

// Compile (with dependencies on the classpath):

// bash
// javac -cp ".:geocoder-2.205.jar:libphonenumber-8.13.0.jar" PhoneNumberLocation.java
// Run:

// bash
// java -cp ".:geocoder-2.205.jar:libphonenumber-8.13.0.jar" PhoneNumberLocation 15555520934 86
// Output:

// text
// Location: China, Beijing
