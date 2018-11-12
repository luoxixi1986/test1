package day09;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;

/**
 * tedu.cn
 * @author zhengxj
 *
 */
public class ReadExcelJXL{
	
	  /* 
	   * 获得Excel数据，封装为@DataProvider�?要的类型Object[][]
	   * filePath:文件路径
	   * fileName:文件名称
	   * sheetName:表单名称
	   */
		public static Object[][] getTestData(String filePath, String fileName,
				String sheetName) throws IOException {
			try {
				String path = filePath + "\\" + fileName;
				InputStream inputStream = new FileInputStream(path);
				Workbook book = Workbook.getWorkbook(inputStream);
				Sheet sheet = book.getSheet(sheetName);
				int rowCount = sheet.getRows();
				System.out.println("行数="+rowCount);
				int columnCount = sheet.getRow(0).length;
				System.out.println("列数="+columnCount);
				String content[][] = new String[rowCount-1][columnCount];
		
				for(int i=0;i<rowCount-1;i++){
					Cell[] celli = sheet.getRow(i+1);
					for (int j = 0; j < columnCount; j++) {
						if(j>=celli.length  || celli[j].getType() == CellType.EMPTY){
							content[i][j] = "";
						}else{
							content[i][j] = celli[j].getContents();
						}
					}
				}
				return content;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}	
}
