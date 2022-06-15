package be.technifutur.user.configs.feign;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import be.technifutur.sharedclass.programmation.models.dtos.SessionAllDataDTO;
import be.technifutur.sharedclass.programmation.models.forms.SessionForm;

@FeignClient(
        name = "programmation-service"
)
public interface SessionFeign {
    @GetMapping("/session")
    public SessionAllDataDTO getSearchSessionUser(@RequestParam UUID ref);
}
