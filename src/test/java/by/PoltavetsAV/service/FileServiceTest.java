package by.PoltavetsAV.service;

import by.PoltavetsAV.dto.FileDTO;
import by.PoltavetsAV.repository.FileRepository;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

//@Transactional

class FileServiceTest {

    FileRepository fileRepository;
    FileService fileService;

    @BeforeEach
    void setUp() {
        fileService = new FileService(fileRepository);
    }

    @Test
    void whenCreateNewFileMustReturnSomeID() {
        FileDTO fileDTO = new FileDTO();
        fileDTO.setText("aGVsbG8gd29ybGQh");// Hello world!
        fileDTO.setTitle("Hello world text");
        fileDTO.setDescription("File that contains \"Hello world!\" text");
        fileDTO.setCreation_date(new Date());

        assertNull(fileService.create(fileDTO));
    }

    @Test
    void readAll() {
    }

    @Test
    void readByID() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @AfterEach
    public void close(){
        fileService = null;
    }

}