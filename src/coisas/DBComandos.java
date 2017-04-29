package coisas;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 16111019
 */
public class DBComandos {
    public void exempoInsert(Connection conexao) throws SQLException {
        String sql = "INSERT INTO VEICULOS"
        + " (placa, ano, km, marca, modelo)"
        + " VALUES (?, ?, ?, ?, ?)";
        // 1 2 3 4 5 (numeração dos parâmetros)
        PreparedStatement stmt = conexao.prepareStatement(sql);

        // Preenche os valores, respeitando a ordem e o tipo dos dados
        stmt.setString(1, "IAB-5555"); // CHAR(8)
        stmt.setInt(2, 2016); // NUMBER(4)
        stmt.setInt(3, 0); // NUMBER(6)
        stmt.setString(4, "Fiat"); // VARCHAR(50)
        stmt.setString(5, "Palio"); // VARCHAR(50)
        stmt.execute(); // executa o comando SQL
        
        System.out.println("Veículo inserido.");
        
        stmt.close();
        conexao.close();
    }

    public void exemploSelectTodos(Connection conexao) throws SQLException {
            String sql = "SELECT placa, ano, km, marca, modelo"
            + " FROM VEICULOS";
            
        PreparedStatement stmt = conexao.prepareStatement(sql);
        // Executa o comando SELECT
        ResultSet rs = stmt.executeQuery();
        // Itera sobre todos os registros do ResultSet
        while (rs.next()) {
            String placa = rs.getString("placa");
            Integer ano = rs.getInt("ano");
            Integer km = rs.getInt("km");
            String marca = rs.getString("marca");
            String modelo = rs.getString("modelo");
            System.out.println(placa
            + " " + ano
            + " " + km
            + " " + marca
            + " " + modelo
            );
        }

        // Fecha todos os objetos
        rs.close();
        stmt.close();
        conexao.close(); 
    }
    
    public void exemploSelectUmElemento(Connection conexao, String placa) throws SQLException {
        String sql = "SELECT ano, km, marca, modelo"
        + " FROM VEICULOS"
        + " WHERE placa = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, placa);
        
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) { // Se retornou o registro solicitado
            Integer ano = rs.getInt("ano");
            Integer km = rs.getInt("km");
            String marca = rs.getString("marca");
            String modelo = rs.getString("modelo");
            System.out.println(placa
            + " " + ano
            + " " + km
            + " " + marca
            + " " + modelo
            );
        } else {
         System.out.println("Placa não encontrada.");
        }

       rs.close();
       stmt.close();
       conexao.close(); 
    }
}
