package be.technifutur.programmation.services.impl;

import be.technifutur.programmation.models.dtos.SessionDTO;
import be.technifutur.programmation.models.forms.SessionForm;
import be.technifutur.programmation.models.entities.Session;
import be.technifutur.programmation.models.repositories.SessionRepository;
import be.technifutur.programmation.services.SessionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    private final SessionRepository repository;

    public SessionServiceImpl(SessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SessionDTO> getAll() {
        return repository.findAll().stream().map(SessionDTO::of).toList();
    }

    @Override
    public SessionDTO getOne(Long id) {
        return repository.findById(id).map(SessionDTO::of).orElseThrow();
    }

    @Override
    public SessionDTO insert(SessionForm form) {
        Session toInsert = Session.builder()
    //set value;
                                .build();
        return SessionDTO.of(repository.save(toInsert));
    }

    @Override
    public SessionDTO update(Long id, SessionForm form) {
        Session toUpdate = repository.findById(id).orElseThrow();
    //set value;
        toUpdate = repository.save(toUpdate);
        return SessionDTO.of(toUpdate);
    }

    @Override
    public SessionDTO delete(Long id) {
        Session toDelete = repository.findById(id).orElseThrow();
        repository.delete(toDelete);
        return SessionDTO.of(toDelete);
    }
}