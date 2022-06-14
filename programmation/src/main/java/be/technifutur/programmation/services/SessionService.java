package be.technifutur.programmation.services;

import be.technifutur.programmation.models.dtos.*;
import be.technifutur.programmation.models.forms.*;
import be.technifutur.sharedclass.programmation.models.dtos.Session2CartDTO;

import java.util.List;

public interface SessionService {
    List<SessionDTO> getAll();
    SessionDTO getOne(Long id);
    SessionDTO insert(SessionForm form);
    SessionDTO delete(Long id);
    SessionDTO update(Long id, SessionForm form);
    SessionAllDataDTO getSessionAllData(SessionForm sessionAllDataForm);
    Session2CartDTO addSession2Cart(Session2CartForm session2CartForm);
}
