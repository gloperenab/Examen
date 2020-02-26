package com.practica.cajero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CargarArchivos {



    public ArrayList<Usuarios> usuarios() throws IOException {
        String ruta;
        ruta ="/home/loperena/Documentos/Cajero/src/main/resources/texto/usuarios.txt";
        ArrayList<Usuarios> usuarios = new ArrayList<>();
        String numeroTarjeta;
        String nip;
        String monto;
        String tipoTarjeta;

        BufferedReader bf = new BufferedReader(new FileReader(ruta));
        String bfRead;
        while((bfRead = bf.readLine())!= null){
            numeroTarjeta = bfRead.substring(bfRead.indexOf(""),bfRead.indexOf("#"));
            nip = bfRead.substring(bfRead.indexOf("#")+1,bfRead.indexOf("$"));
            monto = bfRead.substring(bfRead.indexOf("$")+1,bfRead.indexOf("&"));
            tipoTarjeta = bfRead.substring(bfRead.indexOf("&")+1,bfRead.length());
            usuarios.add(new Usuarios(numeroTarjeta,nip,monto,tipoTarjeta));
        }
        return usuarios;
    }

    public ArrayList<Servicios> servicios() throws IOException {
        String ruta;
        ruta ="/home/loperena/Documentos/Cajero/src/main/resources/texto/servicios.txt";
        ArrayList<Servicios> servicios = new ArrayList<>();
        String folio;
        String montoAPagar;
   ;

        BufferedReader bf = new BufferedReader(new FileReader(ruta));
        String bfRead;
        while((bfRead = bf.readLine())!= null){
            folio = bfRead.substring(bfRead.indexOf(""),bfRead.indexOf("#"));
            montoAPagar = bfRead.substring(bfRead.indexOf("#")+1,bfRead.length());

            servicios.add(new Servicios(folio,montoAPagar));
        }
        return servicios;
    }
}
