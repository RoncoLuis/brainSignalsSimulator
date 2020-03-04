package app.utils;

import java.io.File;
import javax.swing.filechooser.FileFilter;
import org.apache.commons.io.FilenameUtils;

public class FiltroFileChooser extends FileFilter {

    @Override
    public boolean accept(File f) {
        return FilenameUtils.isExtension(f.getName(), "txt");
    }

    @Override
    public String getDescription() {
        return (".txt");
    }

}
