package exelmodule.readExelStep;

import exelmodule.model.ExelReadDto;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.item.ItemReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;


public class Reader implements ItemReader<ExelReadDto> {

    Map<String,Object> exelParams = new LinkedHashMap<>();
    String soucePath;
    Integer row;
    Workbook workbook;
    Sheet dataSheet;

    @Override
    public ExelReadDto read() throws IOException {
        if(row==null||dataSheet==null||workbook==null){
            row=Integer.valueOf(exelParams.get("row").toString());
            FileInputStream exelFile = new FileInputStream(soucePath);
            workbook = new XSSFWorkbook(exelFile);
            dataSheet = workbook.getSheetAt(Integer.valueOf(exelParams.get("sheet").toString()));
        }
            if(row<=dataSheet.getLastRowNum())
            {
                return new ExelReadDto(dataSheet.getRow(row++),exelParams);
            }
            else
            {
                return null;
            }
    }

    public void setExelParams(Map<String, Object> exelParams) {
        this.exelParams = exelParams;
    }

    public void setSoucePath(String soucePath) {
        this.soucePath = soucePath;
    }
}
