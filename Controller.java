package com.practica.cajero;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    /////////////////////////////CLASES INSTANCIADAS
    CargarArchivos cargarArchivos = new CargarArchivos();
    App app = new App();
    /////////////////////////////////////////////////

    /////////////////////////ARRAYLIST UTILIZADOS
    ArrayList<Usuarios> usuarios = new ArrayList<>();
    ArrayList<Servicios> servicios = new ArrayList<>();
    /////////////////////////////////////////////////

    ////////////////////////////INICIO 1
    @FXML TextField nip,numeroTarjeta;
    /////////////////////////////////////////////////

    //////////////////////////MENU 2
    @FXML Button consultarSaldoCerrar,retiroCerrarMenu,volverCerrar,transferenciaCerrar;
    @FXML Label olaaaa;
    ////////////////////////////////////////////////

    ////////////////////////CONSULTAR SALDO 3
    @FXML TextField mostrarSaldoDisponible;
    @FXML Button retiroCerrarConsulta,menuCerrarConsultaSaldo;
    ////////////////////////////////////////////////

    ////////////////////CONSULTAR RETIRO 4
    @FXML TextField mostrarMonto;
    @FXML Label ocultarMontoRetiro;
    @FXML Button retiroCerrar,volverMenuRetiroCerrar;
    ///////////////////////////////////////////

    ////////////PROCESO RECHAZADO 5
    @FXML Button continuarCerrar;
    ///////////////////////////////////////

    //////////CAMBIO DE NIP 6
    @FXML Button cambioDeNipMenuCerrar,volverMenuNipCerrar,validarCerrar;
    @FXML TextField miNip,nuevoNip,confirmarNip;
    /////////////////////////////////

    /////////////PAGO DE SERVICIOS 7
    @FXML Button pagoDeServiciosMenuCerrar,volverMenuPagoDeServiciosCerrar,pagoDeServiciosCerrar;
    ////////////////////////////////

    ////////////PAGO DE SERVICIOS 8
    @FXML Button volverMenuPagarServicioCerrar,pagoCerrar;
    @FXML TextField codigoDeBarras;
    /////////////////////////

    /////////TRANSFERENCIA 9
    @FXML TextField transferenciaMonto;
    @FXML Button transferirCerrar;
    ///////////////////////////

    ///////TRANSFERENCIA NUMERO CUENTA 9
    @FXML Button volverMenuTransferenciaCerrar,continuarNumeroDeCuentaCerrar;
    @FXML TextField numeroDeCuenta;
    ////////////////

    //////////////////////VARIABLES
    static String cuenta="",cuentaTransferir="";
    static String tipoDeTarjeta="";
    ////////////////////////////////

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void nip(){
        try{
             if(nip.getText().length() == 4){
                usuarios = cargarArchivos.usuarios();
                 for(int i = 0; i < usuarios.size(); i ++){
                    try{
                        if(nip.getText().equals(usuarios.get(i).getNip()) && numeroTarjeta.getText().equals(usuarios.get(i).getNumeroTarjeta())&&usuarios.get(i).getTipoTarjeta().equals("Debito")) {
                            cuenta = usuarios.get(i).getNumeroTarjeta();
                            System.out.println("Cuenta: " + cuenta);
                            app.menu2();
                            Stage stage = (Stage) this.nip.getScene().getWindow();
                            stage.close();
                            tipoDeTarjeta = usuarios.get(i).getTipoTarjeta();
                        }else if(nip.getText().equals(usuarios.get(i).getNip()) && numeroTarjeta.getText().equals(usuarios.get(i).getNumeroTarjeta())&&usuarios.get(i).getTipoTarjeta().equals("Credito")){
                            cuenta = usuarios.get(i).getNumeroTarjeta();
                            System.out.println("Cuenta: " + cuenta);
                            app.menuCredito2();
                            Stage stage = (Stage) this.nip.getScene().getWindow();
                            stage.close();
                            tipoDeTarjeta = usuarios.get(i).getTipoTarjeta();
                        }
                     }catch (Exception e){
                        System.out.println("error");
                    }
                 }
             }
        }catch (Exception e){
        }
    }

    public void consultarSaldo() throws IOException {
        usuarios = cargarArchivos.usuarios();
        app.consultarSaldo3();
        Stage stage = (Stage)this.consultarSaldoCerrar.getScene().getWindow();
        stage.close();
    }

    public void mostrarSaldoTextField() throws IOException {
        usuarios = cargarArchivos.usuarios();
        try{
            for(int i = 0; i< usuarios.size();i++){
                if(cuenta.equals(usuarios.get(i).getNumeroTarjeta())){
                    mostrarSaldoDisponible.setText(usuarios.get(i).getSaldo());
                }
            }
        }catch (Exception e){
        }
    }

    public void retiro(){
        app.retiro4();
        Stage stage = (Stage)this.retiroCerrarConsulta.getScene().getWindow();
        stage.close();
    }

    public void retiroMenu(){
        app.retiro4();
        Stage stage = (Stage)this.retiroCerrarMenu.getScene().getWindow();
        stage.close();
    }

    //Botones para mostrar los valores en el label de retiro
    public void mostrar100(){
        mostrarMonto.setText("100");
         
    }
    public void mostrar200(){
        mostrarMonto.setText("200");
         
    }
    public void mostrar300(){
        mostrarMonto.setText("300");
         
    }
    public void mostrar400(){
        mostrarMonto.setText("400");
         
    }
    public void mostrar500() {
        mostrarMonto.setText("500");
         
    }
    
    public void otroValorRetiro(){
        mostrarMonto.setText("");
        mostrarMonto.setEditable(true);
        mostrarMonto.setDisable(false);
    }
    public void plantilla(){
        this.numeroTarjeta.setText("1111111111111111");
    }
    public void plantillaD(){
        this.numeroTarjeta.setText("2111111111111111");
    }
    //Boton para retirar lo que tenga el label
    public void retirar() throws IOException {

        mostrarMonto.setEditable(false);
        mostrarMonto.setDisable(false);
        double monto=0,nuevoMonto=0,getSaldo=0;
        usuarios = cargarArchivos.usuarios();
        try{
            monto = Double.parseDouble(mostrarMonto.getText());
            System.out.println(monto);
            System.out.println(usuarios.size());
            for(int i = 0; i < usuarios.size(); i ++){
                getSaldo=validarSaldo(i,usuarios.get(i).getSaldo());
                //System.out.println("[220] "+cuenta+" & "+usuarios.get(i).getNumeroTarjeta());
                if(cuenta.equals(usuarios.get(i).getNumeroTarjeta())){

                   System.out.println("[223] "+usuarios.get(i).getSaldo());
                    if(monto < getSaldo){
                        usuarios.get(i).setSaldo(String.valueOf("$"+(getSaldo-monto)));
                        System.out.println("[226] "+usuarios.get(i).getSaldo());
                        escribir(usuarios);
                        app.procesoRealizado4();
                        Stage stage = (Stage)this.retiroCerrar.getScene().getWindow();
                        stage.close();
                     }else{
                        app.procesoRechazado5();
                        Stage stage = (Stage)this.retiroCerrar.getScene().getWindow();
                        stage.close();
                    }
                }
            }
        }catch (Exception e){
            System.out.println("Oh oh "+e);
        }
        mostrarMonto.setText("");
    }

    public void cambioDeNip(){
        app.cambioDeNip6();
        Stage stage = (Stage)this.cambioDeNipMenuCerrar.getScene().getWindow();
        stage.close();
    }

    //Volver y condicionar para ver a que menu volver, si es de debito o credito
    public void volverMenu(){
        if(tipoDeTarjeta.equals("Debito")){
            app.menu2();
        }else{
            app.menuCredito2();
        }
        Stage stage = (Stage)this.menuCerrarConsultaSaldo.getScene().getWindow();
        stage.close();
    }

    public void volverMenuRetiro(){
        if(tipoDeTarjeta.equals("Debito")){
            app.menu2();
        }else{
            app.menuCredito2();
        }
        Stage stage = (Stage)this.volverMenuRetiroCerrar.getScene().getWindow();
        stage.close();
    }

    public void continuarCerrar(){
        app.retiro4();
        Stage stage = (Stage)this.continuarCerrar.getScene().getWindow();
        stage.close();
    }

    public void validar() throws IOException {
        usuarios = cargarArchivos.usuarios();
        for(int i = 0; i < usuarios.size(); i ++){

            if(cuenta.equals(usuarios.get(i).getNumeroTarjeta())){

                if(miNip.getText().equals(usuarios.get(i).getNip())){

                    System.out.println("[3] "+miNip+" & "+nuevoNip.getText());
                    if(!miNip.getText().equals(nuevoNip.getText())){

                        System.out.println("[4] "+nuevoNip.getText()+" & "+confirmarNip.getText());
                        if(nuevoNip.getText().equals(confirmarNip.getText())){
                            usuarios.get(i).setNip(nuevoNip.getText());
                            escribir(usuarios);
                            app.procesoRealizado4();
                            Stage stage = (Stage)this.validarCerrar.getScene().getWindow();
                            stage.close();
                        }else{
                            app.procesoRealizado4();
                            Stage stage = (Stage)this.validarCerrar.getScene().getWindow();
                            stage.close();
                        //    JOptionPane.showMessageDialog(null,"Error al modificar NIP","Modificar NIP",JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        app.procesoRealizado4();
                        Stage stage = (Stage)this.validarCerrar.getScene().getWindow();
                        stage.close();
                      //  JOptionPane.showMessageDialog(null,"Error al modificar NIP","Modificar NIP",JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    app.procesoRealizado4();
                    Stage stage = (Stage)this.validarCerrar.getScene().getWindow();
                    stage.close();
                    //JOptionPane.showMessageDialog(null,"Error al modificar NIP","Modificar NIP",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void volverMenuNip(){
        if(tipoDeTarjeta.equals("Debito")){
            app.menu2();
        }else{
            app.menuCredito2();
        }
        Stage stage = (Stage)this.volverMenuNipCerrar.getScene().getWindow();
        stage.close();
    }

    public void pagoDeServiciosMenu(){
        app.pagoDeServicios7();
        Stage stage = (Stage)this.pagoDeServiciosMenuCerrar.getScene().getWindow();
        stage.close();
    }

    public void volverMenuPagoDeServicios(){
        if(tipoDeTarjeta.equals("Debito")){
            app.menu2();
        }else{
            app.menuCredito2();
        }
        Stage stage = (Stage)this.volverMenuPagoDeServiciosCerrar.getScene().getWindow();
        stage.close();
    }

    public void volverMenuPagarServicio(){
        if(tipoDeTarjeta.equals("Debito")){
            app.menu2();
        }else{
            app.menuCredito2();
        }
        Stage stage = (Stage)this.volverMenuPagarServicioCerrar.getScene().getWindow();
        stage.close();
    }

    public void pagoDeServicios(){
        app.pagarServicio8();
        Stage stage = (Stage)this.pagoDeServiciosCerrar.getScene().getWindow();
        stage.close();
    }
    public double validarSaldo(int i, String usuariosGetSaldo) {
        double getSaldo=0;
        if(usuariosGetSaldo.substring(0,1).equals("$")){
            getSaldo=Double.parseDouble(usuariosGetSaldo.substring(1,usuariosGetSaldo.length()));
        } else {
            getSaldo=Double.parseDouble(usuariosGetSaldo.substring(0,usuariosGetSaldo.length()));
        }
        return getSaldo;
    }
    public void pago() throws IOException {
        double getSaldo=0;
        usuarios = cargarArchivos.usuarios();
        servicios = cargarArchivos.servicios();
        for(int i = 0; i < usuarios.size(); i++){

            if(cuenta.equals(usuarios.get(i).getNumeroTarjeta())){
                System.out.print("[351] "+cuenta+" & "+usuarios.get(i).getNumeroTarjeta()+" & "+usuarios.get(i).getSaldo());
                getSaldo=validarSaldo(i,usuarios.get(i).getSaldo());
                System.out.println(" & "+getSaldo);
                for(int j = 0; j < servicios.size(); j++){
                    if(servicios.get(j).getFolio().equals(codigoDeBarras.getText())){
                        System.out.println("[355] "+getSaldo+" & "+Double.parseDouble(servicios.get(j).getMontoAPagar()));
                        if(getSaldo > Double.parseDouble(servicios.get(j).getMontoAPagar())){
                            usuarios.get(i).setSaldo(String.valueOf("$"+(getSaldo-Double.parseDouble(servicios.get(j).getMontoAPagar()))));
                            escribir(usuarios);
                            app.procesoRealizado4();
                            Stage stage = (Stage)this.pagoCerrar.getScene().getWindow();
                            stage.close();
                        }else{
                            JOptionPane.showMessageDialog(null,"Saldo insuficiente","Pago de servicios",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        }
    }

    public void transferencia(){
        app.transferenciaNumeroCuenta9();
        Stage stage = (Stage)this.transferenciaCerrar.getScene().getWindow();
        stage.close();
    }

    public void volverMenuTransferencia(){
        app.menu2();
        Stage stage = (Stage)this.volverMenuTransferenciaCerrar.getScene().getWindow();
        stage.close();
    }

    public void continuarNumeroDeCuenta() throws IOException {
        usuarios = cargarArchivos.usuarios();
        for(int i = 0; i < usuarios.size(); i++) {
            System.out.println("[399] " + numeroDeCuenta.getText() + " & " + cuenta);
            System.out.println("[399] " + usuarios.get(i).getTipoTarjeta());
            System.out.println("[] "+usuarios.get(i).getNumeroTarjeta());
            if(!numeroDeCuenta.getText().equals(cuenta) && !usuarios.get(i).getTipoTarjeta().equals("Credito") && numeroDeCuenta.getText().equals(usuarios.get(i).getNumeroTarjeta())){
                System.out.println("[AQUI CARNAL] "+numeroDeCuenta.getText()+" & "+usuarios.get(i).getTipoTarjeta());
                cuentaTransferir=numeroDeCuenta.getText();
                app.transferencia9();
                Stage stage = (Stage)this.continuarNumeroDeCuentaCerrar.getScene().getWindow();
                stage.close();
            }
        }
    }

    public void transferir() throws IOException {

        mostrarMonto.setEditable(false);
        mostrarMonto.setDisable(false);;
        usuarios = cargarArchivos.usuarios();
        boolean entro=false;
        double getSaldo;
        for(int i = 0; i < usuarios.size(); i++){
            if(cuenta.equals(usuarios.get(i).getNumeroTarjeta())) {
                getSaldo=validarSaldo(i,usuarios.get(i).getSaldo());
                if (getSaldo > Double.parseDouble(mostrarMonto.getText())) {
                    usuarios.get(i).setSaldo(String.valueOf(getSaldo - Double.parseDouble(mostrarMonto.getText())));
                    entro=true;
                }else{
                    JOptionPane.showMessageDialog(null,"Saldo insuficiente","Transferencia",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        for(int i = 0; i < usuarios.size(); i++){
            if(cuentaTransferir.equals(usuarios.get(i).getNumeroTarjeta())){
                if(entro == true){
                    getSaldo=validarSaldo(i,usuarios.get(i).getSaldo());
                    usuarios.get(i).setSaldo(String.valueOf(getSaldo+Double.parseDouble(mostrarMonto.getText())));
                    app.procesoRealizado4();
                    Stage stage = (Stage)this.transferirCerrar.getScene().getWindow();
                    stage.close();
                    escribir(usuarios);
                }
            }
        }
        mostrarMonto.setText("");

    }

    public void volver(){
        app.inicio1();
        Stage stage = (Stage)this.volverCerrar.getScene().getWindow();
        stage.close();

    }
    //Metodo para escribir sobre el txt usuarios
    public void escribir(ArrayList<Usuarios> usuarios) throws IOException {
        for(int i = 0; i < usuarios.size();i++){
            System.out.println("LISTAS: "+usuarios.get(i).getTipoTarjeta());
        }
        BufferedWriter bf = new BufferedWriter(new FileWriter("/home/loperena/Documentos/Cajero/src/main/resources/texto/usuarios.txt"));
        for(int i = 0; i < usuarios.size();i++){
            bf.write(usuarios.get(i).getNumeroTarjeta()+"#"+usuarios.get(i).getNip()+"$"+usuarios.get(i).getSaldo()+"&"+usuarios.get(i).getTipoTarjeta()+"\n");
        }
        bf.close();
    }

}
