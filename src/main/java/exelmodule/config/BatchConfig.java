package exelmodule.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Reader;

@EnableBatchProcessing
@Configuration
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job readExel(Step readExelStep ) throws Exception
    {
        return jobBuilderFactory.get("readExel")
                .incrementer(new RunIdIncrementer())
                .flow(readExelStep)
                .end()
                .build();

    }
    //https://www.mkyong.com/java/apache-poi-reading-and-writing-excel-file-in-java/
    @Bean
    Step readExelStep(Reader reader,Processor processor,Writer writer)
    {


    }

}
