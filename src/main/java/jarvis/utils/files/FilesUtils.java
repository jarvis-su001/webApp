package jarvis.utils.files;

import javax.swing.JOptionPane;
import java.io.File;
import java.util.List;

public class FilesUtils {

    /**
     * @param args
     */
    private static int filesToBeCopied = -1;
    // 要创建的线程数
    private static int THREAD_COUNT = 4;
    private static int n = 0;
    private static String sourcePath;
    private static String destPath;

    // 递归的方式读取文件
    public static int setCopiedFiles(String path, List<File> pool) {
        File sourceFile = new File(path);
        if (sourceFile.isFile()) {
            // 同步线程池，并唤醒所有等待的线程
            synchronized (pool) {
                pool.add(sourceFile);
                pool.notifyAll();
                n++;
            }
        } else {
            File[] files = sourceFile.listFiles();
            for (int i = 0; i < files.length; i++) {
                String tempString = files[i].getAbsolutePath();
                setCopiedFiles(tempString, pool);
            }
        }
        return n;
    }

    public static int getFilesToBeCopied() {
        return filesToBeCopied;
    }

    // 设置目录
    public static void setFilePath() {
        String temp = JOptionPane
                .showInputDialog("Input Source File Path(like C:\\\\projects) :");
        sourcePath = temp;
        temp = JOptionPane
                .showInputDialog("Input Target File Path(like C:\\\\projects) :");
        destPath = temp;
    }

    public static String getSourceFilePath() {
        return sourcePath;
    }

    public static String getTargetFilePath() {
        return destPath;
    }
}