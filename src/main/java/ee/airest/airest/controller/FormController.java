package ee.airest.airest.controller;

import ee.airest.airest.domain.dto.FormRequestDTO;
import ee.airest.airest.service.FormService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileNotFoundException;


@Controller
@RequestMapping("/form")
public class FormController {

    private final FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }


    @GetMapping("")
    public String getForm(@ModelAttribute("form") FormRequestDTO form){
        return "form";
    }


    @PostMapping("/pdf")
    public ResponseEntity<?> printForm(@Valid @RequestBody FormRequestDTO form, BindingResult result) throws JRException, FileNotFoundException {

        if(result.hasErrors()){
           return ResponseEntity.badRequest().body(result.getFieldErrors());
        }

        byte[] data = this.formService.process(form);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline;attachment; filename=EASA-FORM1.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
    }


}


