package br.com.projeto.aircncapi.spot.service;

import br.com.projeto.aircncapi.exception.ValidacaoException;
import br.com.projeto.aircncapi.spot.dto.SpotFiltros;
import br.com.projeto.aircncapi.spot.dto.SpotRequest;
import br.com.projeto.aircncapi.spot.dto.SpotResponse;
import br.com.projeto.aircncapi.spot.model.Spot;
import br.com.projeto.aircncapi.spot.repository.SpotRepository;
import br.com.projeto.aircncapi.user.repository.UserRepository;
import br.com.projeto.aircncapi.utils.FileService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SpotService {

    private final static ValidacaoException USER_NOT_FOUND = new ValidacaoException("User does not exist.");

    @Autowired
    private SpotRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FileService fileService;

    public SpotResponse save(SpotRequest request, MultipartFile file, ObjectId userId) {
        var spot = Spot.of(request);
        spot.setThumbnail(file.getOriginalFilename());
        var user = userRepository.findById(userId).orElseThrow(() -> USER_NOT_FOUND);
        spot.setUser(user);
        fileService.salvarArquivos(file);
        return SpotResponse.of(repository.save(spot));
    }

    public List<SpotResponse> getAllByFiltros(SpotFiltros filtros) {
        return StreamSupport.stream(repository.findAll(filtros.toPredicate().build()).spliterator(), false)
            .map(SpotResponse::of)
            .collect(Collectors.toList());
    }
}
