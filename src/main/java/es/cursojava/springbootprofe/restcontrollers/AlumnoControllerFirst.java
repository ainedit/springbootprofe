package es.cursojava.springbootprofe.restcontrollers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import es.cursojava.springbootprofe.model.StudentDto;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoControllerFirst {

    private final Map<Long, StudentDto> alumnos = new HashMap<>();
    private final AtomicLong secuenciaId = new AtomicLong(1);

    // GET /api/alumnos
    @GetMapping
    public List<StudentDto> listar() {
        return new ArrayList<>(alumnos.values());
    }

    // GET /api/alumnos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> obtener(@PathVariable Long id) {
    	StudentDto alumno = alumnos.get(id);
        if (alumno == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(alumno);
    }

    // POST /api/alumnos
    @PostMapping
    public ResponseEntity<StudentDto> crear(@RequestBody StudentDto nuevo) {
        long id = secuenciaId.getAndIncrement();
        nuevo.setId(id);
        alumnos.put(id, nuevo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    // PUT /api/alumnos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> actualizar(@PathVariable Long id, @RequestBody StudentDto cambios) {
    	StudentDto existente = alumnos.get(id);
        if (existente == null) return ResponseEntity.notFound().build();

        existente.setNombre(cambios.getNombre());
        existente.setEdad(cambios.getEdad());

        return ResponseEntity.ok(existente);
    }

    // DELETE /api/alumnos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        if (!alumnos.containsKey(id)) return ResponseEntity.notFound().build();
        alumnos.remove(id);
        return ResponseEntity.noContent().build();
    }
}
