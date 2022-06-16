package be.technifutur.film.utils;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

public class FormConverterList {
    public static <T> List<T> convertIdList2EntityList(JpaRepository<T,Long> repo, List<Long> idList) {
        List<T> entities = new ArrayList<>();
        if(idList != null){
            for (Long id : idList) {
                entities.add(repo.findById(id).orElseThrow());
            }
        }
        return entities;
    }
}
