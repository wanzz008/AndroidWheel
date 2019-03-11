package com.lkyj.androidwheel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 工具类
 */
public class Utils {

    public static  void  main(String[] args){

        int a = 100 ;
        System.out.println( a );
        change( a );
        System.out.println( a );


        String aa = "hello";
        System.out.println( aa  );
        change( aa );
        System.out.println( aa  );

        String bb = "hello";
        System.out.println( aa == bb );
    }

    private static void change(String aa) {
        aa = "hhhh";
    }

    private static void change(int a) {
        a = 200 ;
    }

    /**
     * 将Assets目录下的fileName文件拷贝至app缓存目录
     */
    public static String copyAssetAndWrite(Context context, String fileName) {
        try {
            File cacheDir = context.getCacheDir();
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            File outFile = new File(cacheDir, fileName);
            if (!outFile.exists()) {
                boolean res = outFile.createNewFile();
                if (res) {
                    InputStream is = context.getAssets().open(fileName);
                    FileOutputStream fos = new FileOutputStream(outFile);
                    byte[] buffer = new byte[is.available()];
                    int byteCount;
                    while ((byteCount = is.read(buffer)) != -1) {
                        fos.write(buffer, 0, byteCount);
                    }
                    fos.flush();
                    is.close();
                    fos.close();
                    Log.d("wzz------", "下载成功") ;
                    Toast.makeText(context, "下载成功", Toast.LENGTH_SHORT).show();
                    return outFile.getAbsolutePath();
                }
            } else {
                Log.d("wzz------", "文件已存在") ;
                Toast.makeText(context, "文件已存在", Toast.LENGTH_SHORT).show();
                return outFile.getAbsolutePath();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

}
