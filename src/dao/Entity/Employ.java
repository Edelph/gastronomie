package dao.Entity;
import lombok.Data;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Data
public class Employ {
    private Long code;
    private String name;
    private String firstName;
    private String telephone;
    private String cin;
    private String password;
    private String confirmPassword;
    private String image;
    private EmployType typeEmploy;
}
