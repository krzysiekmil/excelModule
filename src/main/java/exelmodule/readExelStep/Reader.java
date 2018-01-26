package exelmodule.readExelStep;

import exelmodule.model.ExelReadDto;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.item.ItemReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


public class Reader implements ItemReader<ExelReadDto> {

    Map<String,Object> exelParams = new LinkedHashMap<>();
    String soucePath;
    Iterator<String> iterator;


    @Override
    public ExelReadDto read() throws IOException {
        if(iterator==null)
            iterator= Arrays.asList(soucePath).iterator();
        FileInputStream exelFile = new FileInputStream(soucePath);
        while(iterator.hasNext()) {
            iterator.next();
            Workbook workbook = new XSSFWorkbook(exelFile);
            ExelReadDto exelReadDto = new ExelReadDto(workbook, exelParams);
            return exelReadDto;
        }
        return null;
    }

    public void setExelParams(Map<String, Object> exelParams) {
        this.exelParams = exelParams;
    }

    public void setSoucePath(String soucePath) {
        this.soucePath = soucePath;
    }
}
