package be.technifutur.film.services.impl;

import be.technifutur.film.models.dtos.MovieDTO;
import be.technifutur.film.models.forms.MovieForm;
import be.technifutur.film.models.forms.MovieFormatForm;
import be.technifutur.film.models.forms.MovieGenreForm;
import be.technifutur.film.models.forms.MoviePersonForm;
import be.technifutur.film.models.entities.*;
import be.technifutur.film.models.repositories.*;
import be.technifutur.film.services.MovieService;
import be.technifutur.film.utils.FormConverterList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository repository;
    private final FormatRepository formatRepo;
    private final GenreRepository genreRepo;
    private final PersonRepository personRepo;

    public MovieServiceImpl(MovieRepository repository, FormatRepository formatRepo, GenreRepository genreRepo,PersonRepository personRepo) {
        this.repository = repository;
        this.formatRepo = formatRepo;
        this.genreRepo = genreRepo;
        this.personRepo = personRepo;
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
                            .build();
        toInsert.setFormats(FormConverterList.convertIdList2EntityList(formatRepo,form.getFormats()));
        toInsert.setGenres(FormConverterList.convertIdList2EntityList(genreRepo,form.getGenres()));
        toInsert.setPersons(FormConverterList.convertIdList2EntityList(personRepo,form.getPersons()));
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
        toUpdate.setFormats(FormConverterList.convertIdList2EntityList(formatRepo,form.getFormats()));
        toUpdate.setGenres(FormConverterList.convertIdList2EntityList(genreRepo,form.getGenres()));
        toUpdate.setPersons(FormConverterList.convertIdList2EntityList(personRepo,form.getPersons()));
        toUpdate = repository.save(toUpdate);
        return MovieDTO.of(toUpdate);
    }

    
    @Override
    public MovieDTO patchFormats(Long id, MovieFormatForm form) {
        Movie toUpdate = repository.findById(id).orElseThrow();
        toUpdate.setFormats(FormConverterList.convertIdList2EntityList(formatRepo,form.getFormats()));
        toUpdate = repository.save(toUpdate);
        return MovieDTO.of(toUpdate);
    }

    @Override
    public MovieDTO patchGenres(Long id, MovieGenreForm form) {
        Movie toUpdate = repository.findById(id).orElseThrow();
        toUpdate.setGenres(FormConverterList.convertIdList2EntityList(genreRepo,form.getGenres()));
        toUpdate = repository.save(toUpdate);
        return MovieDTO.of(toUpdate);
    }

    @Override
    public MovieDTO patchPersons(Long id, MoviePersonForm form) {
        Movie toUpdate = repository.findById(id).orElseThrow();
        toUpdate.setPersons(FormConverterList.convertIdList2EntityList(personRepo,form.getPersons()));
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
