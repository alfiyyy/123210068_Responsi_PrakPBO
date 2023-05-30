/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg123210068_responsi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author PC PRAKTIKUM
 */
public class PerpusController {

    public PerpusController(ViewPerpus viewPerpus, PerpusModel perpusModel) {

//        viewPerpus.getjTextFieldID().setEnabled(false);
        viewPerpus.getjButtonTambah().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String judul = viewPerpus.getjTextFieldJudul().getText();
                    String genre = viewPerpus.getjTextFieldGenre().getText();
                    String penulis = viewPerpus.getjTextFieldPenulis().getText();
                    String penerbit = viewPerpus.getjTextFieldPenerbit().getText();
                    String lokasi = viewPerpus.getjTextFieldLokasi().getText();
                    int stock = Integer.parseInt(viewPerpus.getjTextFieldStock().getText());

                    if (judul.equals("") || genre.equals("") || penulis.equals("") || penerbit.equals("") || lokasi.equals("")) {
                       JOptionPane.showMessageDialog(null, "Harap Isi form dengan lengkap");
                       return;
                    }

                    perpusModel.addDataPerpus(judul, genre, penulis, penerbit, lokasi, stock);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Terdapat Kesalahan Input", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        viewPerpus.getjButtonTampilSemua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data[][];
                data = perpusModel.getDataPerpus();

                viewPerpus.getjTable().setModel(new DefaultTableModel(data, new String[]{
                    "id", "judul", "genre", "penulis", "penerbit", "lokasi", "stock"
                }));

            }
        });

        viewPerpus.getjTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = viewPerpus.getjTable().getSelectedRow();
                String id = viewPerpus.getjTable().getValueAt(row, 0).toString();
                String judul = viewPerpus.getjTable().getValueAt(row, 1).toString();
                String genre = viewPerpus.getjTable().getValueAt(row, 2).toString();
                String penulis = viewPerpus.getjTable().getValueAt(row, 3).toString();
                String penerbit = viewPerpus.getjTable().getValueAt(row, 4).toString();
                String lokasi = viewPerpus.getjTable().getValueAt(row, 5).toString();
                String stock = viewPerpus.getjTable().getValueAt(row, 6).toString();

                viewPerpus.getjTextFieldID().setText(id);
                viewPerpus.getjTextFieldJudul().setText(judul);
                viewPerpus.getjTextFieldGenre().setText(genre);
                viewPerpus.getjTextFieldPenulis().setText(penulis);
                viewPerpus.getjTextFieldPenerbit().setText(penerbit);
                viewPerpus.getjTextFieldLokasi().setText(lokasi);
                viewPerpus.getjTextFieldStock().setText(stock);
            }

        });

        viewPerpus.getjButtonHapus().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = viewPerpus.getjTextFieldID().getText();

                    perpusModel.deleteDataPerpus(id);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());

                }

            }
        });

        viewPerpus.getjButtonUbah().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judul = viewPerpus.getjTextFieldJudul().getText();
                String genre = viewPerpus.getjTextFieldGenre().getText();
                String penulis = viewPerpus.getjTextFieldPenulis().getText();
                String penerbit = viewPerpus.getjTextFieldPenerbit().getText();
                String lokasi = viewPerpus.getjTextFieldLokasi().getText();
                int stock = Integer.parseInt(viewPerpus.getjTextFieldStock().getText());
                String id = viewPerpus.getjTextFieldID().getText();
                
                if (judul.equals("") || genre.equals("") || penulis.equals("") || penerbit.equals("") || lokasi.equals("")) {
                       JOptionPane.showMessageDialog(null, "Harap Isi form dengan lengkap");
                       return;
                    }

                perpusModel.updateDataPerpus(judul, genre, penulis, penerbit, lokasi, stock, id);

            }
        });

        viewPerpus.getjButtonCari().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kategori = viewPerpus.getjComboBox().getSelectedItem().toString();
                String search = viewPerpus.getjTextFieldCari().getText();

                String data[][] = perpusModel.dataKategori(kategori, search);

                viewPerpus.getjTable().setModel(new DefaultTableModel(data, new String[]{
                    "id", "judul", "genre", "penulis", "penerbit", "lokasi", "stock"
                }));

            }
        });

    }

}
