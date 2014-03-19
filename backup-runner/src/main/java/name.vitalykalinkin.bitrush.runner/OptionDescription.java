package name.vitalykalinkin.bitrush.runner;

import org.apache.commons.cli.Options;

public abstract class OptionDescription {
    public static Options getOptions(){
        Options options = new Options();

        options.addOption("c", "config", true, "Configuration file");

        return options;
    }
}
