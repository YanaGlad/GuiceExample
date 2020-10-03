import com.google.inject.AbstractModule;

public class MainModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Tag.class).to(TagImpl.class);

        bind(Logger.class).annotatedWith(Console.class).to(ConsoleLogger.class);
        bind(Logger.class).annotatedWith(File.class).to(FileLogger.class);
        bind(Logger.class).annotatedWith(Compositive.class).to(CompositiveLogger.class);

    }
}
