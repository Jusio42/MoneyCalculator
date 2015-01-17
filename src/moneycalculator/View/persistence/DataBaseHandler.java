package moneycalculator.View.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DataBaseHandler {

    Connection conexion;
    Statement consulta;
    private static final String ruta = "/Users/Giorgio/Documents/NetBeansProjects/MoneyCalculator/database/MoneyCalculator";

    private void conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:" + ruta);
            consulta = conexion.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void close() {
        try {
            this.conexion.close();
            this.consulta.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet consultar(String sql) {
        conectar();
        ResultSet resultado = null;
        try {
            resultado = consulta.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Mensaje:" + e.getMessage());
            System.out.println("Estado:" + e.getSQLState());
            System.out.println("Codigo del error:" + e.getErrorCode());
            JOptionPane.showMessageDialog(null, "" + e.getMessage());
        }
        return resultado;
    }
}