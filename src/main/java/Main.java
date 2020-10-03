import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;

//Created by Yana Gladkikh Telegram @YanaGlad12
public class Main {
    public static void main(String[] args) throws IOException {
        final Injector injector = Guice.createInjector(new MainModule());
        injector.getInstance(LineResult.class).waitForInput();
    }
}
