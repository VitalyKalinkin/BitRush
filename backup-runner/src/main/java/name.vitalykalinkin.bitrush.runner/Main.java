package name.vitalykalinkin.bitrush.runner;

import org.apache.commons.cli.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Main {
    private final static Log log = LogFactory.getLog(Main.class);

    public static void main(String args[]){
        Options options = OptionsDescription.getOptions();

        CommandLineParser parser = new GnuParser();

        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("c")) {
                log.info(String.format("Configuration file: %s", cmd.getOptionValue("c", "megaconfig.conf")));
                log.trace("BBBBBBBBB");
            }
        } catch (ParseException ex) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("backup-runner", options);
            return;
        }

    }
}
