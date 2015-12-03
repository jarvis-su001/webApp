package jarvis.utils;

import jarvis.utils.files.CopyThread;
import jarvis.utils.files.FilesUtils;

import java.io.File;
import java.util.List;
import java.util.Vector;

/**
 * Created by C5023792 on 12/3/2015.
 */
public class FilesMain {

    private static int filesToBeCopied = -1;
    private static int THREAD_COUNT = 4;

    private static int n = 0;
    private static String sourcePath;
    private static String destPath;
    public static void main(String[] args) {

        File file = new File("E:/temp");
        String dest = "E:/tmp";
        FilesUtils.copyFile(file, dest);
    }


}
