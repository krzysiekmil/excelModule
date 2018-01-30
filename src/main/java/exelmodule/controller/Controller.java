package exelmodule.controller;

import exelmodule.model.ExelFile;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class Controller {

    @Autowired
    JobLauncher jobLauncher;
    @Autowired
    Job job;



    @PostMapping("file/read")
    public void read(@RequestBody ExelFile exelFile) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, IOException {
        if (!exelFile.sourcePath.isEmpty() && !exelFile.sheet.isEmpty() && exelFile.row != null && exelFile.cell_in_row != null) {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("test", exelFile.sourcePath)
                    .addString("sheet", exelFile.sheet)
                    .addLong("row", exelFile.row)
                    .addLong("cell_in_row", exelFile.cell_in_row)
                    .addLong("time", System.nanoTime())
                    .toJobParameters();
            jobLauncher.run(job, jobParameters);
        }
    }

}
