package name.vitalykalinkin.bitrush.runner;

import org.apache.commons.cli.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Main {
    private final static Log log = LogFactory.getLog(Main.class);

    public static void main(String args[]) throws ParseException {
        Options options = OptionsDescription.getOptions();

        CommandLineParser parser = new GnuParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("t")) {
            log.info("AAAAAAA");
            log.trace("BBBBBBBBB");
        }

        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("backup-runner", options);
    }
}
