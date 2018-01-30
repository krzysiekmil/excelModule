package exelmodule.model;

import org.apache.poi.ss.usermodel.Row;

import java.util.Map;

public class ExcelReadDto {
    public Row row;
    public Map<String,Object> excelParams;

    public ExcelReadDto(Row row, Map<String, Object> excelParams) {
        this.row = row;
        this.excelParams = excelParams;
    }

    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }

    public Map<String, Object> getExcelParams() {
        return excelParams;
    }

    public void setExcelParams(Map<String, Object> excelParams) {
        this.excelParams = excelParams;
    }
}
