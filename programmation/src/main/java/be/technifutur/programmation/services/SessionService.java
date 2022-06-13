package be.technifutur.programmation.services;

import be.technifutur.programmation.models.dtos.SessionAllDataDTO;
import be.technifutur.programmation.models.dtos.SessionDTO;
import be.technifutur.programmation.models.forms.SessionForm;
import java.util.List;

public interface SessionService {
    List<SessionDTO> getAll();
    SessionDTO getOne(Long id);
    SessionDTO insert(SessionForm form);
    SessionDTO delete(Long id);
    SessionDTO update(Long id, SessionForm form);
    SessionAllDataDTO getSessionAllData(SessionForm sessionAllDataForm);
}
