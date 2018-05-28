package com.om.common.util;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileUtil {
    /** 
     * 获得指定文件的byte数组  
     * @param filePath 文件绝对路径 
     * @return 
     */  
    public static byte[] file2Byte(File file){  
        ByteArrayOutputStream bos=null;  
        BufferedInputStream in=null;  
        try{
            if(!file.exists()){    
                throw new FileNotFoundException("file not exists");    
            }  
            bos=new ByteArrayOutputStream((int)file.length());  
            in=new BufferedInputStream(new FileInputStream(file));  
            int buf_size=1024;  
            byte[] buffer=new byte[buf_size];  
            int len=0;  
            while(-1 != (len=in.read(buffer,0,buf_size))){  
                bos.write(buffer,0,len);  
            }  
            return bos.toByteArray();  
        }  
        catch(Exception e){  
            System.out.println(e.getMessage());  
            e.printStackTrace();  
            return null;  
        }  
        finally{  
            try{  
                if(in!=null){  
                    in.close();  
                }  
                if(bos!=null){  
                    bos.close();  
                }  
            }  
            catch(Exception e){  
                System.out.println(e.getMessage());  
                e.printStackTrace();    
            }  
        }  
    }}