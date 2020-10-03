import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.io.FileWriter;
import java.io.IOException;

public class CompositiveLogger implements Logger {
    private final Tag tag;
    private static int N = 1;

    @Inject
    public CompositiveLogger(@NotNull Tag tag) {
        this.tag = tag;
    }

    @Override
    public void logLine(String str) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("input.txt", true);

            System.out.println("Logged line number " + N + ": " + tag.tagString(str));
            N++;
            writer.append(N + " " + tag.tagString(str));
            writer.append("\n");
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
