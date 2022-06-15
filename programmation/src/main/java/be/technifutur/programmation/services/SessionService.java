package be.technifutur.programmation.services;

import be.technifutur.programmation.models.dtos.*;
import be.technifutur.programmation.models.forms.*;
import be.technifutur.sharedclass.programmation.models.dtos.Session2CartDTO;
import be.technifutur.sharedclass.programmation.models.dtos.SessionAllDataDTO;
import be.technifutur.sharedclass.programmation.models.forms.SessionForm;

import java.util.List;
import java.util.UUID;

public interface SessionService {
    List<SessionDTO> getAll();
    SessionDTO getOne(Long id);
    SessionDTO insert(SessionForm form);
    SessionDTO delete(Long id);
    SessionDTO update(Long id, SessionForm form);
    SessionAllDataDTO getSessionAllData(SessionForm sessionAllDataForm);
    Session2CartDTO addSession2Cart(Session2CartForm session2CartForm);
    SessionAllDataDTO getSessionAllData4User(UUID refSession);
}
