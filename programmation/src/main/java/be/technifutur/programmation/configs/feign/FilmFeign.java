package be.technifutur.programmation.configs.feign;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import be.technifutur.sharedclass.film.models.dtos.MovieDTO;

@FeignClient(
        name = "film-service"
)
public interface FilmFeign {
    @GetMapping("/movie")
    public MovieDTO getMovieByRef(@RequestParam UUID ref);
}
