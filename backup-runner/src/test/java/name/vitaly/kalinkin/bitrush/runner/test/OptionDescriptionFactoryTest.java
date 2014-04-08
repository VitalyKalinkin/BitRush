package name.vitaly.kalinkin.bitrush.runner.test;

import name.vitaly.kalinkin.bitrush.runner.OptionDescriptionFactory;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OptionDescriptionFactoryTest {

    @Test
    public void configOption() {
        Options options = OptionDescriptionFactory.getOptions();

        Assert.assertNotNull("Options shall not be null.", options);
        Assert.assertTrue("Options shall have configOption.", options.hasOption(OptionDescriptionFactory.OptionName.CONFIG));

        Option configOption = options.getOption(OptionDescriptionFactory.OptionName.CONFIG);
        Assert.assertNotNull("configOption shall not be null.", configOption);
        Assert.assertTrue("configOption shall have an argument.", configOption.hasArg());
    }
}
