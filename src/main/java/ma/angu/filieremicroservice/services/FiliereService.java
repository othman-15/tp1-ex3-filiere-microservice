package ma.angu.filieremicroservice.services;

import ma.angu.filieremicroservice.dtos.RequestFiliereDto;
import ma.angu.filieremicroservice.dtos.ResponseFiliereDto;

import java.util.List;

public interface FiliereService {
    public ResponseFiliereDto addFiliere(RequestFiliereDto RequestFiliereDto);
    public ResponseFiliereDto getFiliereById(Long id);
    public List<ResponseFiliereDto> getAllFilieres();
    public ResponseFiliereDto updateFiliere(Long id,RequestFiliereDto RequestFiliereDto);
    public void deleteFiliere(Long id);
}
