package exelmodule.readExelStep;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Writer implements ItemWriter<List<Object>>{

    @Override
    public void write(List<? extends List<Object>> list) throws Exception {
        list.forEach(row->row.forEach(cell->System.out.println(cell)));
    }
}
