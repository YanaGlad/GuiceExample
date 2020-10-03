import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class ConsoleLogger implements Logger {
    private final Tag tag;

    @Inject
    public ConsoleLogger(@NotNull Tag tag){
       this.tag = tag;
    }

    @Override
    public void logLine(String str) {
      System.out.println("Logged line : " + tag.tagString(str));
    }
}
