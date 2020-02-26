package com.practica.cajero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage =(Stage) FXMLLoader.load(getClass().getResource("/fxml/inicio1.fxml"));
        stage.show();

    }
    public void inicio1(){
        try{
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/inicio1.fxml"));
            op.show();
        }catch (Exception e){
            System.out.println("Error al entrar en el menu");
        }
    }

    public void menu2(){
        try{
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/menu2.fxml"));
            op.show();
        }catch (Exception e){
            System.out.println("Error al entrar en el menu");
        }
    }

    public void menuCredito2(){
        try{
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/menuCredito2.fxml"));
            op.show();
        }catch (Exception e){
            System.out.println("Error al entrar en el menu");
        }
    }

    public void consultarSaldo3(){
        try{
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/consultarSaldo3.fxml"));
            op.show();
        }catch (Exception e){
            System.out.println("Error al entrar en el menu");
        }
    }

    public void retiro4(){
        try{
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/retiro4.fxml"));
            op.show();
        }catch (Exception e){
            System.out.println("Error al entrar en el menu");
        }
    }

    public void procesoRealizado4(){
        try{
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/procesoRealizado4.fxml"));
            op.show();
        }catch (Exception e){
            System.out.println("Error al entrar en el menu");
        }
    }

    public void procesoRechazado5(){
        try{
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/procesoRechazado5.fxml"));
            op.show();
        }catch (Exception e){
            System.out.println("Error al entrar en el menu");
        }
    }

    public void cambioDeNip6(){
        try{
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/cambioDeNip6.fxml"));
            op.show();
        }catch (Exception e){
            System.out.println("Error al entrar en el menu");
        }
    }

    public void pagoDeServicios7(){
        try{
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/pagoDeServicios7.fxml"));
            op.show();
        }catch (Exception e){
            System.out.println("Error al entrar en el menu");
        }
    }

    public void pagarServicio8(){
        try{
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/pagarServicio8.fxml"));
            op.show();
        }catch (Exception e){
            System.out.println("Error al entrar en el menu");
        }
    }

    public void transferencia9(){
        try{
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/transferencia9.fxml"));
            op.show();
        }catch (Exception e){
            System.out.println("Error al entrar en el menu");
        }
    }

    public void transferenciaNumeroCuenta9(){
        try{
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/transferenciaNumeroCuenta9.fxml"));
            op.show();
        }catch (Exception e){
            System.out.println("Error al entrar en el menu");
        }
    }



}
