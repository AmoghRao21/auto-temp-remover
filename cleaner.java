import java.nio.file.*;
import java.io.IOException;
import java.time.*;
import java.util.*;

public class cleaner {
    private static final Path LOG_PATH = Paths.get("cleaner_java.log");
    private static final List<Path> TEMP_DIRS = List.of(
        Paths.get(System.getProperty("user.home"), "Downloads"),
        Paths.get("/tmp"),
        Paths.get(System.getProperty("user.home"), "AppData", "Local", "Temp")
    );
    private static final List<String> FILE_TYPES = List.of("*.tmp", "*.log", "*.temp");

    public static void main(String[] args) throws IOException {
        Files.write(LOG_PATH, List.of("[" + Instant.now() + "] Cleanup started"), 
                   StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        for (Path dir : TEMP_DIRS) {
            if (Files.exists(dir)) {
                for (String type : FILE_TYPES) {
                    Files.walk(dir)
                        .filter(p -> p.getFileName().toString().matches(globToRegex(type)))
                        .filter(p -> isOlderThanDays(p, 7))
                        .forEach(p -> {
                            try {
                                Files.delete(p);
                                log("Deleted: " + p);
                            } catch (IOException e) {
                                try {
                                    log("Failed to delete: " + p + " (" + e.getMessage() + ")");
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }
                            }
                        });
                }
            } else {
                log("Skipped: " + dir + " (not found)");
            }
        }
        log("Cleanup completed");
    }

    private static boolean isOlderThanDays(Path file, int days) {
        try {
            Duration age = Duration.between(
                Files.getLastModifiedTime(file).toInstant(),
                Instant.now()
            );
            return age.toDays() > days;
        } catch (IOException e) {
            return false;
        }
    }

    private static String globToRegex(String glob) {
        return glob.replace(".", "\\.").replace("*", ".*");
    }

    private static void log(String message) throws IOException {
        Files.write(LOG_PATH, List.of("[" + Instant.now() + "] " + message), 
                   StandardOpenOption.APPEND);
    }
}