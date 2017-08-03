package com.jack.baseDemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jack on 2017/7/18.
 */
public class FileUtil {

    /***
     * 创建文件夹
     * @param dirPath
     */
    public static void mkdir(String dirPath){
        File folderPath = new File(dirPath);
        if(!folderPath.exists()){
            boolean b = folderPath.mkdir();
            String msg = "create folder failed";
            if(b){
                msg = "create folder success";
            }
            System.out.println("----" + msg);
        }
    }


    /***
     * 创建文件并写入内容
     * @param dirPath
     * @param content
     */
    public static void createNewFile(String dirPath, String content){
        File filePath = new File(dirPath);
        if(!filePath.exists()){
            try {
                boolean b = filePath.createNewFile();
                FileWriter resultFile = new FileWriter(filePath);
                PrintWriter myFile = new PrintWriter(resultFile);
                myFile.println(content);
                resultFile.close();
                String msg = "create file failed";
                if(b){
                    msg = "create file success";
                }
                System.out.println("------" + msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /***
     * 删除文件
     * @param filePath
     */
    public static void deleteFile(String filePath){
        File delFile = new File(filePath);
        boolean b = delFile.delete();
        String msg = "delete file failed";
        if(b){
            msg = "delete file success";
        }
        System.out.println("----" +  msg);
    }


    /***
     * 删除空文件夹
     * @param folderPath
     */
    public static void deleteEmptyFolder(String folderPath){
        File delFolderPath = new File(folderPath);
        boolean b= delFolderPath.delete();
        String msg = "delete empty folder failed";
        if(b){
            msg = "delete empty folder success";
        }
        System.out.println("---" + msg);
    }



    public static void deleteAllEmptyFolder(String folderPath){
        File delFolder = new File(folderPath);
        File[] files = delFolder.listFiles();
        if (files == null) {
            throw new AssertionError();
        }
        for (File file : files) {
            if (file.isDirectory()) {
                boolean b = file.delete();
                String msg = "delete folder failed";
                if (b) {
                    msg = "delete folder success";
                }
                System.out.println("-----" + msg);
            }
        }

    }


    public static void main(String[] args) {
        //mkdir("d:/javaFileDemo");
        //createNewFile("d:/javaFileDemo/demo.txt","hello world");
        //deleteFile("d:/javaFileDemo/demo.txt");
        //deleteEmptyFolder("d:/javaFileDemo");
        deleteEmptyFolder("d:/javaFileDemo");
    }
}
