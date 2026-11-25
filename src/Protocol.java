import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public final class Protocol {
    public static final int DEFAULT_PORT = 5000;

    private Protocol() {}

    public static String build(String type, Object... fields) {
        StringBuilder sb = new StringBuilder(type);
        for (Object f : fields) {
            sb.append('|').append(URLEncoder.encode(String.valueOf(f), StandardCharsets.UTF_8));
        }
        return sb.toString();
    }

    public static List<String> parse(String line) {
        List<String> out = new ArrayList<>();
        for (String part : line.split("\\|", -1)) {
            out.add(URLDecoder.decode(part, StandardCharsets.UTF_8));
        }
        return out;
    }
}
