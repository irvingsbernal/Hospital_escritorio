/**
 *
 * @author Irving Salvador
 */
package com.isb.hospital.gui.components;

import com.isb.hospital.model.Ticket;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class TableAdapterPaciente {
  
    public static void adapt(TableView<Ticket> tbl){
        
        TableColumn<Ticket, String> tcNombre = new TableColumn <>("Nombre");
        TableColumn<Ticket, String> tcNSS = new TableColumn <>("NSS");
        TableColumn<Ticket, String> tcPadecimiento = new TableColumn <>("Padecimiento");
        TableColumn<Ticket, Integer> tcEstatus = new TableColumn <>("Estatus");
        
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcNSS.setCellValueFactory(new PropertyValueFactory<>("NSS"));
        tcPadecimiento.setCellValueFactory(new PropertyValueFactory<>("padecimiento"));
        tcEstatus.setCellValueFactory(new PropertyValueFactory<>("prio"));
        
        tbl.getColumns().clear();
        
        tbl.getColumns().addAll(tcNombre,
                                tcNSS,
                                tcPadecimiento,
                                tcEstatus);
                
        
    }
}
