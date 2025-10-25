/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Notificaciones;

import Facturacion.Factura;
import Notificaciones.Notificacion;
import java.util.ArrayList;
import java.util.List;
import Observer.Observador;

/**
 *
 * @author jprod
 */
public class ServicioNotificaciones implements Observador {
    private int seq = 1;
    private final List<Notificacion> historial;

    /**
     * Iterator
     * @return 
     */
    public List<Notificacion> getHistorial(){ return historial; }

    public ServicioNotificaciones() {
        historial = new ArrayList<>();
    }

    /**
     * Simulación de envío por canal
     * @param factura
     * @param canal
     * @return 
     */
    public Notificacion enviar(Factura factura, CanalNotificacion canal){
        Notificacion n = null;
        
        NotificacionCreador crear;
        try {
            switch (canal){
                case EMAIL -> crear = new EmailFactory();
                case SMS -> crear = new SMSFactory();
                case WHATSAPP -> crear = new WhatsAppFactory();
                case PANTALLA -> crear = new PantallaFactory();
            }
            n.setEstado(EstadoNotificacion.ENVIADA);
        } catch (Exception e){
            n.setEstado(EstadoNotificacion.FALLIDA);
        }
        historial.add(n);
        return n;
    }
    
        
      public List<Notificacion> historial(){
        return historial;
    }
   

    @Override
    public void actualizar() {
        System.out.println("Notificación: Se ha actualizado el catálogo de productos o categorías.");
    }

}
