package jsteganographer;

import java.awt.FileDialog;
import java.io.IOException;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
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
                    String fileName = txtImageSource.getText();
                    int position = fileName.lastIndexOf( "." );
                    if ( position > 0 ) {
                        fileName = fileName.substring( 0, position );
                    }

                    txtImageDestination.setText( fileName + "_with_hidden_message.png" );
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
        cmdDestination = new javax.swing.JButton();
        txtImageDestination = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAEncoder = new javax.swing.JTextArea();
        cmdEncode = new javax.swing.JButton();
        cmdDecode = new javax.swing.JButton();
        cmdEffacer = new javax.swing.JButton();
        cmdEffaceNomFichierDestination = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("jSteganographer v1.0");

        cmdSource.setText("Source...");
        cmdSource.setToolTipText("Select source image");
        cmdSource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSourceActionPerformed(evt);
            }
        });

        txtImageSource.setDragEnabled(true);

        cmdDestination.setText("Destination...");
        cmdDestination.setToolTipText("Select destination image with hidden text");
        cmdDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDestinationActionPerformed(evt);
            }
        });

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

        cmdEffaceNomFichierDestination.setText("E");
        cmdEffaceNomFichierDestination.setToolTipText("Erase the destination field (to decode a image file)");
        cmdEffaceNomFichierDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEffaceNomFichierDestinationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmdSource, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdDestination))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtImageDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdEffaceNomFichierDestination))
                            .addComponent(txtImageSource, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(539, 539, 539)))
                .addGap(17, 17, 17))
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
                    .addComponent(cmdDestination)
                    .addComponent(txtImageDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdEffaceNomFichierDestination))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdEncode)
                    .addComponent(cmdDecode)
                    .addComponent(cmdEffacer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdSourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSourceActionPerformed
        final FileDialog fd = new FileDialog( this, "Fichier source", FileDialog.LOAD );
        fd.setDirectory( LastDir );
        fd.setFile( "*.*" );
        fd.setVisible( true );
        if ( fd.getFile() != null ) {
            LastDir = fd.getDirectory();
            txtImageSource.setText( fd.getDirectory().concat( fd.getFile() ) );

            String fileName = txtImageSource.getText();
            int position = fileName.lastIndexOf( "." );
            if ( position > 0 ) {
                fileName = fileName.substring( 0, position );
            }

            String finalFileName = fileName + "_with_hidden_message.png";

            txtImageDestination.setText( finalFileName );
        }
    }//GEN-LAST:event_cmdSourceActionPerformed

    private void cmdDestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDestinationActionPerformed
        final FileDialog fd = new FileDialog( this, "Fichier source", FileDialog.LOAD );
        fd.setDirectory( LastDir );
        fd.setFile( "*.*" );
        fd.setVisible( true );
        if ( fd.getFile() != null ) {
            final String strNomFichier = fd.getDirectory().concat( fd.getFile() );
            LastDir = fd.getDirectory();
            txtImageSource.setText( strNomFichier );
            txtImageDestination.setText( strNomFichier + ".bin" );
        }
    }//GEN-LAST:event_cmdDestinationActionPerformed

    private void cmdEncodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEncodeActionPerformed
        try {
            UtilesSteganographie.encode( txtImageSource.getText(), txtImageDestination.getText(), UtilesBlowFish.ChiffrerString( txtAEncoder.getText(), jPasswordField ) );
            JOptionPane.showMessageDialog( this, "Encodage terminé!", "jSteganographer", JOptionPane.INFORMATION_MESSAGE );
        } catch ( Exception e ) {
            e.printStackTrace( System.err );
            JOptionPane.showMessageDialog( this, e, "Erreur!", JOptionPane.ERROR_MESSAGE );
        }
    }//GEN-LAST:event_cmdEncodeActionPerformed

    private void cmdDecodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDecodeActionPerformed
        try {
            txtImageDestination.setText( "" );
            txtAEncoder.setText( UtilesBlowFish.DechiffrerString( UtilesSteganographie.decode( txtImageSource.getText() ), jPasswordField ) );
        } catch ( Exception e ) {
            e.printStackTrace( System.err );
            JOptionPane.showMessageDialog( this, e, "Erreur!", JOptionPane.ERROR_MESSAGE );
        }
    }//GEN-LAST:event_cmdDecodeActionPerformed

    private void cmdEffacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEffacerActionPerformed
        txtImageSource.setText( "" );
        txtImageDestination.setText( "" );
        txtAEncoder.setText( "" );
        jPasswordField.setText( "" );
    }//GEN-LAST:event_cmdEffacerActionPerformed

    private void cmdEffaceNomFichierDestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEffaceNomFichierDestinationActionPerformed
        txtImageDestination.setText( "" );
    }//GEN-LAST:event_cmdEffaceNomFichierDestinationActionPerformed

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
    private javax.swing.JButton cmdDestination;
    private javax.swing.JButton cmdEffaceNomFichierDestination;
    private javax.swing.JButton cmdEffacer;
    private javax.swing.JButton cmdEncode;
    private javax.swing.JButton cmdSource;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAEncoder;
    private javax.swing.JTextField txtImageDestination;
    private javax.swing.JTextField txtImageSource;
    // End of variables declaration//GEN-END:variables
}
