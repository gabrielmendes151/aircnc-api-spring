package br.com.projeto.aircncapi.utils;

import br.com.projeto.aircncapi.exception.ValidacaoException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
@Slf4j
public class FileService {

    @Autowired
    private ServletContext servletContext;


    private static final ValidacaoException ERRO_SALVAR_ARQUIVO =
        new ValidacaoException("Ocorreu um erro durante o upload de arquivos.");
    
    @Value("${app-config.caminho-upload}")
    private String caminhoUploadBase;

    public String getCaminhoUploadCompleto(String nomeArquivo) {
        var path = String.join(File.separator,
            caminhoUploadBase,
            nomeArquivo);

        if (Files.notExists(Paths.get(path))) {
            try {
                Files.createDirectories(Paths.get(path));
            } catch (IOException ex) {
                log.error("Erro ao exportar caminho", ex);
            }
        }
        return path;
    }

    public void salvarArquivos(@NotNull MultipartFile file) {
        try {
            var path = getCaminhoUploadCompleto(file.getOriginalFilename());
            Files.copy(file.getInputStream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            log.error("Erro ao salvar arquivo", ex);
            throw ERRO_SALVAR_ARQUIVO;
        }
    }

    @SneakyThrows
    public void getImagem(String filename, HttpServletResponse response) {
        var resource = new ClassPathResource("uploads/" + filename);
        var in = resource.getInputStream();
        response.setContentType(MediaType.ALL_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }
}

