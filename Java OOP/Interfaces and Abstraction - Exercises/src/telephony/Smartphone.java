package telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        StringBuilder stringBuilder = new StringBuilder();
        for (String url : urls){
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()){
                stringBuilder.append(String.format("Invalid URL!%n"));
            } else {
                stringBuilder.append(String.format("Browsing: %s!%n", url));
            }
        }
        return stringBuilder.toString().trim();
    }

    @Override
    public String call() {
        String regex = "\\D+";
        Pattern pattern = Pattern.compile(regex);
        StringBuilder stringBuilder = new StringBuilder();
        for (String number : numbers){
            Matcher matcher = pattern.matcher(number);
            if (matcher.find()){
                stringBuilder.append(String.format("Invalid number!%n"));
            } else {
                stringBuilder.append(String.format("Calling... %s%n", number));
            }
        }
        return stringBuilder.toString().trim();
    }
}
