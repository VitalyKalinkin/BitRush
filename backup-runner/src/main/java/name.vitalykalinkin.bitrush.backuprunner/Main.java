package name.vitalykalinkin.bitrush.backuprunner;

import org.apache.commons.cli.*;

public class Main {
    public static void main(String args[]) throws ParseException {
        Options options = new Options();
        options.addOption("t", false, "Test option");

        CommandLineParser parser = new GnuParser();
        CommandLine cmd = parser.parse(options, args);

        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("backup-runner", options);
    }
}
