package name.vitalykalinkin.bitrush.runner;

import org.apache.commons.cli.*;

public class Main {
    public static void main(String args[]) throws ParseException {
        Options options = OptionsDescription.getOptions();

        CommandLineParser parser = new GnuParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("t")) {
            System.out.println("AAAAAAA");
        }

        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("backup-runner", options);
    }
}
