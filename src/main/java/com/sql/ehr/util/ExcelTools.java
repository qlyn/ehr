package com.sql.ehr.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.MediaType;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.*;

public class ExcelTools {
    /**
     * Map生成excel表
     * @param head (头部的key必须对应map的key,头部的value设置的是excel表的表头（第一行）显示的内容。
     *             如：head[{id:序号}] content[{id,1}]，写入excel表第一行的会是序号，第二行为1
     * @param contents
     * @param sheetName
     * @param fileName
     * @return 返回保存的地址
     */
    public static String mapToExcel(LinkedHashMap<String,String> head, List<Map> contents,String sheetName,String fileName,
                                   HttpServletResponse response) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(sheetName);
        //生成内容
        for (int i = 0;i< contents.size()+1;i++){//excel的行数
            HSSFRow row = sheet.createRow(i);
            int j = 0;//列
            for (Map.Entry<String,String> property : head.entrySet()) {
                HSSFCell cell = row.createCell(j++);
                if (i == 0) {//表头信息
                    cell.setCellValue(property.getValue());
                }else{
                    cell.setCellValue(contents.get(i - 1).get(property.getKey()) == null ? null :contents.get(i - 1).get(property.getKey()).toString());
                }
            }
        }
        String folder=System.getProperty("java.io.tmpdir");
        String filePath = folder + "/" + fileName;
        writeFile(workbook,filePath);
        filePath=filePath.replace("/","");
        buildExcelDocument(workbook,fileName,response);
        return filePath;
    }

    /**
     * 浏览器下载excel设置必要参数
     * @param fileName
     * @param wb
     * @param response
     */
    private static  void  buildExcelDocument(Workbook wb, String fileName, HttpServletResponse response){
        try {
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName, "utf-8"));
            response.flushBuffer();
            ServletOutputStream outputStream = response.getOutputStream();
            wb.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 服务端生成excel文件
     * @param workbook
     * @param filePath
     * @return
     */
    private static String writeFile(HSSFWorkbook workbook, String filePath) {
        FileOutputStream stream = null;
        BufferedOutputStream outputStream = null;
        try {
            stream = new FileOutputStream(filePath);
            outputStream = new BufferedOutputStream(stream);
            workbook.write(outputStream);
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (stream != null){
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    /**
     * bean生成excel表
     * @param head (头部的key必须对应bean的属性名)
     * @param contents
     * @return 返回保存的地址
     */
    public static <T> String beanToExcel(LinkedHashMap<String,String> head, List<T> contents,String sheetName,String fileName) throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(sheetName);
        Class clazz = contents.get(0).getClass();
        //生成内容
        for (int i = 0;i< contents.size()+1;i++){//excel的行数
            HSSFRow row = sheet.createRow(i);
            int j = 0;//列
            for (Map.Entry<String,String> property : head.entrySet()) {
                HSSFCell cell = row.createCell(j++);
                if (i == 0) {//表头信息
                    cell.setCellValue(property.getValue());
                }else{
                    Field field = clazz.getDeclaredField(property.getKey());
                    field.setAccessible(true);
                    Object result = field.get(contents.get(i - 1));
                    cell.setCellValue(result == null ? null :result.toString());
                }
            }
        }
        String folder=System.getProperty("java.io.tmpdir");
        String filePath = folder + fileName;
        return writeFile(workbook,filePath);
    }

    public static void readExcel () {
        try {
            FileInputStream file = new FileInputStream(new File("Test.xlsx"));
            //使用Test.xlsx文件创建工作簿对象
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            //获取第一个sheet内容
            XSSFSheet sheet = workbook.getSheetAt(0);
            // 逐行遍历
            Iterator<Row> rowIterable = sheet.iterator();
            while (rowIterable.hasNext()){
                Row row = rowIterable.next();
                // 逐列遍历
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()){
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.println(cell.getNumericCellValue() + "t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.println(cell.getStringCellValue() + "t");
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
