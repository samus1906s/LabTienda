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
public abstract class NotificacionCreador {
    
    public abstract NotificacionFactory crearNotificacion();
    
    public void enviarNotificacion(Factura factura) {
        NotificacionFactory notificacion = crearNotificacion();
        notificacion.enviar(factura);
    }
}
