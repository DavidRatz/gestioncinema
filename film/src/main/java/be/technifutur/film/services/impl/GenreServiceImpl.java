package be.technifutur.film.services.impl;

import be.technifutur.film.models.dtos.GenreDTO;
import be.technifutur.film.models.forms.GenreForm;
import be.technifutur.film.models.repositories.GenreRepository;
import be.technifutur.film.services.GenreService;
import be.technifutur.sharedclass.film.models.entities.Genre;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository repository;

    public GenreServiceImpl(GenreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GenreDTO> getAll() {
        return repository.findAll().stream().map(GenreDTO::of).toList();
    }

    @Override
    public GenreDTO getOne(Long id) {
        return repository.findById(id).map(GenreDTO::of).orElseThrow();
    }

    @Override
    public GenreDTO insert(GenreForm form) {
        Genre toInsert = Genre.builder()
                            .description(form.getDescription())
                            .build();
        return GenreDTO.of(repository.save(toInsert));
    }

    @Override
    public GenreDTO update(Long id, GenreForm form) {
        Genre toUpdate = repository.findById(id).orElseThrow();
        toUpdate.setDescription(form.getDescription());
        toUpdate = repository.save(toUpdate);
        return GenreDTO.of(toUpdate);
    }

    @Override
    public GenreDTO delete(Long id) {
        Genre toDelete = repository.findById(id).orElseThrow();
        repository.delete(toDelete);
        return GenreDTO.of(toDelete);
    }
}