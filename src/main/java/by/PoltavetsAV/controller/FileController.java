package by.PoltavetsAV.controller;

import by.PoltavetsAV.dto.FileDTO;
import by.PoltavetsAV.entity.File;
import by.PoltavetsAV.service.FileService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody FileDTO dto) {
        return new ResponseEntity<>(fileService.create(dto).getId(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<File>> readAll() {
        return new ResponseEntity<>(fileService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<File> readByID(@PathVariable Long id) {
        File file = fileService.readByID(id);
        if (file == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(fileService.readByID(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<File> update(@RequestBody File file) {
        return new ResponseEntity<>(fileService.update(file), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        return HttpStatus.OK;
    }
}
