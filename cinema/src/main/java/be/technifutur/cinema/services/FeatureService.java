package be.technifutur.cinema.services;

import be.technifutur.cinema.models.dtos.FeatureDTO;
import be.technifutur.cinema.models.forms.FeatureForm;
import java.util.List;

public interface FeatureService {
    List<FeatureDTO> getAll();
    FeatureDTO getOne(Long id);
    FeatureDTO insert(FeatureForm form);
    FeatureDTO delete(Long id);
    FeatureDTO update(Long id, FeatureForm form);
}
