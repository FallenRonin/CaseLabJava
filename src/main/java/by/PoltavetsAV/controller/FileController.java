package by.PoltavetsAV.controller;

import by.PoltavetsAV.dto.FileDTO;
import by.PoltavetsAV.entity.File;
import by.PoltavetsAV.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/files")
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

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        fileService.delete(id);
        return HttpStatus.OK;
    }
}
