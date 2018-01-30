package exelmodule.readExelStep;

import exelmodule.model.ExcelReadDto;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.item.ItemReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Reader implements ItemReader<ExcelReadDto> {

    private Map<String,Object> excelParams = new LinkedHashMap<>();
    private String sourcePath;
    private Integer row;
    private Workbook workbook;
    private Sheet dataSheet;
    String data;

    @Override
    public ExcelReadDto read() throws IOException {
        if(row==null||dataSheet==null||workbook==null){
            init();
        }
            if(row<=dataSheet.getLastRowNum())
            {
                return new ExcelReadDto(dataSheet.getRow(row++), excelParams);
            }
            else
            {
                return null;
            }
    }
    private void init() throws IOException {

        FileInputStream excelFile = new FileInputStream(sourcePath);
        workbook = new XSSFWorkbook(excelFile);
        dataSheet = workbook.getSheetAt(Integer.valueOf(excelParams.get("sheet").toString()));
        row=Integer.valueOf(excelParams.get("row").toString());
    }

    public void setExcelParams(Map<String, Object> excelParams) {
        this.excelParams = excelParams;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }




}
