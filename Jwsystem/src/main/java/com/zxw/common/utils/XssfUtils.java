package com.zxw.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

public class XssfUtils {

    /**
     * 导出学生信息模板。
     *
     * @param request  HttpServletRequest 对象
     * @param response HttpServletResponse 对象
     * @throws IOException 如果 I/O 错误发生
     */
    public void ExportXlsModel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置响应头信息
        String fileName = "student_info_template.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("UTF-8");
        String encodedFileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-Disposition", "attachment;filename=" + encodedFileName);

        // 创建工作簿
        try (SXSSFWorkbook workbook = new SXSSFWorkbook(100); // 保持100行在内存中
             OutputStream outputStream = response.getOutputStream()) {

            // 创建工作表
            Sheet sheet = workbook.createSheet("学生信息模板");

            // 创建标题行
            Row headerRow = sheet.createRow(0);
            List<String> headers = Arrays.asList("学号", "姓名", "性别", "出生日期", "专业", "班级", "联系电话", "邮箱");
            for (int i = 0; i < headers.size(); i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers.get(i));
            }

            // 可选：添加一些示例数据行（你可以根据需要调整）
            // 注意：这里只作为模板，所以通常不需要添加实际的数据行

            // 将工作簿写入输出流
            workbook.write(outputStream);
            outputStream.flush();
        }
    }
}