package br.com.projeto.aircncapi.spot.controller;

import br.com.projeto.aircncapi.spot.dto.SpotFiltros;
import br.com.projeto.aircncapi.spot.dto.SpotResponse;
import br.com.projeto.aircncapi.spot.service.SpotService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin
public class DashboardController {

    @Autowired
    private SpotService service;

    @GetMapping
    public List<SpotResponse> getAllByFiltros(@RequestHeader("user_id") ObjectId userId) {
        var filtros = new SpotFiltros();
        filtros.setUserId(userId);
        return service.getAllByFiltros(filtros);
    }
}
