package ui.congif;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Environment {
    DEV("https://api.stage.beti.io/swagger_ui/"),
    QA("NOT EXIST");
    private static Map<String, Environment> envMap = initEnvMap();

    private String uri;

    Environment(String uri) {
        this.uri = uri;
    }

    public static String getBaseUri(String env) {
        if (env == null || env.isEmpty()) {
            throw new RuntimeException("No Environment is set");
        }

        if (envMap.containsKey(env)) {
            return envMap.get(env).uri;
        }

        // or set some default value
        throw new RuntimeException("Incorrect environment name: " + env);
    }

    private static Map<String, Environment> initEnvMap() {
        return Arrays.stream(values())
                .collect(Collectors.toMap(e -> e.name().toLowerCase(), Function.identity()));
    }
}
