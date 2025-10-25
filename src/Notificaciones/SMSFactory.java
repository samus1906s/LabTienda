/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Notificaciones;

/**
 *
 * @author samue
 */
public class SMSFactory extends NotificacionCreador {
    @Override
    public NotificacionFactory crearNotificacion() {
       return new NotificacionSMS();
    }
}
