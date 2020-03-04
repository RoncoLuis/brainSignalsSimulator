package app.utils;

import java.io.File;
import javax.swing.filechooser.FileFilter;
import org.apache.commons.io.FilenameUtils;

public class FiltroPDF extends FileFilter {

    @Override
    public boolean accept(File f) {
        return FilenameUtils.isExtension(f.getName(), "pdf");

    }

    @Override
    public String getDescription() {
        return (".pdf");
    }

}
