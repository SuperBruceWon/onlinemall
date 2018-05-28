package com.om.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.util.StringUtils;

import com.om.web.entity.ExportUsers;

public class PoiUtils {
	public String CreateExcelDemo(List<ExportUsers> users) {

		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("用户表");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("用户名");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("邮箱");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("电话");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("用户状态");
		cell.setCellStyle(style);
		cell = row.createCell((short) 4);
		cell.setCellValue("创建日期");
		cell.setCellStyle(style);
		cell = row.createCell((short) 5);
		cell.setCellValue("修改日期");
		cell.setCellStyle(style);
		cell = row.createCell((short) 6);
		cell.setCellValue("创建者");
		cell.setCellStyle(style);
		cell = row.createCell((short) 7);
		cell.setCellValue("修改者");
		cell.setCellStyle(style);

		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，

		for (int i = 0; i < users.size(); i++) {
			row = sheet.createRow((int) i + 1);
			ExportUsers stu = users.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell((short) 0).setCellValue(stu.getUsername());
			row.createCell((short) 1).setCellValue(stu.getEmail());
			row.createCell((short) 2).setCellValue(stu.getMobile());
			if (StringUtils.isEmpty(stu.getValid())) {
				row.createCell((short) 3).setCellValue("");
			} else {
				row.createCell((short) 3).setCellValue(stu.getValid() == 1 ? "正常" : "禁用");
			}
			if (StringUtils.isEmpty(stu.getValid())) {
				row.createCell((short) 4).setCellValue(new SimpleDateFormat("yyyy-HH-dd").format(stu.getCreatedTime()));
			} else {
				row.createCell((short) 4).setCellValue("");
			}
			if (StringUtils.isEmpty(stu.getModifiedTime())) {
				row.createCell((short) 5).setCellValue(new SimpleDateFormat("yyyy-HH-dd").format(stu.getModifiedTime()));
			} else {
				row.createCell((short) 5).setCellValue("");
			}
			row.createCell((short) 6).setCellValue(stu.getCreatedUser());
			row.createCell((short) 7).setCellValue(stu.getModifiedUser());
		}
		// 第六步，将文件存到指定位置
		try {
			 File parent = new
			 File("D:"+File.separator+"FTP");
			 parent.mkdirs();
			String url = "D:/FTP/users.xls";
			FileOutputStream fout = new FileOutputStream(url);
			wb.write(fout);
			fout.close();
			return url;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
