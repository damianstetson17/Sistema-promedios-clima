package Vistas;

import java.awt.Font;
import javax.swing.JOptionPane;
import controlador.*;

public class CargarTemperatura extends javax.swing.JFrame {
    private Controlador controlador;
    private float promedio =0;
    private float temp=0;
    private String momento="";
    private int i=0;
    private float Vtemps[]={0,0,0};
    private String Vmomentos[] = {"-","-","-"};
    
    public CargarTemperatura(Controlador controlador) {
        initComponents();
        this.controlador= controlador;
        setVisible (true);
        setTitle("Temperaturas");
        
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel1.setFont(fuente);
        
        cargarcomboMomento();
    }

     private void cargarcomboMomento () {
            try{
                comboMomento.addItem("Mañana");  
                comboMomento.addItem("Tarde"); 
                comboMomento.addItem("Noche"); 
        
            } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage());
        }        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboMomento = new javax.swing.JComboBox<>();
        temperatura = new javax.swing.JTextField();
        BTNCargar = new javax.swing.JButton();
        BTNGenerar = new javax.swing.JButton();
        BTNTerminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Temperatura");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 110, 30));

        comboMomento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMomentoActionPerformed(evt);
            }
        });
        getContentPane().add(comboMomento, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 160, 30));

        temperatura.setText("celcius");
        getContentPane().add(temperatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 70, 30));

        BTNCargar.setText("Cargar ");
        BTNCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNCargarActionPerformed(evt);
            }
        });
        getContentPane().add(BTNCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 110, 60));

        BTNGenerar.setText("Generar Archivo");
        BTNGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNGenerarActionPerformed(evt);
            }
        });
        getContentPane().add(BTNGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 150, 60));

        BTNTerminar.setText("Terminar Dia");
        BTNTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNTerminarActionPerformed(evt);
            }
        });
        getContentPane().add(BTNTerminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 140, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNGenerarActionPerformed
        String TempsDia [][] =new String [3][3];
        
        /*//calcular promedio   
            for( int k=0 ;k<3 ; k++ ){
                promedio+= Vtemps[k];  
            }*/
            
        TempsDia [1][2] =String.valueOf(promedio/3);
        int a=0;
           for(int colum=0;  colum<3; colum++) {
               
               TempsDia[colum][0]= Vmomentos[a];
               TempsDia[colum][1]=String.valueOf(Vtemps[a]);
               a++;
           } 
        controlador.genearArchivo(TempsDia);      
    }//GEN-LAST:event_BTNGenerarActionPerformed

    private void BTNCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNCargarActionPerformed
        if(!(temperatura.equals("")) && (!(comboMomento.getSelectedItem().equals("")))){
             temp= Float.parseFloat(temperatura.getText());
             momento=comboMomento.getSelectedItem().toString();
             
             if(i<3){
               Vtemps[i]=temp;
               Vmomentos[i]= momento;
               promedio+= Vtemps[i]; 
               i++;
             }else{
                 i=0;
             }
        }else{
            JOptionPane.showMessageDialog(null, "Debe ingresar correctamente todos los datos");
            setVisible(true);
        }
         
    }//GEN-LAST:event_BTNCargarActionPerformed

    private void comboMomentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMomentoActionPerformed
       
    }//GEN-LAST:event_comboMomentoActionPerformed

    private void BTNTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNTerminarActionPerformed
   
        int respuesta = JOptionPane.showConfirmDialog (null, "Al terminar el Dia se borraran los datos" , "Confirmar" ,
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.NO_OPTION) {
            setVisible(true);
        
        }else{
            Vtemps=new float[] {0,0,0};
            Vmomentos = new String []{"-","-","-"};
        }
    }//GEN-LAST:event_BTNTerminarActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNCargar;
    private javax.swing.JButton BTNGenerar;
    private javax.swing.JButton BTNTerminar;
    private javax.swing.JComboBox<String> comboMomento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField temperatura;
    // End of variables declaration//GEN-END:variables
}
