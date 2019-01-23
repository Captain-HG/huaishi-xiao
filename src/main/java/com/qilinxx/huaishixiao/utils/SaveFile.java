package com.qilinxx.huaishixiao.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * fang
 * 2019/1/22
 * 用来保存上传上来的多个文件，并进行相关操作
 *
 */
public class SaveFile {
    private static List<MultipartFile> fileList;
    /**
     * 先根遍历序递归删除文件夹
     *
     * @param dirFile 要被删除的文件或者目录
     * @return 删除成功返回true, 否则返回false
     */
    public static boolean deleteFile(File dirFile) {
        // 如果dir对应的文件不存在，则退出
        if (!dirFile.exists()) {
            return false;
        }

        if (dirFile.isFile()) {
            return dirFile.delete();
        } else {

            for (File file : dirFile.listFiles()) {
                deleteFile(file);
            }
        }
        return dirFile.delete();
    }
    /**清空fileList*/
    public static void   clearFileList(){
        fileList.clear();
    }
    public static List<MultipartFile> getFileList() {
        return fileList;
    }
    public static void setFileList(List<MultipartFile> fileList) {
        SaveFile.fileList = fileList;
    }
}
