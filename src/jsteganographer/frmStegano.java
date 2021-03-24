package jsteganographer;

import java.awt.FileDialog;
import java.io.IOException;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * jSteganographer v1.0
 *
 * Mars 2021
 */
public class frmStegano extends javax.swing.JFrame {

    /**
     * Répertoire sélectionné
     */
    private static String LastDir = ".";

    /**
     * Creates new form frmStegano
     */
    public frmStegano() {
        initComponents();

        // Frame screen centered
        this.setLocationRelativeTo( null );

        txtImageSource.setDropTarget( new DropTarget() {
            @Override
            public synchronized void drop( DropTargetDropEvent evt ) {
                try {
                    evt.acceptDrop( DnDConstants.ACTION_COPY );

                    @SuppressWarnings( "unchecked" )
                    List<File> droppedFiles = ( List<File> ) evt.getTransferable().getTransferData( DataFlavor.javaFileListFlavor );

                    droppedFiles.forEach( file -> {
                        txtImageSource.setText( file.getAbsolutePath() );
                    } );
//                    String fileName = txtImageSource.getText();
//                    int position = fileName.lastIndexOf( "." );
//                    if ( position > 0 ) {
//                        fileName = fileName.substring( 0, position );
//                    }

                } catch ( UnsupportedFlavorException | IOException ex ) {
                    ex.printStackTrace( System.err );
                }
            }
        } );
    }

    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdSource = new javax.swing.JButton();
        txtImageSource = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAEncoder = new javax.swing.JTextArea();
        cmdEncode = new javax.swing.JButton();
        cmdDecode = new javax.swing.JButton();
        cmdEffacer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("jSteganographer v1.1");

        cmdSource.setText("Source...");
        cmdSource.setToolTipText("Select source image");
        cmdSource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSourceActionPerformed(evt);
            }
        });

        txtImageSource.setDragEnabled(true);

        jLabel1.setText("Password :");

        jPasswordField.setToolTipText("Type the password that will serve as the encryption key");

        jLabel2.setText("Text to hide :");

        txtAEncoder.setColumns(20);
        txtAEncoder.setLineWrap(true);
        txtAEncoder.setRows(5);
        jScrollPane1.setViewportView(txtAEncoder);

        cmdEncode.setText("Hide");
        cmdEncode.setToolTipText("Hide the text");
        cmdEncode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEncodeActionPerformed(evt);
            }
        });

        cmdDecode.setText("Unhide");
        cmdDecode.setToolTipText("Unhide the text");
        cmdDecode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDecodeActionPerformed(evt);
            }
        });

        cmdEffacer.setText("Clear All");
        cmdEffacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEffacerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(556, 556, 556))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmdSource, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(cmdEncode)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmdDecode)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmdEffacer, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtImageSource, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdSource)
                    .addComponent(txtImageSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdEncode)
                    .addComponent(cmdDecode)
                    .addComponent(cmdEffacer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdSourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSourceActionPerformed
        final FileDialog fd = new FileDialog( this, "Fichier source", FileDialog.LOAD );
        fd.setDirectory( LastDir );
        fd.setFile( "*.png" );
        fd.setVisible( true );
        if ( fd.getFile() != null ) {
            LastDir = fd.getDirectory();
            txtImageSource.setText( fd.getDirectory().concat( fd.getFile() ) );
        }
    }//GEN-LAST:event_cmdSourceActionPerformed

    private void cmdEncodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEncodeActionPerformed
        if ( txtAEncoder.getText().length() > 0 ) {
            if ( jPasswordField.getPassword().length > 0 ) {
                try {
                    BufferedImage image = UtilesSteganographie.encode( txtImageSource.getText(), UtilesBlowFish.ChiffrerString( txtAEncoder.getText(), jPasswordField ) );
                    new frmImage( image, txtImageSource.getText() ).setVisible( true );
                } catch ( Exception e ) {
                    e.printStackTrace( System.err );
                    JOptionPane.showMessageDialog( this, e, "Erreur!", JOptionPane.ERROR_MESSAGE );
                }
            } else {
                JOptionPane.showMessageDialog( this, "Please enter a password to encrypt the text.", "Password please!", JOptionPane.ERROR_MESSAGE );
            }
        } else {
            JOptionPane.showMessageDialog( this, "Please enter a text to encode.", "Text needed!", JOptionPane.ERROR_MESSAGE );
        }
    }//GEN-LAST:event_cmdEncodeActionPerformed

    private void cmdDecodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDecodeActionPerformed
        try {
            if ( jPasswordField.getPassword().length > 0 ) {
                txtAEncoder.setText( UtilesBlowFish.DechiffrerString( UtilesSteganographie.decode( txtImageSource.getText() ), jPasswordField ) );
            } else {
                JOptionPane.showMessageDialog( this, "Please enter a password to decrypt the text.", "Password please!", JOptionPane.ERROR_MESSAGE );
            }
        } catch ( Exception e ) {
            e.printStackTrace( System.err );
            JOptionPane.showMessageDialog( this, e, "Erreur!", JOptionPane.ERROR_MESSAGE );
        }
    }//GEN-LAST:event_cmdDecodeActionPerformed

    private void cmdEffacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEffacerActionPerformed
        txtImageSource.setText( "" );
        txtAEncoder.setText( "" );
        jPasswordField.setText( "" );
    }//GEN-LAST:event_cmdEffacerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main( String args[] ) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for ( javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels() ) {
                if ( "Nimbus".equals( info.getName() ) ) {
                    javax.swing.UIManager.setLookAndFeel( info.getClassName() );
                    break;
                }
            }
        } catch ( ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex ) {
            java.util.logging.Logger.getLogger( frmStegano.class.getName() ).log( java.util.logging.Level.SEVERE, null, ex );
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater( () -> {
            new frmStegano().setVisible( true );
        } );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdDecode;
    private javax.swing.JButton cmdEffacer;
    private javax.swing.JButton cmdEncode;
    private javax.swing.JButton cmdSource;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAEncoder;
    private javax.swing.JTextField txtImageSource;
    // End of variables declaration//GEN-END:variables
}
