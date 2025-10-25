/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Notificaciones;
import Facturacion.Factura;

/**
 *
 * @author samue
 */
 public class NotificacionPantalla implements NotificacionFactory{

    @Override
    public void enviar(Factura factura) {
        System.out.println("[POPUP] Factura #" + factura.getNumero());
    }
    
}
