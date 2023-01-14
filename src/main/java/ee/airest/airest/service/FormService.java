package ee.airest.airest.service;

import ee.airest.airest.domain.dto.FormRequestDTO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FormService {


    private final String templatePath;

    public FormService(@Value("${template.path}") String templatePath) {
        this.templatePath = templatePath;
    }


    public byte[] process(FormRequestDTO form) throws FileNotFoundException, JRException {

        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
                List.of(form), false);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("total", "7000");

        JasperReport compileReport = JasperCompileManager
                .compileReport(new FileInputStream(this.templatePath));

        JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters, beanCollectionDataSource);

        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
