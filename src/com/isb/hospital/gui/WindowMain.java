/**
 *
 * @author Irving Salvador
 */
package com.isb.hospital.gui;


import com.isb.hospital.controller.ControllerHospital;
import com.isb.hospital.gui.components.TableAdapterPaciente;
import com.isb.hospital.model.Ticket;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class WindowMain extends Application{
    
    Ticket t;
    ControllerHospital ce = new ControllerHospital();
    ControllerHospital ca = new ControllerHospital();
    
    Stage window;
    Scene scene;
    
    @FXML TextField txtNombre;
    @FXML TextField txtPadecimiento;
    @FXML TextField txtNSS;
    @FXML ComboBox<String> cmbPrioridad;
    @FXML Button btnAgregarPaciente;
    @FXML Button btnAtenderPaciente;
    @FXML TextField txtPacientesEspera;
    @FXML TextField txtPacientesAtendidos;
    @FXML TextField txtTotalidadPacientes;
    @FXML Button btnLimpiar;
    
    @FXML ListView lsvEspera;
    @FXML ListView lsvAtendidos;
     
    FXMLLoader fxmll;
    ControllerHospital chos;
    
    ObservableList<String> prioridad = FXCollections.observableArrayList("Urgente", "Próximo", "Severo");
    //ObservableList<String> pacientes = FXCollections.observableArrayList("Severo", "Próximo", "Urgente");
    public WindowMain(){
        super();
        fxmll = new FXMLLoader(System.class.getResource("/com/isb/hospital/gui/fxml/panel_hospital.fxml"));
        fxmll.setController(this);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        window = primaryStage;
        fxmll.load();
        scene = new Scene(fxmll.getRoot());
        window.setScene(scene);
        window.show();
        cmbPrioridad.setItems(prioridad);
        addListeners();
    }
    
      public void addListeners(){
        
        btnAgregarPaciente.setOnAction(evt -> {insert();});
        btnAtenderPaciente.setOnAction(evt -> {update();});
        btnLimpiar.setOnAction(evt -> {clear();});
        
    }
    
    public void insert(){
        t = new Ticket();
        
        t.setNombre(txtNombre.getText());
        t.setNSS(txtNSS.getText());
        t.setPadecimiento(txtPadecimiento.getText());
        t.setPrio(cmbPrioridad.getSelectionModel().getSelectedIndex()+1);
        lsvEspera.getItems().add(
        "Nombre: "+t.getNombre()+"\nNSS: "+t.getNSS()+"\nPrioridad: "+t.getPrio()+" \nPadecimiento: "+t.getPadecimiento());
        
        ce.añadir(t);
        
        txtPacientesEspera.setText(String.valueOf(ce.size()));
        txtTotalidadPacientes.setText(String.valueOf(ce.size() + ca.size()));
         
    }
    public void clear(){
        txtNombre.setText(null);
        txtNSS.setText(null);
        txtPadecimiento.setText(null);
        cmbPrioridad.getSelectionModel().clearSelection();
    }
    public void update(){
        t = new Ticket();
        if(ce.size()>0){
            t = ce.eliminarTicket();
            lsvEspera.getItems().remove(t);
            
            lsvAtendidos.getItems().add(
            "Nombre: "+t.getNombre()+"\nNSS: "+t.getNSS()+"\nPrioridad: "+t.getPrio()+" \nPadecimiento: "+t.getPadecimiento());
            
            ca.añadir(t);
            
            txtPacientesEspera.setText(String.valueOf(ce.size()));
            txtPacientesAtendidos.setText(String.valueOf(ca.size()));
            txtTotalidadPacientes.setText(String.valueOf(ce.size() + ca.size()));
            
        }
    }
    
}
