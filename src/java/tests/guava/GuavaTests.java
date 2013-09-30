package tests.guava;

import com.google.common.base.Optional;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author Mikhail Baturov, 9/30/13 7:13 PM
 */
public class GuavaTests {
    public static void main(String[] args) {
        Map<String, Optional<String>> mm = Maps.newHashMap();
        Optional<String> opt = Optional.of("my");

        mm.put("1", opt);
        mm.put("0", Optional.<String>absent());

        System.out.println(mm);
    }
}
