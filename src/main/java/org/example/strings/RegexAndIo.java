package org.example.strings;

import java.util.Scanner;
import java.util.regex.MatchResult;

public class RegexAndIo {
}


//EXPLENATION OF THE REGEX

//        (\\d+[.]\\d+[.]\\d+[.]\\d+)
//        \\d is a shorthand character class that matches any digit (0-9). The double backslashes are needed in the Java string to escape the backslash itself, so it is interpreted as \d.
//        + is a quantifier that matches one or more of the preceding token. In this case, it matches one or more digits.
//        [.] is a character class that matches a literal dot .. The dot is put in a character class to avoid it being treated as a special character (the dot in regex usually means "match any character").
//        So, \\d+[.] matches one or more digits followed by a dot. For example, it would match 192. in 192.168.0.1.
//        The whole part (\\d+[.]\\d+[.]\\d+[.]\\d+) is a group that matches an IP address like 192.168.0.1. The parentheses are used to create a capturing group, which allows us to extract the matched portion of the text later with match.group(1).
//
//@ matches the literal character "@".
//
//        (\\d{2}/\\d{2}/\\d{4})
//        \\d{2} matches exactly two digits.
//        / matches the literal character "/".
//        So, \\d{2}/\\d{2}/ matches a date's month and day fields like 02/11.
//        \\d{4} matches exactly four digits, which would match a year like 2005.
//        The whole part (\\d{2}/\\d{2}/\\d{4}) is another group that matches a date in the format MM/DD/YYYY. Again, parentheses are used to create a capturing group, which allows us to extract the date portion with match.group(2).

class ThreatAnalyzer {
    static String threatData =
            "58.27.82.161@02/10/2005\n" +
                    "204.45.234.40@02/11/2005\n" +
                    "58.27.82.161@02/11/2005\n" +
                    "58.27.82.161@02/12/2005\n" +
                    "58.27.82.161@02/12/2005\n" +
                    "[Next log section with different data format]";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(threatData);
        String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@" +
                "(\\d{2}/\\d{2}/\\d{4})";
        while (scanner.hasNext(pattern)) {
            scanner.next(pattern);
            MatchResult match = scanner.match();
            String ip = match.group(1);
            String date = match.group(2);
            System.out.format("Threat on %s from %s\n", date, ip);
        }
    }
}