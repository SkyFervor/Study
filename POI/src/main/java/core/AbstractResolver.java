package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class AbstractResolver<T> implements InputResolver<T>, OutputResolver<T> {
	protected XSSFWorkbook xssfWorkbook;

	public AbstractResolver(File file) throws IOException {
		this.xssfWorkbook = new XSSFWorkbook(new FileInputStream(file));
	}

	public AbstractResolver(String filePath) throws IOException {
		this(new File(filePath));
	}

	protected String getValue(XSSFCell xssfCell) {
		int cellType = xssfCell.getCellType();
		if (cellType == XSSFCell.CELL_TYPE_BOOLEAN)
			return String.valueOf(xssfCell.getBooleanCellValue());
		else if (cellType == XSSFCell.CELL_TYPE_NUMERIC) {
			if (HSSFDateUtil.isCellDateFormatted(xssfCell)) {
				Date date = xssfCell.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return sdf.format(date);
			}
			NumberFormat formatter = new DecimalFormat("0.#");
			return String.valueOf(formatter.format(xssfCell.getNumericCellValue()));
		} else
			return String.valueOf(xssfCell.getStringCellValue()).trim();
	}

	@Override
	public void close() throws IOException {
		xssfWorkbook.close();
	}
}
