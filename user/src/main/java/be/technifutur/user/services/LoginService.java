package be.technifutur.user.services;

import be.technifutur.sharedclass.user.models.forms.LoginForm;
import be.technifutur.user.models.dtos.JwtDTO;

public interface LoginService {
    public JwtDTO login(LoginForm form);
}
