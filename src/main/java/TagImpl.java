import javax.inject.Singleton;
import java.util.Scanner;

@Singleton
public class TagImpl implements Tag {
    private final String tag;

    public TagImpl(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input what tag should be used while writing to file: ");
        tag = scanner.nextLine();
    }

    @Override
    public String tagString(String str) {
        return "<" + tag + ">" + str + "</" + tag + ">";
    }
}
