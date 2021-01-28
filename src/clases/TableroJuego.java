/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author Omar
 */
public class TableroJuego extends JPanel {
    
    
    Pelota pelota = new Pelota(0,0);
    Raqueta r1 = new Raqueta(10,200);
    Raqueta r2 = new Raqueta(794-10-Raqueta.ANCHO,200); // esto se hace, porque esta raqueta ira del lado izquierdo
    
    //constructor
    public TableroJuego(){
        setBackground(Color.BLACK);
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.WHITE);   
     //   g2.fill(new Rectangle2D.Double(0,0,20,20));  //creando la pelota
        
        dibujar(g2);
        actualizar();
    }
    
    
    //este se usara para dibujar la raquetaa y pelota
    public void dibujar(Graphics2D g){
        
        g.fill(pelota.getPelota());
        
        
        g.fill(r1.getRaqueta());
                g.fill(r2.getRaqueta());

        
    }
    
    
    //este se encargara de actualizar el estado de la pelota y las raquetas
    public void actualizar(){
        
        pelota.mover(getBounds(),colision(r1.getRaqueta()),colision(r2.getRaqueta()));   //getBounds para mandar el tamaño de nuestra lamina
        r1.moverR1(getBounds()); 
        r2.moverR2(getBounds()); 
        
    }
    
    
    
    private boolean colision(Rectangle2D r){
        return pelota.getPelota().intersects(r);   //verifica si un choque entre ellos
        
    }
    
    
    
  
    
}
