package com.liuwill.demo.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Administrator on 2015/10/16.
 */
public class CsvWriterUtil {
    public static boolean saveCsvToFile(String content,File saveFile){
        //BufferedWriter bufferedWriter = null;
        try {
            //String csvFileName = saveFile.getName();

            if (!saveFile.exists()) {// 如果文件不存在，则创建该文件
                saveFile.createNewFile();
            }
            FileWriter writer = new FileWriter(saveFile);// 获取该文件的输出流
            writer.write(content);// 写内容
            writer.flush();// 清空缓冲区，立即将输出流里的内容写到文件里
            writer.close();// 关闭输出流，施放资源
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
