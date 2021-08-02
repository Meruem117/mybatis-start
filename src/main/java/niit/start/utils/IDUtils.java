package niit.start.utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * @auther: Meruem117
 */
public class IDUtils {
    public static String generateId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Test
    public void getIdTest() {
        System.out.println(generateId());
    }
}
