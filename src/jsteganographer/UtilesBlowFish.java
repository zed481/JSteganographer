package jsteganographer;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JPasswordField;

public class UtilesBlowFish {

    // <editor-fold defaultstate="collapsed" desc="Méthodes privées">
    /**
     * Retourne le SHA256 du mot de passe de l'usager. De cette façon, le mot de
     * passe aura toujours 256 bits.
     *
     * @param pwd
     * @return SHA256 du mot de passe de l'usager.
     */
    private static byte[] getKey( JPasswordField pwd ) throws NoSuchAlgorithmException {
        return UtilesHASH.getHashBytesFromText( UtilesHASH.SHA256, new String( pwd.getPassword() ) );
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Méthodes publiques">
    /**
     *
     * @param plainText
     * @param pwd
     * @return
     */
    static String ChiffrerString( final String plainText, final JPasswordField pwd ) throws InvalidKeyException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException {
        final SecretKeySpec key = new SecretKeySpec( getKey( pwd ), "Blowfish" );
        final Cipher cipher = Cipher.getInstance( "Blowfish" );
        cipher.init( Cipher.ENCRYPT_MODE, key );
        return Base64.getEncoder().encodeToString( cipher.doFinal( plainText.getBytes() ) );
    }

    /**
     *
     * @param strTxtChiffre
     * @param pwd
     * @return
     */
    static String DechiffrerString( final String strTxtChiffre, final JPasswordField pwd ) throws InvalidKeyException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException {
        SecretKeySpec key = new SecretKeySpec( getKey( pwd ), "Blowfish" );
        Cipher cipher = Cipher.getInstance( "Blowfish" );
        cipher.init( Cipher.DECRYPT_MODE, key );
        return ( new String( cipher.doFinal( Base64.getDecoder().decode( strTxtChiffre ) ) ) );
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Main">
    /**
     * Pour une démonstration
     *
     * @param args
     * @throws Exception
     */
    public static void main( final String[] args ) throws Exception {
        final String plainText = "Blowfish est un algorithme de chiffrement symétrique (c'est-à-dire « à clef secrète ») par blocs conçu par Bruce Schneier en 1993.";
        final JPasswordField pwd = new JPasswordField( "FauxM0tDePass3" );
        String strChiffree = ChiffrerString( plainText, pwd );
        System.out.println( "Original  : " + plainText );
        System.out.println( "Chiffré   : " + strChiffree );
        System.out.println( "Dechiffré : " + DechiffrerString( strChiffree, pwd ) );
        System.out.println( "\nMis en forme :\n" + strChiffree );
    }
    // </editor-fold>

}
