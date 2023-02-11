package dao.Entity;

import lombok.Data;

import java.util.Date;

@Data
public class Livraison {
    private Long code;
    private String lieu;
    private Date date;
    private Float frait;
    private Employ livreur;
}
