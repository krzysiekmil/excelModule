package exelmodule.writeExelStep;

import exelmodule.model.ExelReadDto;
import exelmodule.model.ExelWriteDto;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor_write implements ItemProcessor<ExelWriteDto,String>{


    @Override
    public String process(ExelWriteDto exelWriteDto) throws Exception {
        return null;
    }
}
