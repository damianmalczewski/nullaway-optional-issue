package org.example;

import java.util.Optional;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public class Main {

    public static Optional<String> getKey(@Nullable String key) {
        return Optional.ofNullable(key).or(() -> Optional.ofNullable(System.getenv("DEFAULT_KEY")));
    }

    public static void main() {
        Optional<String> code = getKey("TEST_KEY");
        code.ifPresent(s -> System.out.println("Value: " + s));
    }
}
