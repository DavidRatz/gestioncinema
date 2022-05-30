package be.technifutur.cinema.services;

import be.technifutur.cinema.models.dtos.AddressDTO;
import be.technifutur.cinema.models.forms.AddressForm;
import java.util.List;

public interface AddressService {
    List<AddressDTO> getAll();
    AddressDTO getOne(Long id);
    AddressDTO insert(AddressForm form);
    AddressDTO delete(Long id);
    AddressDTO update(Long id, AddressForm form);
}
