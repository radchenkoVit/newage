package ui.utils;

import ui.congif.Environment;

public class RunReader {
    private static final String ENV_RUN_PROPERTY = "env";

    public static String getBaseUri() {
        return Environment.getBaseUri(System.getProperty(ENV_RUN_PROPERTY));
    }
}
