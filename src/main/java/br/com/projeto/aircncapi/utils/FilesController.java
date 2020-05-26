package br.com.projeto.aircncapi.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/files")
@CrossOrigin
public class FilesController {

    @Autowired
    private FileService fileService;

    @GetMapping("{filename}")
    public void getImagem(@PathVariable String filename, HttpServletResponse response) {
        fileService.getImagem(filename, response);
    }
}
