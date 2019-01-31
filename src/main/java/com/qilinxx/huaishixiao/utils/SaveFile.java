package com.qilinxx.huaishixiao.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * fang
 * 2019/1/22
 * 用来保存上传上来的多个文件，并进行相关操作
 *
 */
public class SaveFile {
    private static List<MultipartFile> fileList;
    private static String fileId;
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
    /**获取文件的大小*/
    public static String getFileSize(File file) {
        if (file.exists() && file.isFile()) {
            double sizeKB=(double)file.length()/1024d;
            double sizeMB=(double)file.length()/1024d/1024d;
            if(sizeMB<1){
                if(sizeKB==0){
                    return 0+"KB";
                }
                if(sizeKB>0&&sizeKB<1){
                    return 1+"KB";
                }
                return (long)sizeKB+"KB";
            }else {
                return (long)sizeMB+"MB";
            }

        }
        return "请输入文件！";
    }
    /**获取文件最后的修改时间*/
    public static String getFileLastTime(File file){
        if(file.exists() && file.isFile()){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(file.lastModified());
            return sdf.format(cal.getTime());
        }
        return "请输入文件！";
    }
    /**清空fileList*/
    public static void   clearFileList(){
        fileList.clear();
    }

    public static String getFileId() {
        return fileId;
    }

    public static void setFileId(String fileId) {
        SaveFile.fileId = fileId;
    }
    public static List<MultipartFile> getFileList() {
        return fileList;
    }
    public static void setFileList(List<MultipartFile> fileList) {
        SaveFile.fileList = fileList;
    }
}
