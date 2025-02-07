package by.PoltavetsAV.service;


import by.PoltavetsAV.dto.FileDTO;
import by.PoltavetsAV.entity.File;
import by.PoltavetsAV.repository.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

    public File create(FileDTO dto) {
        File file = File.builder()
                .text(dto.getText())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .creation_date(dto.getCreation_date())
                .build();
        return fileRepository.save(file);
    }

    public List<File> readAll() {
        return fileRepository.findAll();
    }

    public File readByID(Long id) {
        return fileRepository.findById(id).orElse(null);
    }

    public boolean delete(Long id) {
        if (fileRepository.existsById(id)) {
            fileRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
