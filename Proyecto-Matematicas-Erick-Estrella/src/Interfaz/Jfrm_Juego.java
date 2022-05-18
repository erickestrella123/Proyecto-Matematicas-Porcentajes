
package Interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Jfrm_Juego extends javax.swing.JFrame {
    
    JButton[] btn;
    ImageIcon[] imagenes;
    int[] nivel;
    int contador = 0;
    double suma;
    int jugadas = 0;
    int mostrar = 1;
    int puntos = 0;
    public Jfrm_Juego() {
        initComponents();
        iniciarTodoLosComponestes();
        iniciarJuego();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Img_Icono.png")).getImage());
    }
    
    private void iniciarTodoLosComponestes(){
        botones();
        imagenes();
    }
    private void botones(){
        btn = new JButton[5];
        btn[0] = boton1;
        btn[1] = boton2;
        btn[2] = boton3;
        btn[3] = boton4;
        btn[4] = boton5;
        for (int i = 0; i < 5; i++) {
            btn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    pulsarBoton(ae);
                }
            });
            btn[i].setBackground(Color.yellow);
        }
    }
    private void imagenes(){
        imagenes = new ImageIcon[9];
        imagenes[0] = new ImageIcon(getClass().getResource("/Imagenes/doratriste.png"));
        imagenes[1] = new ImageIcon(getClass().getResource("/Imagenes/dora.png"));
        imagenes[2] = new ImageIcon(getClass().getResource("/Imagenes/doramal.png"));
        imagenes[3] = new ImageIcon(getClass().getResource("/Imagenes/garantia.png"));
        imagenes[4] = new ImageIcon(getClass().getResource("/Imagenes/cheque.png"));
        imagenes[5] = new ImageIcon(getClass().getResource("/Imagenes/error.png"));
        imagenes[6] = new ImageIcon(getClass().getResource("/Imagenes/botonventana.png"));
        imagenes[7] = new ImageIcon(getClass().getResource("/Imagenes/nobitadepie.png"));
        imagenes[8] = new ImageIcon(getClass().getResource("/Imagenes/nobitatriste.png"));
    }
    private void iniciarJuego(){
        
        //mostraresmos el puntaje inicial
        txt_puntos.setText("Nota:  "+String.valueOf(puntos));
        //mostraremos la imagen principal
        label_imagen.setIcon(imagenes[2]);
        //vamos a mostrar el nivel 
        txt_nivel.setText(String.valueOf(mostrar)+"°");
        //tenemos que volver todos los botones al mismo color
        for (int i = 0; i < 5; i++) {
            btn[i].setBackground(Color.yellow);
        }
        nivel = new int[5];
        System.out.println("Nivel: "+contador);
        nivel[0] = 10;
        nivel[1] = 100;
        nivel[2] = 1000;
        nivel[3] = 10000;
        nivel[4] = 100000;
        double num1;
        double num2;
        
        boolean mayor1;
        do{
            mayor1 = false;
        num1 = (int)(Math.random() * nivel[contador]);
        num2 = (int)(Math.random() * nivel[contador]);
        if(contador > 0){
            if(num1 < nivel[contador -1] || num2 < nivel[contador-1]){
                mayor1 = true;
            }
        }
        suma = (num1*num2)/100;
        }while(num1 == 0 || num2 == 0 || suma == nivel[contador] || mayor1);
        System.out.println("Hallar el "+num1+"% de "+num2);
        txt_respuesta.setText("Hallar el "+num1+"% de "+num2);
        
        //vamos a crear alternativas
        crearAlternativas();
    }
    private void crearAlternativas(){
        //Limitador de decimales
        DecimalFormat formato1 = new DecimalFormat("0.00");
        
        int[] alternativas = new int[5];
        boolean encontrar;
        boolean mayor2;
        for (int i = 0; i < 5; i++) {
            do{
                encontrar = false;
            do{
                mayor2 = false;
            alternativas[i] = (int)(Math.random() * nivel[contador]);
            if(contador > 0){
                if(alternativas[i] < nivel[contador - 1]){
                    mayor2 = true;
                }
            }
            //tambien no debemos olvidar que las alternativas que estamos generando no sean iguales a la respuesta
            }while(alternativas[i] == 0 || alternativas[i] >= nivel[contador] || mayor2 || alternativas[i] == suma);
            //las alternativas no te pueden repetir 
            for (int j = 0; j < 5; j++) {
                if(alternativas[i] == alternativas[j]){
                    if(i != j){
                        //entonces se encontro una alternativa repetida
                    encontrar = true;
                    }
                }
            }
            }while(encontrar);
        }
        String[] todo = new String[5];
        int ale = (int)(Math.random() * 4);
        int a = 0;
        for (int i = 0; i < 5; i++) {
            if(ale == i){
                todo[i] = String.valueOf(suma);
            }else{
                todo[i] = String.valueOf(formato1.format(alternativas[a]));
                a++;
            }
        }
        for (int i = 0; i < 5; i++) {
            btn[i].setText(todo[i]);
        }
    }
    
    private void pulsarBoton(ActionEvent pulsado){
        JButton boton = (JButton) pulsado.getSource();
        String botonPulsado = boton.getText();
        if(botonPulsado.equals(String.valueOf(suma))){
            switch(jugadas){
                case 0: label1.setIcon(imagenes[4]);break;
                case 1: label2.setIcon(imagenes[4]);break;
                case 2: label3.setIcon(imagenes[4]);break;
                case 3: label4.setIcon(imagenes[4]);break;
                case 4: label5.setIcon(imagenes[4]);break;
            }
            puntos = puntos +4;
            txt_puntos.setText("Nota:  "+String.valueOf(puntos));
            label_imagen.setIcon(imagenes[1]);
            JOptionPane.showMessageDialog(null, "Respuesta Correcta +4 puntos", "Felicidades", JOptionPane.INFORMATION_MESSAGE, imagenes[3]);
            boton.setBackground(Color.GREEN);
            
            jugadas++;
            contador++;
            mostrar++;

        }else{
            switch(jugadas){
                case 0: label1.setIcon(imagenes[5]);break;
                case 1: label2.setIcon(imagenes[5]);break;
                case 2: label3.setIcon(imagenes[5]);break;
                case 3: label4.setIcon(imagenes[5]);break;
                case 4: label5.setIcon(imagenes[5]);break;
            }
            boton.setBackground(Color.red);
            label_imagen.setIcon(imagenes[0]);
            JOptionPane.showMessageDialog(null, "Respuesta Incorrecta +0 puntos", "Para la Proxima", JOptionPane.INFORMATION_MESSAGE, imagenes[6]);

            jugadas++;
        }
        
        if(jugadas == 5){
            if(puntos >= 12){
                JOptionPane.showMessageDialog(null, "Felicitacidades tienes una nota aprobatoria\nLo Lograste\nNota Final: "+puntos, "Yupi!", JOptionPane.INFORMATION_MESSAGE, imagenes[7]);
            reiniciarJuego();
            }else{
                JOptionPane.showMessageDialog(null, "Lo siento tienes una nota desaprobatoria\nSigue intentando\nNota Final: "+puntos, "Mal!", JOptionPane.INFORMATION_MESSAGE, imagenes[8]);
            reiniciarJuego();
            }
        }
        iniciarJuego();
    }
    private void reiniciarJuego(){
        label1.setIcon(null);
        label2.setIcon(null);
        label3.setIcon(null);
        label4.setIcon(null);
        label5.setIcon(null);
        jugadas = 0;
        contador = 0;
        mostrar = 1;
        puntos = 0;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txt_nivel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_respuesta = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        boton1 = new javax.swing.JButton();
        boton5 = new javax.swing.JButton();
        boton2 = new javax.swing.JButton();
        boton4 = new javax.swing.JButton();
        boton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        label2 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label_imagen = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txt_puntos = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nivel", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        txt_nivel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txt_nivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txt_nivel, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(txt_nivel, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel6.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 90, 60));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pregunta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        txt_respuesta.setEditable(false);
        txt_respuesta.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        txt_respuesta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_respuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_respuestaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txt_respuesta, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txt_respuesta, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 220, 100));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alternativas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boton3, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(boton4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boton5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boton2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(boton3, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(boton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(boton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 270, 140));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contador", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 260, 130));
        jPanel6.add(label_imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 210, 210));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        txt_puntos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(txt_puntos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_puntos, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 100, 50));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 80, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Img_Fondo_Pizarra.jpg"))); // NOI18N
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //volvemos a la presentacion
        Presentacion1 volver = new Presentacion1();
        this.dispose();
        volver.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_respuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_respuestaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_respuestaActionPerformed
    //BUENO AMIGOS ESO SERÍA TODO NO OLVIDEN DEJAR SU LIKE A LA PÁGINA PARA ASÍ SUBIR MÁS VIDEOS MUCHAS GRACIAS Y HASTA LUEGO
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton1;
    private javax.swing.JButton boton2;
    private javax.swing.JButton boton3;
    private javax.swing.JButton boton4;
    private javax.swing.JButton boton5;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label_imagen;
    private javax.swing.JLabel txt_nivel;
    private javax.swing.JLabel txt_puntos;
    private javax.swing.JTextField txt_respuesta;
    // End of variables declaration//GEN-END:variables
}
