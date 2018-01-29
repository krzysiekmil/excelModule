package exelmodule.model;

import org.apache.poi.ss.usermodel.Row;

import java.util.Map;

public class ExelReadDto {
    public Row row;
    public Map<String,Object> exelParams;

    public ExelReadDto(Row row, Map<String, Object> exelParams) {
        this.row = row;
        this.exelParams = exelParams;
    }

    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }

    public Map<String, Object> getExelParams() {
        return exelParams;
    }

    public void setExelParams(Map<String, Object> exelParams) {
        this.exelParams = exelParams;
    }
}
