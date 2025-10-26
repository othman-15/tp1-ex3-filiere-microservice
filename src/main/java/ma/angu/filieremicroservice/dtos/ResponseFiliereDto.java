package ma.angu.filieremicroservice.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseFiliereDto {

    private Long idFiliere ;
    private String code ;
    private String libelle ;
}
