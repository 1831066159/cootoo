package cn.com.cootoo;

import cn.com.cootoo.utils.MD5Util;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author zhaoxiang
 * @create 2019/6/28
 **/
public class ExcelMD5 {


    public static void main(String[] args) throws Exception {
        File xlsFile = new File("/Users/zhaoxiang/Documents/mawensi_data.xlsx");
        File md5File = new File("/Users/zhaoxiang/Documents/mawensi_md5.xlsx");
        // 获得源数据工作簿
        Workbook workbook = WorkbookFactory.create(xlsFile);

        // 创建工作薄MD5
        Workbook workbook_md5 = new SXSSFWorkbook();
        // 创建工作表MD5
        Sheet sheet_md5 = workbook_md5.createSheet("MD5");


        // 获得工作表个数
        int sheetCount = workbook.getNumberOfSheets();
        // 遍历工作表
        for (int i = 0; i < sheetCount; i++) {
            Sheet sheet = workbook.getSheetAt(i);
            // 获得行数
            int rows = sheet.getLastRowNum() + 1;
            // 获得列数，先获得一行，在得到改行列数
            Row tmp = sheet.getRow(0);
            if (tmp == null) {
                continue;
            }
            int cols = tmp.getPhysicalNumberOfCells();
            // 读取数据
            for (int row = 0; row < rows; row++) {
                Row r = sheet.getRow(row);
                Row row_md5 = sheet_md5.createRow(row);
                for (int col = 0; col < cols; col++) {
                    String val = r.getCell(col).getStringCellValue();
                    if (row > 0 && col > 0) {
                        // 第一行表头,不处理.
                        val = MD5Util.md5(val);
                    }

                    // 向工作表中添加数据
                    row_md5.createCell(col).setCellValue(val);
                }
            }
        }
        // 生成md5文件
        FileOutputStream xlsStream = new FileOutputStream(md5File);
        workbook_md5.write(xlsStream);
    }

}
