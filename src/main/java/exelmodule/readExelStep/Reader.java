package exelmodule.readExelStep;

import com.thoughtworks.xstream.core.util.ArrayIterator;
import exelmodule.model.ExelDto;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.item.ItemReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


public class Reader implements ItemReader<ExelDto> {

    Map<String,Object> exelParams = new LinkedHashMap<>();
    String soucePath;
    Iterator<String> iterator;


    @Override
    public ExelDto read() throws IOException {
        if(iterator==null)
            iterator= Arrays.asList(soucePath).iterator();
        FileInputStream exelFile = new FileInputStream(new File(soucePath));
        while(iterator.hasNext()) {
            iterator.next();
            Workbook workbook = new XSSFWorkbook(exelFile);
            ExelDto exelDto = new ExelDto(workbook, exelParams);
            return exelDto;
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
