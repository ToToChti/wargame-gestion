import java.util.function.Function;

public class WargameInput {
    public final String content;
    public final Function<String, Boolean> treatInput;

    public WargameInput(String content, Function<String, Boolean> treatInput) {
        this.content = content;
        this.treatInput = treatInput;
    }
}
