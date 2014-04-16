package name.vitaly.kalinkin.bitrush.runner.config;

import org.apache.commons.cli.CommandLine;

public class CommandLineOptions {
    private static final String DEFAULT_CONFIG_NAME = "application.conf";

    public static final CommandLineOptions EMPTY = new CommandLineOptions();

    private CommandLine commandLine;

    // Configuration fields.
    private String configFileName;

    private CommandLineOptions() {

    }

    public CommandLineOptions(CommandLine commandLineOptions) {
        this.commandLine = commandLineOptions;
        parse();
    }

    private void parse() {
        configFileName = commandLine.getOptionValue(OptionDescriptionFactory.OptionName.CONFIG, DEFAULT_CONFIG_NAME);
    }

    public String getConfigFileName() {
        return configFileName;
    }

    @Override
    public String toString() {
        return "CommandLineOptions{" +
                "configFileName='" + configFileName + '\'' +
                '}';
    }
}
