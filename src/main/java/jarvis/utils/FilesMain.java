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
        // TODO 自动生成的方法存根
        // 线程池
        List<File> pool = new Vector<File>();
        FilesUtils.setFilePath();
        // 设置线程池，存放源目录的所有文件
        int totalFiles = FilesUtils.setCopiedFiles(sourcePath, pool);
        filesToBeCopied = totalFiles;
        System.out.println("total files ： " + filesToBeCopied);
        // 建立和运行线程
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new CopyThread(pool);
            threads[i].start();
        }
        // 安全起见，手动唤醒所有线程
        for (int i = 0; i < threads.length; i++) {
            threads[i].interrupt();
        }
    }


}
