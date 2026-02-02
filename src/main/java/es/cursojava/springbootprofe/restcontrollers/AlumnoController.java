package es.cursojava.springbootprofe.restcontrollers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cursojava.springbootprofe.api.ApiError;
import es.cursojava.springbootprofe.model.StudentDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Alumnos", description = "Endpoints CRUD de alumnos")
@RestController
@RequestMapping("/api/alumnos2")
public class AlumnoController {

    private final Map<Long, StudentDto> alumnos = new HashMap<>();
    private final AtomicLong secuenciaId = new AtomicLong(1);

    @Operation(summary = "Listar alumnos", description = "Devuelve todos los alumnos almacenados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista devuelta correctamente")
    })
    @GetMapping
    public List<StudentDto> listar() {
        return new ArrayList<>(alumnos.values());
    }

    @Operation(summary = "Obtener alumno por id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Alumno encontrado",
                    content = @Content(schema = @Schema(implementation = StudentDto.class))),
            @ApiResponse(responseCode = "404", description = "Alumno no encontrado",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    @GetMapping("/{id}")
    public StudentDto obtener(@PathVariable Long id) {
        StudentDto alumno = alumnos.get(id);
        if (alumno == null) {
            throw new NoSuchElementException("No existe el alumno con id=" + id);
        }
        return alumno;
    }

    @Operation(summary = "Crear alumno")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Alumno creado",
                    content = @Content(schema = @Schema(implementation = StudentDto.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    @PostMapping
    public ResponseEntity<StudentDto> crear(@Valid @RequestBody StudentDto nuevo) {
        long id = secuenciaId.getAndIncrement();
        StudentDto creado = new StudentDto(nuevo.getNombre(), nuevo.getEmail());
        alumnos.put(id, creado);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @Operation(summary = "Actualizar alumno (PUT)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Alumno actualizado",
                    content = @Content(schema = @Schema(implementation = StudentDto.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "Alumno no encontrado",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    @PutMapping("/{id}")
    public StudentDto actualizar(@PathVariable Long id, @Valid @RequestBody StudentDto cambios) {
        StudentDto existente = alumnos.get(id);
        if (existente == null) {
            throw new NoSuchElementException("No existe el alumno con id=" + id);
        }
        existente.setNombre(cambios.getNombre());
        existente.setEdad(cambios.getEdad());
        return existente;
    }

    @Operation(summary = "Borrar alumno")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Alumno borrado correctamente"),
            @ApiResponse(responseCode = "404", description = "Alumno no encontrado",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        if (!alumnos.containsKey(id)) {
            throw new NoSuchElementException("No existe el alumno con id=" + id);
        }
        alumnos.remove(id);
        return ResponseEntity.noContent().build();
    }
}
