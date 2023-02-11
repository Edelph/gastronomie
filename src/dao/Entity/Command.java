package dao.Entity;

import lombok.Data;

import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Data
public class Command {
    private Long code;
    private Date date;
    private Employ caissier;
    private List<HashMap<Product,Integer>> products;
    private Client client;
    private Livraison livraison;

    public static Command built(){
        return new Command();
    }
    public static Command set(Long code, Date date, Employ caissier, List<HashMap<Product,Integer>> products, Client client, Livraison livraison){
        Command command = Command.built();
        command.setCaissier(caissier);
        command.setProducts(products);
        command.setClient(client);
        command.setLivraison(livraison);
        command.setCode(code);
        command.setDate(date);
        return command;
    }
}
