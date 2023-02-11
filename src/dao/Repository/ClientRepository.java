package dao.Repository;

import dao.Entity.Client;
import dao.db.MapTable;
import dao.db.MysqlConnection;

import java.sql.*;

public class ClientRepository {
    private Connection  connection;
    public static final String table = "client";

    public ClientRepository(){
        this.connection = new MysqlConnection().getConnection();
    }

    public Client get(Long codeClient) throws SQLException {
        String query = "SELECT * FROM "+table+ " WHERE code_client = ?";
        Client client = new Client();
        PreparedStatement statement = this.connection.prepareStatement(query);
        statement.setLong(1, codeClient);
        ResultSet rs = statement.executeQuery();
        client = MapTable.mapClient(rs);
        return client;
    }

    public Client save (Client client) throws SQLException {
        return client.getCode() > 0 ? update(client) : add(client);
    }

    public Client add(Client client) throws SQLException{
        String query = "INSERT INTO " +table+" VALUES (?,?,?,?)";
        PreparedStatement statement = this.connection.prepareStatement(query);
        statement.setLong(1, 0);
        statement.setString(2, client.getName());
        statement.setString(3, client.getFirstName());
        statement.setString(4, client.getTelephone());
        client.setCode(this.getMaxCode());
        return client;
    }

    public Client update(Client client) throws SQLException{
        String query = "UPDATE "+table+" SET name_client=?, first_name_client =?, telephone_client=? WHERE code_client=?";
        PreparedStatement statement = this.connection.prepareStatement(query);
        statement.setString(1,client.getName());
        statement.setString(2,client.getFirstName());
        statement.setString(3,client.getTelephone());
        statement.setLong(4, client.getCode());
        return client;
    }

    private Long getMaxCode() throws SQLException{
        String query = "SELECT max(code_client) as codeMax FROM "+table;
        Statement statement = this.connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        rs.next();
        return  rs.getLong("codeMax");
    }

    public boolean delete(Long codeClient) throws SQLException{
        String query = "DELETE FROM "+table+" WHERE code_client=?";
        PreparedStatement statement = this.connection.prepareStatement(query);
        statement.setLong(1, codeClient);
        return statement.execute();
    }

    public boolean delete(Client client) throws SQLException {
        return this.delete(client.getCode());
    }

}
