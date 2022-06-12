package be.technifutur.film.services.impl;

import be.technifutur.film.models.dtos.FormatDTO;
import be.technifutur.film.models.forms.FormatForm;
import be.technifutur.film.models.repositories.FormatRepository;
import be.technifutur.film.services.FormatService;
import be.technifutur.sharedclass.film.models.entities.Format;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormatServiceImpl implements FormatService {

    private final FormatRepository repository;

    public FormatServiceImpl(FormatRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FormatDTO> getAll() {
        return repository.findAll().stream().map(FormatDTO::of).toList();
    }

    @Override
    public FormatDTO getOne(Long id) {
        return repository.findById(id).map(FormatDTO::of).orElseThrow();
    }

    @Override
    public FormatDTO insert(FormatForm form) {
        Format toInsert = Format.builder()
                            .description(form.getDescription())
                            .build();
        return FormatDTO.of(repository.save(toInsert));
    }

    @Override
    public FormatDTO update(Long id, FormatForm form) {
        Format toUpdate = repository.findById(id).orElseThrow();
        toUpdate.setDescription(form.getDescription());
        toUpdate = repository.save(toUpdate);
        return FormatDTO.of(toUpdate);
    }

    @Override
    public FormatDTO delete(Long id) {
        Format toDelete = repository.findById(id).orElseThrow();
        repository.delete(toDelete);
        return FormatDTO.of(toDelete);
    }
}
