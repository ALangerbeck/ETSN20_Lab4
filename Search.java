import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Search {

    public static void main(String[] args) {
        boolean case_sensitivity = true;
        Scanner file_scanner;
        String input_file = args[1];
        String input_string = args[0];
        if (args.length == 3 && args[0].charAt(0) == '-') {
            String flag = args[0];
            input_string = args[1];
            input_file = args[2];

            switch (flag) {
                case "-i":
                    case_sensitivity = false;
                    break;

                default:
                    System.out.print(
                            "The flag " + flag
                                    + " is not a valid flag.\nTo use a case sensitive search use flag -i \n");
                    return;

            }
        } else if (args.length != 2) {
            System.out.println(
                    "Program should be run with 2 arguments, <pattern to search for> <file to search in>, and a possible flag");
            return;
        }
        if (!case_sensitivity) {
            input_string = input_string.toLowerCase();
        }
        try {
            file_scanner = new Scanner(new File(input_file));
        } catch (FileNotFoundException e) {
            System.out.println("The file " + input_file + " was not found");
            return;
        }

        String currentLine;
        int line_number = 1;
        while (file_scanner.hasNextLine()) {
            currentLine = file_scanner.nextLine();
            if (!case_sensitivity && currentLine.toLowerCase().contains(input_string)) {
                System.out.println("line " + line_number + ": " + currentLine);
            } else if (currentLine.contains(input_string)) {
                System.out.println("line " + line_number + ": " + currentLine);

            }
            line_number++;
        }

        file_scanner.close();
    }
}