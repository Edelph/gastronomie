package dao.Entity;

import lombok.Data;

@Data
public class Image {
    private Long code;
    private String path;
    private Boolean isPrincipal;
}
