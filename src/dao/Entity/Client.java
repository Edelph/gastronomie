package dao.Entity;
import lombok.Data;

@Data
public class Client {
    private Long code;
    private String name;
    private String firstName;
    private String telephone;

    public static Client build() {
        return new Client();
    }
    public static Client set(Long code, String name, String firstName, String telephone) {
        Client client = Client.build();
        client.setCode(code);
        client.setFirstName(firstName);
        client.setName(name);
        client.setTelephone(telephone);
        return client;
    }
}
