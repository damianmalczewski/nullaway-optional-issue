# NullAway issue with `Optional.or(...)`

```java
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
```

On NullAway version 0.13.4, `./gradlew build` passes.

On NullAway version 0.13.7, `./gradlew build` fails:

```txt
Execution failed for task ':compileJava' (registered by plugin class 'org.gradle.api.plugins.JavaBasePlugin').
> Compilation failed; see the compiler output below.
  /home/damian/repo/nullaway-optional-issue/src/main/java/org/example/Main.java:11: error: [NullAway] incompatible types: Optional<@Nullable String> cannot be converted to Optional<String>
          return Optional.ofNullable(key).or(() -> Optional.ofNullable(System.getenv("DEFAULT_KEY")));
                                            ^
      (see http://t.uber.com/nullaway )
  1 error
```
