package jsteganographer;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Calcul d'empreintes numériques
 *
 * Mars 2021
 */
public class UtilesHASH {

    // <editor-fold defaultstate="collapsed" desc="Propriétés">
    public static final String MD2 = "MD2";
    public static final String MD5 = "MD5";
    public static final String SHA1 = "SHA1";
    public static final String SHA224 = "SHA-224";
    public static final String SHA256 = "SHA-256";
    public static final String SHA384 = "SHA-384";
    public static final String SHA512 = "SHA-512";
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Méthodes publiques">
    /**
     *
     * @param text
     * @return
     */
    static String getHashFromText( final String HashAlgo, final String text ) throws NoSuchAlgorithmException {
        final MessageDigest messageDigest = MessageDigest.getInstance( HashAlgo );
        messageDigest.update( text.getBytes() );
        final byte[] digest = messageDigest.digest();

        final BigInteger bigInt = new BigInteger( 1, digest );
        final StringBuilder hashHex = new StringBuilder( bigInt.toString( 16 ) );

        while ( hashHex.length() < 32 ) {
            hashHex.insert( 0, "0" );
        }
        return hashHex.toString().toUpperCase();
    }

    static byte[] getHashBytesFromText( final String HashAlgo, final String text ) throws NoSuchAlgorithmException {
        final MessageDigest messageDigest = MessageDigest.getInstance( HashAlgo );
        messageDigest.update( text.getBytes() );
        return messageDigest.digest();
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Main">
    /**
     * Pour une démonstration
     *
     * @param args
     * @throws Exception
     */
    public static void main( String[] args ) throws Exception {
        String strOriginale = "Une fonction de hachage est une fonction particulière qui, à partir d'une donnée fournie en entrée, calcule une empreinte numérique servant à identifier rapidement la donnée initiale";
        System.out.println( strOriginale );
        System.out.println( "MD2    : " + getHashFromText( MD2, strOriginale ) );
        System.out.println( "MD5    : " + getHashFromText( MD5, strOriginale ) );
        System.out.println( "SHA1   : " + getHashFromText( SHA1, strOriginale ) );
        System.out.println( "SHA224 : " + getHashFromText( SHA224, strOriginale ) );
        System.out.println( "SHA256 : " + getHashFromText( SHA256, strOriginale ) );
        System.out.println( "SHA384 : " + getHashFromText( SHA384, strOriginale ) );
        System.out.println( "SHA512 : " + getHashFromText( SHA512, strOriginale ) );
    }
    // </editor-fold>

}
