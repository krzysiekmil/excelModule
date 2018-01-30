package exelmodule.readExelStep;

import exelmodule.model.ExcelReadDto;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Processor implements ItemProcessor<ExcelReadDto, List<Object>> {
    protected Cell cell;
    @Override
    public List<Object> process(ExcelReadDto exelReadDto) throws Exception {
        List<Object> cellList = new ArrayList<>();
        for(int i = 0; i <Integer.valueOf(exelReadDto.excelParams.get("cell_in_row").toString()); i++) {
            if (exelReadDto.row == null)
                cellList.add(0);
            else {
                cell = exelReadDto.row.getCell(i);
                if (cell == null) {
                    cellList.add(0);
                } else {
                    cellList.add(cell);
                }

            }
        }
                return cellList;


    }

}




