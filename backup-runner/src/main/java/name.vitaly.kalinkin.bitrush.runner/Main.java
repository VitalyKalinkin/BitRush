package name.vitaly.kalinkin.bitrush.runner;

import org.apache.commons.cli.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Main {
    private final static Log log = LogFactory.getLog(Main.class);

    public static void main(String args[]){
        name.vitaly.kalinkin.bitrush.runner.CommandLineOptions configOptions = parseCommandLine(args);

        if (configOptions.isEmpty())
            return;
    }

    private static name.vitaly.kalinkin.bitrush.runner.CommandLineOptions parseCommandLine(String[] args) {
                                            ≈
        Options options = name.vitaly.kalinkin.bitrush.runner.OptionDescriptionFactory.getOptions();

        CommandLineParser parser = new GnuParser();

        try {
            CommandLine cmd = parser.parse(options, args);
            name.vitaly.kalinkin.bitrush.runner.CommandLineOptions result =
                    new name.vitaly.kalinkin.bitrush.runner.CommandLineOptions(cmd.getOptions());

        } catch (ParseException ex) {
            log.fatal(String.format("Could not parse command line options: %s", ex.getMessage()));
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("backup-runner", options);

            return name.vitaly.kalinkin.bitrush.runner.CommandLineOptions.EMPTY;
        }

    }
}
