package name.vitaly.kalinkin.bitrush.runner;

import org.apache.commons.cli.Options;

public class CommandLineOptions {
    private static final String DEFAULT_CONFIG_NAME = "application.config";
    private Options commandLineOptions;
    private String configFileName;

    public CommandLineOptions(Options commandLineOptions) {
        this.commandLineOptions = commandLineOptions;
        parse();
    }

    private void parse() {
        configFileName = commandLineOptions.getOption(OptionDescriptionFactory.OptionName.CONFIG)
                            .getValue(DEFAULT_CONFIG_NAME);
    }

    public String getConfigFileName() {
        return configFileName;
    }
}
