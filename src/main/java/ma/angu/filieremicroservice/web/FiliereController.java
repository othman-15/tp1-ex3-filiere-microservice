package ma.angu.filieremicroservice.web;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.AllArgsConstructor;
import ma.angu.filieremicroservice.dtos.RequestFiliereDto;
import ma.angu.filieremicroservice.dtos.ResponseFiliereDto;
import ma.angu.filieremicroservice.services.FiliereService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@OpenAPIDefinition(
        info = @Info(
                title = "Gestion des filieres",
                description = "cette offre tous les méthodes pour gérer les filieres",
                version = "1.0.0"
        ),
        servers = @Server(
                url = "http://localhost:8085"
        )
)


@RestController
@RequestMapping("/v1/filieres")
@AllArgsConstructor
public class FiliereController {
    private FiliereService filiereService ;

    @Operation(
            summary = " récuperer liste des filieres",

            responses = {
                    @ApiResponse(responseCode = "200", description = "bien enregiter",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ResponseFiliereDto.class ))
                            )
                    ),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )
    @GetMapping
    public ResponseEntity<List<ResponseFiliereDto>> getAllFiliere() {
        return ResponseEntity.ok(filiereService.getAllFilieres());
    }



    @Operation(
            summary = " récupérer filiere par Id",
            parameters = @Parameter(name = "id", required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien récuperer",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseFiliereDto.class )
                            )
                    ),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<ResponseFiliereDto>  getFiliereById(@PathVariable("id") Long id) {


        return ResponseEntity.ok(filiereService.getFiliereById(id));
    }


    @Operation(
            summary = " Ajouter un filiere",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RequestFiliereDto.class )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien enregiter",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = RequestFiliereDto.class )
                            )
                    ),

                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )
    @PostMapping
    public ResponseEntity<ResponseFiliereDto> createFiliere(@RequestBody RequestFiliereDto requestFiliereDto) {


        return ResponseEntity.ok(filiereService.addFiliere(requestFiliereDto));


    }
    @Operation(
            summary = " Modifier un filiere",
            parameters = @Parameter(name = "id", required = true),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RequestFiliereDto.class )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien modifier",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseFiliereDto.class )
                            )
                    ),

                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<ResponseFiliereDto> updateFiliere(@PathVariable Long id, @RequestBody RequestFiliereDto requestFiliereDto) {


        return ResponseEntity.ok(filiereService.updateFiliere(id,requestFiliereDto));
    }
    @Operation(
            summary = " supprimer compte par Id",
            parameters = @Parameter(name = "id", required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien supprimer"),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )
    @DeleteMapping("{id}")
    public ResponseEntity DeleteFiliere(@PathVariable Long id) {

        filiereService.deleteFiliere(id);
        return ResponseEntity.ok().build();
    }

}
