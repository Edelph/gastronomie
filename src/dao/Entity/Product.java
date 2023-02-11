package dao.Entity;

import lombok.Data;

import java.util.List;

@Data
public class Product {
    private Long code;
    private String name;
    private String description;
    private List<Image> images;
    private List<Price> prices;
}
