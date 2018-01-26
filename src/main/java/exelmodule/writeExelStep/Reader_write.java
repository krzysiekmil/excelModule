package exelmodule.writeExelStep;

import exelmodule.model.ExelWriteDto;
import org.springframework.batch.item.*;

import java.util.*;

public class Reader_write implements  ItemReader<ExelWriteDto> {
    String sourcePath;
    Map exelData =new LinkedHashMap();


    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public Map getExelData() {
        return exelData;
    }

    public void setExelData(Map exelData) {
        this.exelData = exelData;
    }

    @Override
    public ExelWriteDto read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }
}
