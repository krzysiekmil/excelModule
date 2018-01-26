package exelmodule.model;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Map;

public class ExelDto {
    public Workbook exelfile;
    public Map<String,Object> exelParams;

    public ExelDto(Workbook exelfile, Map<String, Object> exelParams) {
        this.exelfile = exelfile;
        this.exelParams = exelParams;
    }

    public Workbook getExelfile() {
        return exelfile;
    }

    public void setExelfile(Workbook exelfile) {
        this.exelfile = exelfile;
    }

    public Map<String, Object> getExelParams() {
        return exelParams;
    }

    public void setExelParams(Map<String, Object> exelParams) {
        this.exelParams = exelParams;
    }
}
