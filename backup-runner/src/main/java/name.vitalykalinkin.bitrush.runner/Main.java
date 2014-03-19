package name.vitalykalinkin.bitrush.runner;

import org.apache.commons.cli.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private final static Log log = LogFactory.getLog(Main.class);

    public static void main(String args[]){
        Options options = OptionDescription.getOptions();

        CommandLineParser parser = new GnuParser();

        Stream<String> testStream = Stream.builder().add("Test").add("Another").build().map(x -> (String) x);
        String str = testStream.collect(Collectors.joining("}|{"));

        log.warn("Stream processing result: " + str);

        try {
            CommandLine cmd = parser.parse(options, args);

            log.info(String.format("Configuration file: %s", cmd.getOptionValue("c", "megaconfig.conf")));
            log.trace("BBBBBBBBB");
        } catch (ParseException ex) {
            log.fatal(String.format("Could not parse command line options: %s", ex.getMessage()));
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("backup-runner", options);
            return;
        }

    }
}
