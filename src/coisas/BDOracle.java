package coisas;


import dbconfigs.DBRun;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class BDOracle {
    public static void main(String[] args) {
        DBRun run = new DBRun();
        run.roda();
    }     
}
