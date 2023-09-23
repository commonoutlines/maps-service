package commonoutlines.com.mapservice;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;



public class MapServiceLogic {

    public static String generateHash(MapGeoFence mapGeoFence)  {
        // Concatenate the four BigDecimal values into a single string
        String concatenatedValues = mapGeoFence.longitudeMin + mapGeoFence.longitudeMax + mapGeoFence.latitudeMin + mapGeoFence.latitudeMax;

        try {
            // Create a SHA-256 message digest instance
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(concatenatedValues.getBytes(StandardCharsets.UTF_8));

            // Convert the hash bytes to a hexadecimal string
            StringBuilder hashString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                hashString.append(String.format("%02x", hashByte));
            }

            return hashString.toString();
        }  catch (NoSuchAlgorithmException e) { return "ExceptionOccured "; }



    }

    public static MapGeoFence calculateBounds(float longitude, float latitude) {

        String longitudeLOWER;
        String longitudeUPPER;
        String latitudeLOWER;
        String latitudeUPPER;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        if(longitude == -0) { longitude = 0; }
        if(latitude == -0) { latitude = 0; }

        if (longitude >= 0 ) {
            longitudeLOWER = calculateLowerBound(longitude, 0.01f);
            longitudeUPPER = String.valueOf(decimalFormat.format((Double.parseDouble(longitudeLOWER) + 0.01)));
        } else {
            longitudeLOWER = calculateUpperBound(longitude, 0.01f);
            longitudeUPPER = String.valueOf(decimalFormat.format((Double.parseDouble(longitudeLOWER) - 0.01)));
        }

        if (latitude >= 0) {
            latitudeLOWER = calculateLowerBound(latitude, 0.01f);
            latitudeUPPER = String.valueOf(decimalFormat.format((Double.parseDouble(latitudeLOWER) + 0.01)));
        } else {
            latitudeLOWER = calculateUpperBound(latitude, 0.01f);
            latitudeUPPER = String.valueOf(decimalFormat.format((Double.parseDouble(latitudeLOWER) - 0.01)));
        }

        return new MapGeoFence(longitudeLOWER, longitudeUPPER, latitudeLOWER, latitudeUPPER);
    }

    public static String calculateLowerBound(float value, float precision) {
        double roundedValue = Math.floor(value / precision) * precision;
        DecimalFormat decimalFormat = new DecimalFormat("#.###"); // Specify the desired format
        return decimalFormat.format(roundedValue);
    }

    public static String calculateUpperBound(float value, float precision) {
        double roundedValue = Math.ceil(value / precision) * precision;
        DecimalFormat decimalFormat = new DecimalFormat("#.###"); // Specify the desired format
        return decimalFormat.format(roundedValue);
    }
}
