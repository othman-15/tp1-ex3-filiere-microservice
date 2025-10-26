package ma.angu.filieremicroservice.services;

import lombok.AllArgsConstructor;
import ma.angu.filieremicroservice.dtos.RequestFiliereDto;
import ma.angu.filieremicroservice.dtos.ResponseFiliereDto;
import ma.angu.filieremicroservice.entities.Filiere;
import ma.angu.filieremicroservice.mapper.FiliereMapper;
import ma.angu.filieremicroservice.repository.FiliereRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class FiliereServiceImpl implements FiliereService {
    private FiliereRepository filiereRepository;
    private FiliereMapper filiereMapper;


    @Override
    public ResponseFiliereDto addFiliere(RequestFiliereDto RequestFiliereDto) {
        Filiere filiere = filiereMapper.Dto_to_entity(RequestFiliereDto);
        Filiere saved_filiere = filiereRepository.save(filiere);

        return filiereMapper.entity_to_Dto(saved_filiere);
    }

    @Override
    public ResponseFiliereDto getFiliereById(Long id) {

        return filiereMapper.entity_to_Dto(filiereRepository.findById(id).orElseThrow());
    }

    @Override
    public List<ResponseFiliereDto> getAllFilieres() {
        List<Filiere> all = filiereRepository.findAll();
        List<ResponseFiliereDto> ListresponseFiliereDtos = new ArrayList<>();
        for (Filiere filiere : all) {

            ListresponseFiliereDtos.add(filiereMapper.entity_to_Dto(filiere));
        }

        return ListresponseFiliereDtos;
    }

    @Override
    public ResponseFiliereDto updateFiliere(Long id, RequestFiliereDto RequestFiliereDto) {
        Filiere newFiliere = filiereMapper.Dto_to_entity(RequestFiliereDto);
        Filiere filiere = filiereRepository.findById(id).orElseThrow();
        if(newFiliere.getCode() !=null)filiere.setCode(newFiliere.getCode());
        if(newFiliere.getLibelle() !=null)filiere.setLibelle(newFiliere.getLibelle());
        Filiere saved_filiere = filiereRepository.save(filiere);

        return filiereMapper.entity_to_Dto(saved_filiere);
    }



    @Override
    public void deleteFiliere(Long id) {
        filiereRepository.deleteById(id);

    }
}
