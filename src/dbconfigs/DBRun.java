/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconfigs;


import coisas.DBComandos;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 16111019
 */
public class DBRun {
    private Connection conexao;
    private DBComandos db_comandos = new DBComandos();       
    private DBInfo dbinfo = new DBInfo();
   
    
    public void roda(){
        try {
            conexao = DriverManager.getConnection(
                    dbinfo.connectionString,
                    dbinfo.user,
                    dbinfo.password);
            System.out.println("Conectado");
            
            //db_comandos.exempoInsert(conexao);
            db_comandos.exemploSelectTodos(conexao);
            conexao.close();
        } catch (Exception e) {
            System.out.println("Erro");
        }    
    }       
        
}
