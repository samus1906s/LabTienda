/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facturacion;

import Clientes.Cliente;
import Facturacion.EstadoFactura;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 *
 * @author jprod
 */
public class Factura implements Iterable<ItemFactura> {
    private int numero;
    private Cliente cliente;
    private LocalDateTime fecha;
    private List<ItemFactura> items;
    private EstadoFactura estado;
    

    public int getNumero(){ return numero; }
    public Cliente getCliente(){ return cliente; }
    public LocalDateTime getFecha(){ return fecha; }
    public EstadoFactura getEstado(){ return estado; }
    public void setEstado(EstadoFactura e){ this.estado = e; }

   
    public List<ItemFactura> getItems() {
        return new ArrayList<>(items); 
    }


    public Factura(int numero, Cliente cliente) {
        this.numero = numero; 
        this.cliente = cliente; 
        this.fecha = LocalDateTime.now();
        this.items = new ArrayList<>();
        this.estado = EstadoFactura.PENDIENTE;
    }
    

    public void addItem(ItemFactura item){ 
        items.add(item); 
    }

    public double getSubtotal(){
        double total = 0;

        for (ItemFactura item : this) {
            total += item.getSubtotal();
        }
        return total;
    }
    
    public double getImpuesto(){
        return getSubtotal() * 0.13;
    }

    public double getTotal(){
        return getSubtotal() + getImpuesto();
    }


    @Override
    public Iterator<ItemFactura> iterator() {
        return new Iterator<ItemFactura>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < items.size();
            }

            @Override
            public ItemFactura next() {
                return items.get(index++);
            }
        };
    }


    @Override
    public String toString() {
        return "Factura{" +
                "numero=" + numero +
                ", cliente=" + cliente +
                ", fecha=" + fecha +
                ", items=" + items +
                ", estado=" + estado +
                ", SubTotal=" + getSubtotal() +
                ", Impuesto=" + getImpuesto() +
                ", Total=" + getTotal() +
                '}';
    }

    
}
