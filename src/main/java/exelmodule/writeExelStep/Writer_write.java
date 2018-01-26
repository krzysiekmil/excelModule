package exelmodule.writeExelStep;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Writer_write implements ItemWriter<String>{
    @Override
    public void write(List<? extends String> list) throws Exception {

    }
}
