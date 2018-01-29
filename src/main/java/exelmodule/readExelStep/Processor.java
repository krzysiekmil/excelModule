package exelmodule.readExelStep;

import exelmodule.model.ExelReadDto;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Processor implements ItemProcessor<ExelReadDto, List<Object>> {
    Cell cell;
    @Override
    public List<Object> process(ExelReadDto exelReadDto) throws Exception {
        List<Object> cellList = new ArrayList<>();
        for(int i=0 ; i <Integer.valueOf(exelReadDto.exelParams.get("cell_in_row").toString());i++){
                cell=exelReadDto.row.getCell(i);
            if(cell==null) {
                cellList.add(0);
            }
                else
            {
                cellList.add(cell);
            }

        }
                return cellList;
//

    }

}




