package pkg123210068_responsi;

import java.sql.*;
import javax.swing.JOptionPane;

public class PerpusModel extends Connector {

    public int getTotalData() {
        int totalData = 0;
        try {
            String query = "SELECT * FROM dataperpus";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                totalData++;
            }
            return totalData;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return totalData;
        }

    }

    public String[][] getDataPerpus() {
        String data[][] = new String[getTotalData()][7];
        try {
            int index = 0;
            String query = "SELECT * FROM dataperpus";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                data[index][0] = resultSet.getString("id");
                data[index][1] = resultSet.getString("judul");
                data[index][2] = resultSet.getString("genre");
                data[index][3] = resultSet.getString("penulis");
                data[index][4] = resultSet.getString("penerbit");
                data[index][5] = resultSet.getString("lokasi");
                data[index][6] = resultSet.getString("stock");
                index++;
            }
            return data;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return data;
        }
    }

    public void addDataPerpus(String judul, String genre, String penulis, String penerbit, String lokasi, int stock) {
        try {
            String query = "INSERT INTO `dataperpus` (`judul`,`genre`,`penulis`,`penerbit`,`lokasi`,`stock`) VALUES (?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, judul);
            pstmt.setString(2, genre);
            pstmt.setString(3, penulis);
            pstmt.setString(4, penerbit);
            pstmt.setString(5, lokasi);
            pstmt.setInt(6, stock);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Input Data");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void deleteDataPerpus(String id) {

        try {
            String query = "DELETE FROM `dataperpus` WHERE `id` = '" + id + "'";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Hapus Data");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void updateDataPerpus(String judul, String genre, String penulis, String penerbit, String lokasi, int stock, String id) {
        try {
            String query = "UPDATE `dataperpus` SET "
                    + "`judul` = '" + judul + "',"
                    + "`genre` = '" + genre + "',"
                    + "`penulis` = '" + penulis + "' ,"
                    + "`penerbit` = '" + penerbit + "',"
                    + "`lokasi` = '" + lokasi + "',"
                    + "`stock` = '" + stock + "' "
                    + "WHERE `id` = '" + id + "'";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Update Data");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public int totalDataKategori(String kategori, String search) {
        int totalData = 0;
        try {
            String query = "SELECT * FROM dataperpus WHERE `" + kategori + "` = '" + search + "'";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                totalData++;
            }
            return totalData;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return totalData;
        }
    }

    public String[][] dataKategori(String kategori, String search) {
        String data[][] = new String[totalDataKategori(kategori, search)][7];
        try {
            int index = 0;
            String query = "SELECT * FROM dataperpus WHERE `" + kategori + "` = '" + search + "'";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                data[index][0] = resultSet.getString("id");
                data[index][1] = resultSet.getString("judul");
                data[index][2] = resultSet.getString("genre");
                data[index][3] = resultSet.getString("penulis");
                data[index][4] = resultSet.getString("penerbit");
                data[index][5] = resultSet.getString("lokasi");
                data[index][6] = resultSet.getString("stock");
                index++;
            }
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return data;
        }

    }

}
