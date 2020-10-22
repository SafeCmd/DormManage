package com.tdysj.dorm.common.utils;

import java.io.*;
import java.util.UUID;

/**
 * @author Create by yachtcay
 * @date 2019/3/7 13:51
 */
public class FileUtils {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * 删除文件
     * @param fileName 文件全路径名
     * @return
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 删除文件和压缩图
     * @param fileDir 压缩图文件夹
     * @param fileName 文件全路径名
     * @return
     */
    public static boolean deleteFile(String fileDir, String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            file.delete();
            //删除压缩图
            File compressFileDir = new File(fileDir);
            if (compressFileDir.exists() && compressFileDir.isDirectory()) {
                String[] children = compressFileDir.list();
                for (String compressFilePath : children) {
                    File compressFile = new File(compressFileDir + File.separator +compressFilePath);
                    compressFile.delete();
                }
                compressFileDir.delete();
            }else{
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public static String renameToUUID(String fileName) {
        return UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
    }


    public static byte[] file2byte(String filePath) {
        byte[] buffer = null;
        try
        {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1)
            {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return buffer;
    }
}
