import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LineResult {
    private final Logger consoleLog;
    private final Logger fileLog;
    private final Logger compositiveLog;
    private Logger mainLogger;

    @Inject
    public LineResult(@NotNull @Console Logger consoleLog,
                      @NotNull @File Logger fileLog,
                      @NotNull @Compositive Logger compositiveLog) {
        this.consoleLog = consoleLog;
        this.fileLog = fileLog;
        this.compositiveLog = compositiveLog;
    }

    public void waitForInput() {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Waiting for new lines. Press 0 to exit.");

            System.out.println("Enter console if you want to use console logging");
            System.out.println("Enter file if you want to use file logging");
            System.out.println("Enter compositive if you want to use compositive logging");
            String type = scanner.nextLine();

            switch (type) {
                case "console" -> mainLogger = consoleLog;
                case "file" -> mainLogger = fileLog;
                case "compositive" -> mainLogger = compositiveLog;
            }

            while (true) {
                System.out.println("Enter line to be logged: ");
                String line = scanner.nextLine();
                if (line.equals("0")) break;

                mainLogger.logLine(line);

            }
        } catch (IllegalStateException | NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
