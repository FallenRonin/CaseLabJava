package by.PoltavetsAV.dto;

import lombok.Data;

import java.util.Date;

@Data
public class FileDTO {
    private String text;
    private String title;
    private String description;
    private Date creation_date;
}

