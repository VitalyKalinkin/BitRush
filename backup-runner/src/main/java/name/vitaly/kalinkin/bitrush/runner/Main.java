package name.vitaly.kalinkin.bitrush.runner;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import name.vitaly.kalinkin.bitrush.runner.archive.Archiver;
import name.vitaly.kalinkin.bitrush.runner.config.CommandLineOptions;
import name.vitaly.kalinkin.bitrush.runner.config.MainConfiguration;
import name.vitaly.kalinkin.bitrush.runner.config.OptionDescriptionFactory;
import name.vitaly.kalinkin.bitrush.runner.reactor.FileSystemReactor;
import name.vitaly.kalinkin.bitrush.runner.reactor.Reactor;
import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {
    private final static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String args[]) {
        log.info("Starting backup runner...");

        Thread.setDefaultUncaughtExceptionHandler(
                (thread, ex) -> log.error("Caught fatal exception in thread '{}'", thread, ex));

        CommandLineOptions commandLineOptions = parseCommandLine(args);
        log.info("Command line options parsed: {}", commandLineOptions);

        MainConfiguration mainConfiguration = readMainConfiguration(commandLineOptions);
        log.info("Main configuration read: {}", mainConfiguration);

        List<String> sourceFolders = mainConfiguration.getSourceFolders();
        final String temporaryReactorFolder = mainConfiguration.getTemporaryReactorFolder();

        Injector injector = Guice.createInjector(new MainModule());
        injector = injector.createChildInjector((Binder binder) -> binder.bind(Reactor.class).toInstance(new FileSystemReactor(temporaryReactorFolder)));

        Archiver archiver = injector.getInstance(Archiver.class);
        archiver.archive(sourceFolders);
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
            return new CommandLineOptions(cmd);
        } catch (ParseException ex) {
            log.error("Could not parse command line options: {}", ex.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("backup-runner", options);

            return CommandLineOptions.EMPTY;
        }
    }
}
