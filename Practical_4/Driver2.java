import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Driver2 {

    public static void main(String[] args) {

        String template =
                "Dear {name}, order {id} ships {date}.";

        String[] names = {"name", "id"};

        String[] values = {"Riya", "A07"};

        Pattern pattern =
                Pattern.compile("\\{(\\w+)\\}");

        Matcher matcher =
                pattern.matcher(template);

        StringBuilder result = new StringBuilder();

        int lastPosition = 0;

        while (matcher.find()) {

            result.append(
                template.substring(lastPosition,
                                   matcher.start())
            );

            String key = matcher.group(1);

            String value =
                TemplateFiller.findValue(
                    key, names, values
                );

            result.append(value);

            lastPosition = matcher.end();
        }

        result.append(
            template.substring(lastPosition)
        );

        System.out.println(result);
    }
}