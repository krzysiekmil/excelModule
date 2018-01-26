package exelmodule.readExelStep;

import exelmodule.model.ExelReadDto;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class Processor implements ItemProcessor<ExelReadDto, List<Object>> {
    @Override
    public List<Object> process(ExelReadDto exelReadDto) throws Exception {
        Sheet datatypeSheet = exelReadDto.exelfile.getSheetAt(Integer.valueOf(exelReadDto.exelParams.get("sheet").toString()));
        Iterator<Row> iterator = datatypeSheet.iterator();

        for(Row r : datatypeSheet) {

        }

        List<Object>data=new ArrayList<>();
        int row=Integer.valueOf(exelReadDto.exelParams.get("row").toString());
        int row_max=Integer.valueOf(exelReadDto.exelParams.get("row_max").toString());
        if(row!=0) {
            while (row != 0) {
                iterator.next();
                row--;
            }
        }
        while (iterator.hasNext()){
            if(row_max==0)
                break;
            List<String> list = new ArrayList<>();
            Row currentRow=iterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();
            int cell_in_row=Integer.valueOf(exelReadDto.exelParams.get("cell_in_row").toString());
            int cell_in_row_max=Integer.valueOf(exelReadDto.exelParams.get("cell_in_row_max").toString());
            if(cell_in_row!=0) {
                while (cell_in_row != 0) {
                    cellIterator.next();
                    cell_in_row--;
                }
            }
            while (cellIterator.hasNext()) {
                if(cell_in_row_max==0)
                    break;
                Cell currentCell = cellIterator.next();
                if (currentCell.getCellType() == 0)
                    list.add(String.valueOf(currentCell.getNumericCellValue()));
                else
                    list.add(currentCell.getStringCellValue());
                cell_in_row_max--;
            }
            row_max--;
            data.add(list);
        }
        return data;
    }

}





