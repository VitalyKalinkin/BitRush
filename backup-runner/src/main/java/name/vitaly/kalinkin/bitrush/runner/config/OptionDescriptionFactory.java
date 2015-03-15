package name.vitaly.kalinkin.bitrush.runner.config;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;

public abstract class OptionDescriptionFactory {

    public interface OptionName {
        String CONFIG_LONG = "config";
        String CONFIG = "c";
    }

    public static Options getOptions(){
        Options options = new Options();

        Option configOption = createConfigOption();

        options.addOption(configOption);

        return options;
    }

    @SuppressWarnings("AccessStaticViaInstance")
    private static Option createConfigOption() {
        return OptionBuilder.hasArg().withLongOpt(OptionName.CONFIG_LONG).create(OptionName.CONFIG);
    }
}
