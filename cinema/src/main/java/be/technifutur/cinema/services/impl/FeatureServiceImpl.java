package be.technifutur.cinema.services.impl;

import be.technifutur.cinema.models.dtos.FeatureDTO;
import be.technifutur.cinema.models.forms.FeatureForm;
import be.technifutur.sharedclass.cinema.models.entities.Feature;
import be.technifutur.cinema.models.repositories.FeatureRepository;
import be.technifutur.cinema.services.FeatureService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureServiceImpl implements FeatureService {

    private final FeatureRepository repository;

    public FeatureServiceImpl(FeatureRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FeatureDTO> getAll() {
        return repository.findAll().stream().map(FeatureDTO::of).toList();
    }

    @Override
    public FeatureDTO getOne(Long id) {
        return repository.findById(id).map(FeatureDTO::of).orElseThrow();
    }

    @Override
    public FeatureDTO insert(FeatureForm form) {
        Feature toInsert = Feature.builder()
                            .description(form.getDescription())
                            .build();
        return FeatureDTO.of(repository.save(toInsert));
    }

    @Override
    public FeatureDTO update(Long id, FeatureForm form) {
        Feature toUpdate = repository.findById(id).orElseThrow();
        toUpdate.setDescription(form.getDescription());
        toUpdate = repository.save(toUpdate);
        return FeatureDTO.of(toUpdate);
    }

    @Override
    public FeatureDTO delete(Long id) {
        Feature toDelete = repository.findById(id).orElseThrow();
        repository.delete(toDelete);
        return FeatureDTO.of(toDelete);
    }
}