package exelmodule.readExelStep;

import exelmodule.model.ExelDto;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class Processor implements ItemProcessor<ExelDto, List<Object>> {
    @Override
    public List<Object> process(ExelDto exelDto) throws Exception {
        Sheet datatypeSheet = exelDto.exelfile.getSheetAt(Integer.valueOf(exelDto.exelParams.get("sheet").toString()));
        Iterator<Row> iterator = datatypeSheet.iterator();
        List<Object>data=new ArrayList<>();
        int row=Integer.valueOf(exelDto.exelParams.get("row").toString());
        if(row!=0) {
            while (row != 0) {
                iterator.next();
                row--;
            }
        }
        while (iterator.hasNext()) {
            List<String> list = new ArrayList<>();
            Row currentRow=iterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();
            int cell_in_row=Integer.valueOf(exelDto.exelParams.get("cell_in_row").toString());
            if(cell_in_row!=0) {
                while (cell_in_row != 0) {
                    cellIterator.next();
                    cell_in_row--;
                }
            }
            while (cellIterator.hasNext()) {
                Cell currentCell = cellIterator.next();
                if (currentCell.getCellType() == 0)
                    list.add(String.valueOf(currentCell.getNumericCellValue()));
                else
                    list.add(currentCell.getStringCellValue());
            }
            data.add(list);
        }
        return data;
    }

}





