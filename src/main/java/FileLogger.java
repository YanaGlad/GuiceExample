import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {
    private final Tag tag;

    @Inject
    public FileLogger(@NotNull Tag tag) {
        this.tag = tag;
    }

    @Override
    public void logLine(String str) {
        FileWriter writer;
        try {
            writer = new FileWriter("input.txt", true);

            writer.append(tag.tagString(str));
            writer.append("\n");
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
