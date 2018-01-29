package exelmodule.model;

import java.util.Map;

public class ExelFile {
    public String sourcePath;
    public String sheet;
    public Long row;
    public Long cell_in_row;


    public ExelFile(String sourcePath, String sheet, Long row, Long cell_in_row) {
        this.sourcePath = sourcePath;
        this.sheet = sheet;
        this.row = row;
        this.cell_in_row = cell_in_row;
    }



    public ExelFile() {
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getSheet() {
        return sheet;
    }

    public void setSheet(String sheet) {
        this.sheet = sheet;
    }

    public Long getRow() {
        return row;
    }

    public void setRow(Long row) {
        this.row = row;
    }

    public Long getCell_in_row() {
        return cell_in_row;
    }

    public void setCell_in_row(Long cell_in_row) {
        this.cell_in_row = cell_in_row;
    }
}
