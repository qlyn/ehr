package com.sql.ehr.util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IOFile {
    //定义读取数据的byte数组，允许读取的字节数最大值可自行在getData方法修改
    static byte[] b;
    /*
     * 创建与删除
     */
    //创建目录和文件：会自动识别路径是目录还是文件创建对应的目录或文件
    //创建不能使用isFile方法判断，此时该路径还未创建，不属于任何文件或文件夹。
    public static void create(String filePath) {
        if(filePath.endsWith("/")) {
            createContent(filePath);
        }else {
            createFile(filePath);
        }
		/*if(isFile(filePath)==1) {		//此判断错误：不能使用isFile方法判断，此时该路径还未创建，不属于任何文件或文件夹。
			createFile(filePath);
		}
		if(isFile(filePath)==0) {
			createContent(filePath);
		}*/
    }

    //创建目录
    public static void createContent(String filePath) {
        File dir=new File(filePath);
        if(!dir.exists()){	//判断文件目录是否存在
            dir.mkdirs();  	//不存在则创建一个目录
        }
    }
    //创建文件：根据传入文件目录及文件名判断文件及其目录是否存在，不存在则创建
    public static void createFile(String filePath,String fileName) {
        String string=filePath+"/"+fileName;
        File file=new File(string);
        createContent(filePath);
        if(!file.exists()){				//如果文件不存在，如果没有先创建目录则会抛异常
            try {
                file.createNewFile();	//创造一个新文件
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //创建文件：根据传入文件目录及文件名判断文件及其目录是否存在，不存在则创建
    public static void createFile(String filePath) {
        File file=new File(filePath);
        createContent(file.getParent());
        if(!file.exists()){				//如果文件不存在，如果没有先创建目录则会抛异常
            try {
                file.createNewFile();	//创造一个新文件
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //创建文件：根据传入文件对象判断文件及其目录是否存在，不存在则创建
    public static void createFile(File file) {
        File dir=new File(file.getParent());
        if(!dir.exists()){	//判断文件目录是否存在
            dir.mkdirs();  	//不存在则创建一个目录
        }
        if(!file.exists()){				//如果文件不存在，如果没有先创建目录则会抛异常
            try {
                file.createNewFile();	//创造一个新文件
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //删除目录和文件：会自动识别路径是目录还是文件
    public static void delete(String filePath) {
        if(isFile(filePath)==1) {
            deleteFile(filePath);
        }
        if(isFile(filePath)==0) {
            deleteContent(filePath);
        }
    }
    //删除文件
    public static void deleteFile(String filePath) {
        File file=new File(filePath);
        if(file.exists()){				//如果文件或目录存在
            file.delete();				//删除文件或目录
        }
    }
    //删除文件
    public static void deleteFile(String filePath,String fileName) {
        File file=new File(filePath+"/"+fileName);
        if(file.exists()){				//如果文件或目录存在
            file.delete();				//删除文件或目录
        }
    }

    //删除符合目录下符合目录名的所有目录
    public static void searchContentDelete(String content,String fileName){
        File file=new File(content);
        File[] files=file.listFiles();
        for(int i=0;i<files.length;i++) {
            if(files[i].isFile()) {	//如果是文件，不作操作
                continue;
            }
            else if(files[i].isDirectory()&&files[i].getName().equals(fileName)) {	//如果是目录名，并且目录名等同于要删除目录名，删除目录
                deleteContent(files[i].getAbsolutePath());
            }
            else{                                       //满足是目录但目录名不一致进入下一层文件，进行递归操作
                searchContentDelete(files[i].getAbsolutePath(),fileName);
            }
        }
    }

    //删除符合目录下符合文件名的所有文件
    public static void searchFileDelete(String content,String fileName){
        File file=new File(content);
        File[] files=file.listFiles();
        for(int i=0;i<files.length;i++) {
            if(files[i].isDirectory()) {	//如果是目录，进入下一层进行递归操作
                searchFileDelete(files[i].getAbsolutePath(),fileName);
            }
            else if(files[i].isFile()&&files[i].getName().equals(fileName)) {	//如果是文件名，并且文件名名等同于要删除文件名名，删除文件
                deleteFile(files[i].getAbsolutePath());
            }
        }
    }

    //清空目录：目录需要递归删除，delete()方法需要目录下没有任何文件或目录才能生效。
    //清空目录下所有文件，但当前目录还在，需要在方法外手动调用delete()方法删除
    public static void clearContent(String filePath) {
        File file=new File(filePath);
        File[] files=file.listFiles();
        for(int i=0;i<files.length;i++) {
            if(files[i].isFile()) {	//如果是文件，直接删除
                files[i].delete();
            }
            if(files[i].isDirectory()) {	//如果是目录，需要递归操作
                deleteContent(files[i].getAbsolutePath());
            }
            files[i].delete();							//先删除了当前层级的所有文件和目录再把当前层级目录删除
        }
    }
    //删除目录
    public static void deleteContent(String filePath) {
        clearContent(filePath); 	//清空目录下所有文件
        File file=new File(filePath);
        file.delete();
    }



    /*
     * 重命名和移动
     */
    //目录或文件重命名,能用于文件和目录：第一个参数目录或文件新全路径，第二个参数目录或文件旧全路径
    public static void Rename(String newFilePath,String oldFilePath) {
        File file1=new File(newFilePath);
        File file2=new File(oldFilePath);
        if(!file2.exists()) {
            throw new RuntimeException(new Exception("旧路径或文件不存在"));
        }
        if(file1.getParent().equals(file2.getParent())) {	//如果上级目录路径不一致，说明不是重命名操作
            if(file2.isFile()) {	//文件复制：需要读取文件数据
                copyFile(file1, file2);
                deleteFile(file2.getAbsolutePath());
            }
            if(file2.isDirectory()) {//目录复制
                copyContent(file1.getAbsolutePath(), file2.getAbsolutePath());
                deleteContent(file2.getAbsolutePath());	//删除目录
            }
        }else {
            throw new RuntimeException(new Exception("传入参数俩个路径的上级目录需要一致"));
        }
    }
    //目录或文件移动,能用于文件和目录：第一个参数放在哪个文件下面，第二个参数旧文件全路径
    public static void Move(String newFilePath,String oldFilePath) {
        File file2=new File(oldFilePath);
        File file1=new File(newFilePath+file2.getName());
        if(!file2.exists()) {
            throw new RuntimeException(new Exception("旧路径或文件不存在"));
        }
        if(file2.getName().equals(file1.getName())) {	//文件名需要一致
            if(file2.isFile()) {	//文件复制：需要读取文件数据
                copyFile(file1, file2);
                deleteFile(file2.getAbsolutePath());
            }
            if(file2.isDirectory()) {//目录复制
                copyContent(file1.getAbsolutePath(), file2.getAbsolutePath());
                deleteContent(file2.getAbsolutePath());	//删除目录
            }
        }else {
            throw new RuntimeException(new Exception("传入参数俩个路径的目录名或文件名需要一致"));
        }
    }



    /*
     * 复制：如果path1路径不存在文件或目录会自动创建
     */
    //复制目录和文件：会自动识别路径是目录还是文件创建对应的目录或文件
    public static void copy(String path1,String path2) {
        if(isFile(path2)==1) {
            copyFile(path1,path2);
        }
        if(isFile(path2)==0) {
            copyContent(path1,path2);
        }
    }
    //复制目录
    public static void copyContent(String path1,String path2) {
        File file1=new File(path1);
        File file2=new File(path2);
        createContent(file1.getAbsolutePath());
        //createContent(file2.getAbsolutePath());	//目录2如果不存在，说明路径错误，此时不能创建
        File[] files=file2.listFiles();	//获得path2下的文件及目录
        for(int i=0;i<files.length;i++) {
            try {
                if(files[i].isFile()) {
                    copyFile(file1.getAbsolutePath()+"/"+files[i].getName(),files[i].getAbsolutePath());
                }
                if(files[i].isDirectory()) {
                    copyContent(file1.getAbsolutePath()+"/"+files[i].getName(),files[i].getAbsolutePath());
                }
            }catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    //字节流复制文件(可以复制各种格式数据,如图片，视频等)
    public static void copyFile(String path1,String path2) {
        File file1=new File(path1);
        File file2=new File(path2);
        copyFile(file1, file2);
    }
    //字节流复制文件(可以复制各种格式数据,如图片，视频等)
    public static void copyFile(File file1,File file2) {
        try {
            createFile(file1);
            //createFile(file2);	//文件2如果不存在，说明路径错误，此时不能创建
            FileInputStream inputStream=new FileInputStream(file2);
            FileOutputStream outputStream=new FileOutputStream(file1);
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(outputStream);
            int data;
            while ((data=inputStream.read())!=-1) {
                bufferedOutputStream.write(data);
            }
            inputStream.close();
            bufferedOutputStream.close();
            outputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);	//补充异常后抛出运行异常（只会在运行时抛出的异常）
        }
    }
    //字符流复制文件(只能复制文本，可以复制中文文本)
    public static void copyTextFile(String path1,String path2) {
        File file1=new File(path1);
        File file2=new File(path2);
        copyTextFile(file1, file2);
    }
    //字符流复制文件(只能复制文本，可以复制中文文本)
    public static void copyTextFile(File file1,File file2) {
        try {
            createFile(file1);
            //createFile(file2);	//文件2如果不存在，说明路径错误，此时不能创建
            FileReader reader=new FileReader(file2);
            FileWriter writer=new FileWriter(file1);
            int data;
            while ((data=reader.read())!=-1) {
                writer.write(data);
            }
            reader.close();
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);	//补充异常后抛出运行异常（只会在运行时抛出的异常）
        }
    }



    /*
     * 传入数据生成文件和获取文件数据返回
     */
    //根据byte数组，生成文件（每一次都会重写文件）
    public static void getFile(byte[] b, String filePath,String fileName) {
        String string=filePath+"/"+fileName;
        File file=new File(string);
        try {
            createFile(file);
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(file));
            bufferedOutputStream.write(b);
            bufferedOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //根据byte数组，生成文件（每一次都会重写文件）
    public static void getFile(byte[] b, String filePath) {
        File file=new File(filePath);
        try {
            createFile(file);
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(file));
            bufferedOutputStream.write(b);
            bufferedOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //根据byte数组，生成文件（不会重写文件，只会追加文件内容）
    public static void getAppendFile(byte[] b, String filePath,String fileName) {
        String string=filePath+"/"+fileName;
        File file=new File(string);
        try {
            createFile(file);
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(file,true));
            bufferedOutputStream.write(b);
            bufferedOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //根据byte数组，生成文件（不会重写文件，只会追加文件内容）
    public static void getAppendFile(byte[] b, String filePath) {
        File file=new File(filePath);
        try {
            createFile(file);
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(file,true));
            bufferedOutputStream.write(b);
            bufferedOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //读取文件数据以byte数组格式返回
    public static byte[] getData(String filePath,String fileName) {
        String string=filePath+"/"+fileName;
        File file=new File(string);
        if(!file.exists()) {
            throw new RuntimeException(new Exception("文件不存在"));
        }
        if(isFile(string)!=1) {
            throw new RuntimeException(new Exception("传入的不是一个文件正确格式"));
        }
        b=new byte[(int) getFileLength(filePath, fileName)];	//每个文件数据长度不同，所以需要每次都修改byte数组
        try {
            BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(file));
            bufferedInputStream.read(b);
            bufferedInputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return b;
    }
    //读取文件数据以byte数组格式返回
    public static byte[] getData(String filePath) {
        File file=new File(filePath);
        if(!file.exists()) {
            throw new RuntimeException(new Exception("文件不存在"));
        }
        if(isFile(filePath)!=1) {
            throw new RuntimeException(new Exception("传入的不是一个文件正确格式"));
        }
        b=new byte[(int) getFileLength(filePath)];	//每个文件数据长度不同，所以需要每次都修改byte数组
        try {
            BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(file));
            bufferedInputStream.read(b);
            bufferedInputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return b;
    }



    /*
     * 获取文件的各种信息和判断
     */
    //返回文件最后一次修改时间
    public static String lastModifyTime(String filePath,String fileName) {
        String string=filePath+"/"+fileName;
        File file=new File(string);

        //把long 转换成 日期 再转换成String类型
        String dateFormat="yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = new Date(file.lastModified());
        return sdf.format(date);
    }
    //返回文件最后一次修改时间
    public static String lastModifyTime(String filePath) {
        File file=new File(filePath);

        //把long 转换成 日期 再转换成String类型
        String dateFormat="yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = new Date(file.lastModified());
        return sdf.format(date);
    }
    //把long 转换成 日期 再转换成String类型
    public static String transferLongToDate(String dateFormat, Long millSec) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = new Date(millSec);
        return sdf.format(date);
    }
    //获取文件绝对路径如果构造的时候是全路径就直接返回全路径，如果构造时是相对路径，就返回当前目录的路径 + 构造 File 对象时的路径
    public static String getFilePath(String filePath,String fileName) {
        String string=filePath+"/"+fileName;
        File file=new File(string);
        return file.getAbsolutePath();
    }
    //获取文件绝对路径如果构造的时候是全路径就直接返回全路径，如果构造时是相对路径，就返回当前目录的路径 + 构造 File 对象时的路径
    public static String getFilePath(String filePath) {
        File file=new File(filePath);
        return file.getAbsolutePath();
    }
    //获取文件长度，以字节为单位(字节数：一个中文俩个字节，一个字符一个字节)
    public static long getFileLength(String filePath,String fileName) {
        String string=filePath+"/"+fileName;
        File file=new File(string);
        return file.length();
    }
    //获取文件长度，以字节为单位(字节数：一个中文俩个字节，一个字符一个字节)
    public static long getFileLength(String filePath) {
        File file=new File(filePath);
        return file.length();
    }
    //获取目录下所有文件名或目录名
    public static String[] getAllName(String filePath,String fileName) {
        String string=filePath+"/"+fileName;
        File file=new File(string);
        return file.list();
    }
    //获取目录下所有文件名或目录名
    public static String[] getAllName(String path) {
        File file=new File(path);
        return file.list();
    }
    //获取目录下所有文件
    public static File[] getAllFile(String filePath,String fileName) {
        String string=filePath+"/"+fileName;
        File file=new File(string);
        return file.listFiles();
    }
    //获取目录下所有文件
    public static File[] getAllFile(String path) {
        File file=new File(path);
        return file.listFiles();
    }
    //判断是一个目录还是文件(1为文件，0为目录，-1既不是文件也不是目录，可能出现拼写错误)
    public static int isFile(String filePath,String fileName) {
        String string=filePath+"/"+fileName;
        File file=new File(string);
        if(file.isFile()) {
            return 1;
        }
        if(file.isDirectory()) {
            return 0;
        }
        return -1;
    }
    //判断是一个目录还是文件(1为文件，0为目录，-1既不是文件也不是目录，可能出现拼写错误)
    public static int isFile(String filePath) {
        File file=new File(filePath);
        if(file.isFile()) {
            return 1;
        }
        if(file.isDirectory()) {
            return 0;
        }
        return -1;
    }
    //判断是否是一个隐藏文件(1为是隐藏文件，0为非隐藏文件)
    public static int isHiddenFile(String filePath,String fileName) {
        String string=filePath+"/"+fileName;
        File file=new File(string);
        if(file.isHidden()) {
            return 1;
        }
        return 0;
    }
    //判断是否是一个隐藏文件(1为是隐藏文件，0为非隐藏文件)
    public static int isHiddenFile(String filePath) {
        File file=new File(filePath);
        if(file.isHidden()) {
            return 1;
        }
        return 0;
    }
}
