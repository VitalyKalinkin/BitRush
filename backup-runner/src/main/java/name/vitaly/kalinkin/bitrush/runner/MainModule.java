package name.vitaly.kalinkin.bitrush.runner;

import com.google.inject.AbstractModule;
import name.vitaly.kalinkin.bitrush.runner.archive.Archiver;
import name.vitaly.kalinkin.bitrush.runner.archive.FileSystemArchiver;

public class MainModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Archiver.class).to(FileSystemArchiver.class);
    }
}
