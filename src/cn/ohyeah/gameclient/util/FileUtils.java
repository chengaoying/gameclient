package cn.ohyeah.gameclient.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {

	public static byte[] FileToByteArray(File file) {
		FileInputStream stream = null;
		ByteArrayOutputStream out = null;
		try{
			stream = new FileInputStream(file);
			out = new ByteArrayOutputStream(1024);
			byte[] b = new byte[1024];
			int n;
			while ((n = stream.read(b)) != -1) {
				out.write(b, 0, n);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				out.close();
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return out.toByteArray();
	}
	
	public static File bytesArrayToFile(byte[] b, String outputFile) {  
        File ret = null;  
        BufferedOutputStream stream = null;  
        try {  
            ret = new File(outputFile);  
            FileOutputStream fstream = new FileOutputStream(ret);  
            stream = new BufferedOutputStream(fstream);  
            stream.write(b);  
        } catch (Exception e) {  
        	e.printStackTrace();
        } finally {  
            if (stream != null) {  
                try {  
                    stream.close();  
                } catch (IOException e) {  
                    // log.error("helper:get file from byte process error!");  
                    e.printStackTrace();  
                }  
            }  
        }  
        return ret;  
    }  
}
