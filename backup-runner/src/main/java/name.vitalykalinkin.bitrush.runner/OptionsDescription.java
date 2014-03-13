package name.vitalykalinkin.bitrush.runner;

import org.apache.commons.cli.Options;

public abstract class OptionsDescription {
    public static Options getOptions(){
        Options options = new Options();

        options.addOption("t", "test", false, "Testing test");

        return options;
    }
}
