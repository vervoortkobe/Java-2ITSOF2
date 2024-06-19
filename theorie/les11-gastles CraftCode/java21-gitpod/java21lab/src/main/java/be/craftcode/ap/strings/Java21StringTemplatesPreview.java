package be.craftcode.ap.strings;

import static java.lang.StringTemplate.STR;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class Java21StringTemplatesPreview {

    /*
     *
     * +------------------------------------------+
     * | JEP 430: String Templates (Preview)      |
     * +------------------------------------------+
     * ( https://openjdk.org/jeps/430 )
     *
     * Check out what experienced programmers had to say about this feature:
     * Hacker News discussion - https://news.ycombinator.com/item?id=35012862
     *
     * Most languages have had string interpolation since around 2015.
     * In simple terms, it's the ability to write code directly into the flow of the string.
     * 
     * Here are some examples that you might have seen already:
     *  Python: f"{x} plus {y} equals {x + y}"
     *  JavaScript: `${x} plus ${y} equals ${x + y}`
     * 
     * Until today, us Java programmers have had to use String.format():
     * String s = String.format("%2$d plus %1$d equals %3$d", x, y, x + y);
     * 
     * String.format() is not always easy to read, and if you have a ton of variables, 
     * keeping the types matched up can be difficult.
     * 
     * Java has a more conservative approach to adding new features. Being 8 years late to
     * the interpolation party has allowed them to learn from other language's mistakes.
     * 
     * Real code gets real complicated, and tracking down the code meatballs in the string spaghetti
     * can be difficult. It also becomes even more important to validate when building SQL queries or JSON, 
     * or you might find yourself vulnerable to code injection.
     * 
     * For this reason, Java's proposal for String Templates makes validation integral and explicit.
     * 
     * 
     * A Java String Template expression consists of 3 parts:
     * 
     * String s = STR."\{x} + \{y} = \{x + y}";
     * 
     * 1) A template processor. (Here it's STR, which returns a String)
     * 2) A dot character (U+002E)
     * 3) A template. (Here "\{x} + \{y} = \{x + y}")
     * 
     * Lets expand on processors and templates, beginning with templates.
     * 
     * 
     * TEMPLATES
     * ------------------
     * This might look like a string, but it's not! 
     * 
     *   "My name is \{name}."
     * 
     * This is a template. 
     * 
     * In fact, if you try to assign the above to a String variable you'll get an error:
     * 
     * String oops = "My name is \{name}."
     * *** Processor missing from string template expression.
     * 
     * What makes it a template is the presence of an escaped curly brace: "\{". 
     * 
     * Java decided against using "${}" like many other languages because that is a valid
     * String, and giving it a new behavior would violate backwards compatibility.
     * In other words, someone may have been using strings with "${}" in them, and making 
     * those symbols do something else in Java would break their code.
     * 
     * In contrast, using the characters "\{" in a string on an older version of
     * Java was never legal and would have thrown the following error: 
     * *** Invalid escape sequence (valid ones are  \b  \t  \n  \f  \r  \"  \'  \\ )
     * This means that StringTemplates won't be responsible for breaking any existing code.
     * 
     * 
     * But a template alone is useless. It needs a RAW processor to even be assigned 
     * to a StringTemplate variable:
     * 
     * int x = 10, y = 20;
     * StringTemplate st = RAW."\{x} plus \{y} equals \{x + y}";
     * 
     * 
     * But what exactly is a StringTemplate?
     * 
     * It is a class holds two separate Lists:
     * 
     * 1) Fragments:
     * List<String> fragments = st.fragments();
     * 
     * This is a list of all the String chunks from the template. 
     * ( here it would be:[ "", " plus ", " equals ", "" ] )
     * 
     * 2) Values:
     * List<Object> values = st.values();
     * 
     * This is a list of the computed results of each expression.
     * (Above it was [10, 20, 30])
     * 
     * But to get something useful out of a template, it must first be processed.
     * 
     * 
     * PROCESSORS
     * -------------------
     * 
     * A processor can actually return anything! (JSONObject, PreparedStatement, etc...)
     * 
     * The only one included in this preview is STR, which simply builds a String by taking
     * a String from the Fragment list in the StringTemplate and concatenating
     * an object from the Values list and repeating until both lists are consumed, and 
     * finally returning the resulting String.
     * 
     * Example:
     * 
     * int x = 10, y = 20;
     * StringTemplate st = RAW."\{x} plus \{y} equals \{x + y}";
     * String processed = STR.process(st);
     * 
     * The above is the verbose version of the standard format:
     * 
     * String processed = STR."\{x} plus \{y} equals \{x + y}";
     * 
     * Because a processor is explicitly required, validation is baked into the process,
     * preventing invalid or malicious strings from propagating throughout your code.
     * 
     * You can even make your own TemplateProcessor and have it perform all the validation,
     * throw any type of error, and return whatever object you'd like!
     * 
     * Here's a reimagining of the STR processor:
     * 
     * StringTemplate.Processor<String, RuntimeException> INTER = 
     * 
     * StringTemplate.Processor.of((StringTemplate st) -> {
     *      StringBuilder sb = new StringBuilder();
     *      Iterator<String> fragIter = st.fragments().iterator();
     *      for (Object value : st.values()) {
     *          sb.append(fragIter.next());
     *          sb.append(value);
     *      }
     *      sb.append(fragIter.next());
     *      return sb.toString();
     * });
     * int x = 10, y = 20;
     * String s = INTER."\{x} plus \{y} equals \{x + y}";
     * 
     * StringTemplate even has a utility method to simplify the above into a single line:
     * var INTER = StringTemplate.Processor.of(StringTemplate::interpolate);
     * 
     * 
     * In summary, String Templates improve readability and developer experience, without
     * sacrificing safety.
     */
    public String sumString(int x, int y) {
        return STR."\{x} plus \{y} equals \{x + y}" ;
    }

    public String subtractString(int x, int y){
        //TODO 1: Implement this method using string templates.
        // if x = 5 and y = 3 the resulting string should be:
        // "5 minus 3 equals 2"
        return STR."\{x} minus \{y} equals \{x - y}";
    }

    //Here is a simple custom Template Processor that interpolates values without any validation and returns a JSONObject.
    //As long as no one tries to inject something by adding \" into one of their values, it works.
    //But it will fail and throw a JSONException if the input values are improper, or worse, the user can inject
    //unexpected properties into the json!
    StringTemplate.Processor<JSONObject, RuntimeException> JSON = StringTemplate.Processor.of(
                (StringTemplate st) -> new JSONObject(st.interpolate())
        );

    //This method uses the unsafe processor for testing purposes. (See junit tests to see how this can go wrong):
    public JSONObject userJSONUnsafe(String name, String phone, String address) {
        JSONObject user = JSON."""
                        {
                            "name":    "\{name}",
                            "phone":   "\{phone}",
                            "address": "\{address}"
                        };
                        """;

        return user;
    }
    
    //Here is a Template Processor that returns a JSONObject, but performs some validation first.
    //No injection vulnerability here!
    StringTemplate.Processor<JSONObject, RuntimeException> JSON_VALIDATE = StringTemplate.Processor.of(
                (StringTemplate st) -> {
                    String quote = "\"";
                    List<Object> filtered = new ArrayList<>();
                    for(Object value: st.values()){
                        switch(value){
                            case String str -> filtered.add(quote + str.replace("\"", "\\\"") + quote);
                            case Number num -> filtered.add(num);
                            case Boolean bool -> filtered.add(bool);
                            case null, default -> throw new JSONException("Invalid value type");
                        }
                    }
                    String jsonSource = StringTemplate.interpolate(st.fragments(), filtered);
                    return new JSONObject(jsonSource);
                }
        );

    //And here is a method that uses the validated json processor
    public JSONObject userJSON(String name, String phone, String address){
        JSONObject user = new JSONObject();
        try {
            user = JSON_VALIDATE. """
                        {
                            "name":    \{ name },
                            "phone":   \{ phone },
                            "address": \{ address }
                        };
                        """ ;
        } catch (JSONException ex){
            System.out.println(ex.getMessage());
        }

        return user;
    }

    //TODO 2: Now let's make our own StringTemplate Processor! The validation of this template
    //should censor a couple different strings, replacing them with stars. Chosen completely at random,
    // the censored strings should be "Purple", and "KBVA".
    //(e.g.: Purple is replaced with ******, and KBVA becomes ****)
    StringTemplate.Processor<String, RuntimeException> PRCSR = StringTemplate.Processor.of(
                (StringTemplate st) -> {
                    List<Object> filtered = new ArrayList<>();
                    //Put your filtering here (look at the JSON_VALIDATE processor for inspiration):
                    filtered = st.values().stream()
                            //.filter(o -> "purple".equals(o.toString()) || "KBVA".equals(o.toString()))
                            .map(o -> {
                                if("purple".equals(o.toString())) return "******";
                                if("KBVA".equals(o.toString())) return "****";
                                return o;
                            })
                            .toList();
                    return StringTemplate.interpolate(st.fragments(), filtered);
                }
        );

    public String processChant(String color1, String color2, String acronym){
        return PRCSR."""
                    \{ color1 } and \{ color2 }: Loving colors
                    You always bring down the enemy
                    Because whatever happens
                    Our boys always stand firm;
                    \{ color1 } and \{ color2 }: Let us repeat
                    You will triumph again today
                    And Sing, yes, sing along now all
                    \{ color1 } and \{ color2 }, \{ acronym }""";
    }

}
