package name.vitaly.kalinkin.bitrush.runner.archive;

import com.google.inject.Inject;
import name.vitaly.kalinkin.bitrush.runner.reactor.Reactor;

import java.util.List;

public class FileSystemArchiver implements Archiver {

    private Reactor reactor;

    @Inject
    public FileSystemArchiver(Reactor reactor) {
        this.reactor = reactor;
    }

    @Override
    public void archive(List<String> sourceFolders) {

    }
}
