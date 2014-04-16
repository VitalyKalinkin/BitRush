package name.vitaly.kalinkin.bitrush.runner;

import name.vitaly.kalinkin.bitrush.runner.config.CommandLineOptions;
import name.vitaly.kalinkin.bitrush.runner.config.MainConfiguration;
import name.vitaly.kalinkin.bitrush.runner.config.OptionDescriptionFactory;
import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {
    private final static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String args[]) {
        log.info("Starting backup runner...");

        CommandLineOptions commandLineOptions = parseCommandLine(args);
        log.info("Command line options parsed: {}", commandLineOptions);

        MainConfiguration mainConfiguration = readMainConfiguration(commandLineOptions);
        log.info("Main configuration read: {}", mainConfiguration);

        List<String> sourceFolders = mainConfiguration.getSourceFolders();
    }

    private static MainConfiguration readMainConfiguration(CommandLineOptions configOptions) {
        String configurationFileName = configOptions.getConfigFileName();

        return MainConfiguration.readFromFile(configurationFileName);
    }

    private static CommandLineOptions parseCommandLine(String[] args) {

        Options options = OptionDescriptionFactory.getOptions();

        CommandLineParser parser = new GnuParser();

        try {
            CommandLine cmd = parser.parse(options, args);
            CommandLineOptions result = new CommandLineOptions(cmd);
            return result;
        } catch (ParseException ex) {
            log.error("Could not parse command line options: {}", ex.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("backup-runner", options);

            return CommandLineOptions.EMPTY;
        }
    }
}
