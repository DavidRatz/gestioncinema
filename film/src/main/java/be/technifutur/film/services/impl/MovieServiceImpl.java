package be.technifutur.film.services.impl;

import be.technifutur.film.models.dtos.MovieDTO;
import be.technifutur.film.models.forms.MovieForm;
import be.technifutur.film.models.entities.Movie;
import be.technifutur.film.models.repositories.MovieRepository;
import be.technifutur.film.services.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository repository;

    public MovieServiceImpl(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MovieDTO> getAll() {
        return repository.findAll().stream().map(MovieDTO::of).toList();
    }

    @Override
    public MovieDTO getOne(Long id) {
        return repository.findById(id).map(MovieDTO::of).orElseThrow();
    }

    @Override
    public MovieDTO insert(MovieForm form) {
        Movie toInsert = Movie.builder()
                            .title(form.getTitle())
                            .description(form.getDescription())
                            .duration(form.getDuration())
                            .releaseDate(form.getReleaseDate())
                            .status(form.getStatus())
                            .formats(form.getFormats())
                            .genres(form.getGenres())
                            .persons(form.getPersons())
                            .build();
        return MovieDTO.of(repository.save(toInsert));
    }

    @Override
    public MovieDTO update(Long id, MovieForm form) {
        Movie toUpdate = repository.findById(id).orElseThrow();
        toUpdate.setTitle(form.getTitle());
        toUpdate.setDescription(form.getDescription());
        toUpdate.setDuration(form.getDuration());
        toUpdate.setReleaseDate(form.getReleaseDate());
        toUpdate.setStatus(form.getStatus());
        toUpdate.setFormats(form.getFormats());
        toUpdate.setGenres(form.getGenres());
        toUpdate.setPersons(form.getPersons());
        toUpdate = repository.save(toUpdate);
        return MovieDTO.of(toUpdate);
    }

    @Override
    public MovieDTO delete(Long id) {
        Movie toDelete = repository.findById(id).orElseThrow();
        repository.delete(toDelete);
        return MovieDTO.of(toDelete);
    }
}
