package dao.db;

import dao.Entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class MapTable {
    public static Client mapClient(ResultSet rs) throws SQLException {
        Client client = new Client();
        client.setCode(rs.getLong("code_client"));
        client.setName(rs.getString("name_client"));
        client.setTelephone(rs.getString("telephone_client"));
        client.setFirstName(rs.getString("first_name_client"));
        return client;
    }

    public static Command mapCommand(ResultSet rs) throws SQLException{
        Command cmd = new  Command();
        cmd.setDate(rs.getDate("date_command"));
        return cmd;
    }

    public static Image mapImage(ResultSet rs) throws SQLException{
        Image image = new Image();
        image.setCode(rs.getLong("code_img"));
        image.setPath(rs.getString("path_img"));
        image.setIsPrincipal(rs.getBoolean("is_principal"));
        return image;
    }
    public static HashMap<Product, Integer> mapHash(ResultSet rs, HashMap<Product, Integer> productHashMap) throws SQLException{
        productHashMap.put(mapProduct(rs),rs.getInt("nombre"));
        return productHashMap;
    }

    public static Product mapProduct(ResultSet rs) throws SQLException{
        Product product = new Product();
        product.setName(rs.getString("name_product"));
        product.setDescription(rs.getString("description_product"));
        product.setCode(rs.getLong("code_product"));
        return product;
    }

    public static Price mapPrice(ResultSet rs) throws SQLException{
        Price price = new Price();
        price.setCode(rs.getLong("code_price"));
        price.setDate(rs.getDate("date_price"));
        price.setValue(rs.getFloat("value_price"));
        return price;
    }

    public static Livraison mapLivraison(ResultSet rs) throws SQLException{
        Livraison livraison = new Livraison();
        livraison.setCode(rs.getLong("code_livraison"));
        livraison.setDate(rs.getDate("date_livraison"));
        livraison.setLieu(rs.getString("lieu_livraison"));
        livraison.setFrait(rs.getFloat("frait_livraison"));
        return livraison;
    }

    public static Employ mapEmploy(ResultSet rs) throws SQLException{
        Employ employ = new Employ();
        employ.setCode(rs.getLong("code_employ"));
        employ.setCin(rs.getString("cin_employ"));
        employ.setName(rs.getString("name_employ"));
        employ.setFirstName(rs.getString("first_name_employ"));
        employ.setImage(rs.getString("image_employ"));
        employ.setTelephone(rs.getString("telephone_employ"));
        employ.setPassword(rs.getString("password_cais"));
        employ.setTypeEmploy(EmployType.CAISSIER.getEmployType(rs.getString("type_employ")));
        return employ;
    }
}
