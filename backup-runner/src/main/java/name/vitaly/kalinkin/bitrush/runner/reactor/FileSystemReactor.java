package name.vitaly.kalinkin.bitrush.runner.reactor;

import java.io.OutputStream;

public class FileSystemReactor implements Reactor {

    private String temporaryFolder;

    public FileSystemReactor(String temporaryFolder) {
        this.temporaryFolder = temporaryFolder;
    }

    @Override
    public void setOutputStream(OutputStream stream) {

    }
}
