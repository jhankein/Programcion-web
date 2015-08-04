/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conecbasedate;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Jhan Kein
 */
public class Validacion {
    
    
      void Sololetras(JTextField a) {

        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {

                char c = e.getKeyChar();
                if (Character.isDigit(c)) {

                    JOptionPane.showMessageDialog(null, "ESTA INGRESANDO DATOS INCORRECTOS PARA ESTE CAMPO");
                    e.consume();
                }
            }

        });
    }
public void Solonumeros(JTextField a){
   
        a.addKeyListener(new KeyAdapter(){
        public void keyTyped(KeyEvent e){
            
        char c=e.getKeyChar();
        if (!Character.isDigit(c)){
            
     JOptionPane.showMessageDialog(null, "ESTAS INGRESANDO DATOS INCORRECTOS PARA ESTE CAMPO");
            e.consume();
        }
        }
        
        });
        
    }
    
}
