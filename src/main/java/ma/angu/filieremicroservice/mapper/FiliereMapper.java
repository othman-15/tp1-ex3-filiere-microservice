package ma.angu.filieremicroservice.mapper;

import ma.angu.filieremicroservice.dtos.RequestFiliereDto;
import ma.angu.filieremicroservice.dtos.ResponseFiliereDto;
import ma.angu.filieremicroservice.entities.Filiere;
import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

@Component
public class FiliereMapper {
    public Filiere Dto_to_entity(RequestFiliereDto requestFiliereDto) {
            Filiere filiere = new Filiere();
            BeanUtils.copyProperties(requestFiliereDto, filiere);
            return filiere;
        }
    public ResponseFiliereDto entity_to_Dto( Filiere filiere) {
         ResponseFiliereDto responseFiliereDto = new ResponseFiliereDto();
        BeanUtils.copyProperties(filiere, responseFiliereDto);
        return responseFiliereDto;
    }


}
