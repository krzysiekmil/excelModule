package exelmodule.config;

import exelmodule.model.ExcelReadDto;
import exelmodule.readExelStep.Processor;
import exelmodule.readExelStep.Reader;
import exelmodule.readExelStep.Writer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@EnableBatchProcessing
@Configuration
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;


//

    @Bean
    public Job readExcel(Step readExcelStep ) throws Exception
    {
        return jobBuilderFactory.get("readExcel")
                .incrementer(new RunIdIncrementer())
                .flow(readExcelStep)
                .end()
                .build();

    }
    @Bean
    Step readExcelStep(Reader reader, Processor processor, Writer writer)
    {
        return stepBuilderFactory.get("readExcelStep")
                .<ExcelReadDto,List<Object>>chunk(1)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();

    }

    @Bean
    @StepScope
    public Reader getExcelFileParams(
            @Value("#{jobParameters['test']}")String sourcePath,
            @Value("#{jobParameters['sheet']}")Long sheet,
            @Value("#{jobParameters['row']}")Long row,
            @Value("#{jobParameters['cell_in_row']}")Long cell_in_row
    )throws Exception
    {
        Reader reader = new Reader();
        Map<String,Object> excelParam = new LinkedHashMap<>();
        excelParam.put("sheet",sheet);
        excelParam.put("row",row);
        excelParam.put("cell_in_row",cell_in_row);
        reader.setExcelParams(excelParam);
        reader.setSourcePath(sourcePath);
        return reader;
    }

}
