package dao.Entity;

import lombok.Data;

import java.util.Date;

@Data
public class Price {
    private Long code ;
    private Date date;
    private Float value;
}
