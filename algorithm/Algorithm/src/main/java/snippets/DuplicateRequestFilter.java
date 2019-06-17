package snippets;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Filter to check if a request has been made more than once with same payload via hashes Currently applied to
 * SUPPORTED_HTTP_METHODS and FILTERS
 */

public class DuplicateRequestFilter {
  private final static Set<String> SUPPORTED_HTTP_METHODS = new HashSet<>(Arrays.asList("POST"));
  private final static Set<String> FILTERS = new HashSet<>(Arrays.asList("url"));
  private final static HashSet<String> duplicateMap = new HashSet<>();
  private final static int DUPLICATE_MAP_SIZE = 100;
  public void main(String[] args) throws Exception {
    try {
      String request = "";
      String hashedValue = getMD5Hex(request);
      if (duplicateMap.contains(hashedValue)) {
        throw new Exception("Duplicate request");
      } else {
        duplicateMap.add(hashedValue);
      }
    } finally {
      cleanUp();
    }

  }

  private static void cleanUp() {
    if (duplicateMap.size() > DUPLICATE_MAP_SIZE) {
      duplicateMap.clear();
    }
  }

  public static String getMD5Hex(final String inputString) throws NoSuchAlgorithmException {
    MessageDigest md5 = MessageDigest.getInstance("MD5");
    md5.update(StandardCharsets.UTF_8.encode(Optional.ofNullable(inputString).orElse("null")));
    return String.format("%032x", new BigInteger(1, md5.digest()));
  }
}

