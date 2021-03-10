package jsteganographer;

import java.io.*;
//import java.util.Scanner;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.awt.image.DataBufferByte;

public class UtilesSteganographie {

    private final static int BYTESFORTEXTLENGTHDATA = 4;
    private final static int BITSINBYTE = 8;

    // Encode
    static void encode( String imagePath, String finalFileName, String text ) throws Exception {
        BufferedImage originalImage = getImageFromPath( imagePath );
        BufferedImage imageInUserSpace = getImageInUserSpace( originalImage );

        byte imageInBytes[] = getBytesFromImage( imageInUserSpace );
        byte textInBytes[] = text.getBytes();
        byte textLengthInBytes[] = getBytesFromInt( textInBytes.length );
        encodeImage( imageInBytes, textLengthInBytes, 0 );
        encodeImage( imageInBytes, textInBytes, BYTESFORTEXTLENGTHDATA * BITSINBYTE );
        saveImageToPath( imageInUserSpace, new File( finalFileName ), "png" );
    }

    // Decode
    static String decode( String imagePath ) throws Exception {
        byte[] decodedHiddenText;
        BufferedImage imageFromPath = getImageFromPath( imagePath );
        BufferedImage imageInUserSpace = getImageInUserSpace( imageFromPath );
        byte imageInBytes[] = getBytesFromImage( imageInUserSpace );
        decodedHiddenText = decodeImage( imageInBytes );
        return new String( decodedHiddenText );
    }

//<editor-fold defaultstate="collapsed" desc="Méthodes privées">
    private static byte[] encodeImage( byte[] image, byte[] addition, int offset ) {
        if ( addition.length + offset > image.length ) {
            throw new IllegalArgumentException( "Image file is not long enough to store provided text" );
        }
        for ( int i = 0; i < addition.length; i++ ) {
            int additionByte = addition[ i ];
            for ( int bit = BITSINBYTE - 1; bit >= 0; --bit, offset++ ) {
                int b = ( additionByte >>> bit ) & 0x1;
                image[ offset ] = ( byte ) ( ( image[ offset ] & 0xFE ) | b );
            }
        }
        return image;
    }

    private static byte[] decodeImage( byte[] image ) {
        int length = 0;
        int offset = BYTESFORTEXTLENGTHDATA * BITSINBYTE;

        for ( int i = 0; i < offset; i++ ) {
            length = ( length << 1 ) | ( image[ i ] & 0x1 );
        }

        byte[] result = new byte[ length ];

        for ( int b = 0; b < result.length; b++ ) {
            for ( int i = 0; i < BITSINBYTE; i++, offset++ ) {
                result[ b ] = ( byte ) ( ( result[ b ] << 1 ) | ( image[ offset ] & 0x1 ) );
            }
        }
        return result;
    }

    // File I/O methods
    private static void saveImageToPath( BufferedImage image, File file, String extension ) throws IOException {
        file.delete();
        ImageIO.write( image, extension, file );
    }

//    private static void saveTextToPath( String text, File file ) {
//        try {
//            if ( file.exists() == false ) {
//                file.createNewFile();
//            }
//            FileWriter fileWriter = new FileWriter( file.getAbsoluteFile() );
//            try (BufferedWriter bufferedWriter = new BufferedWriter( fileWriter )) {
//                bufferedWriter.write( text );
//            }
//        } catch ( IOException exception ) {
//            System.out.println( "Couldn't write text to file: " + exception );
//        }
//    }
    private static BufferedImage getImageFromPath( String path ) throws IOException {
        BufferedImage image;
        File file = new File( path );
        image = ImageIO.read( file );
        return image;
    }

//    private static String getTextFromTextFile( String textFile ) {
//        String text = "";
//        try {
//            Scanner scanner = new Scanner( new File( textFile ) );
//            text = scanner.useDelimiter( "\\A" ).next();
//            scanner.close();
//        } catch ( Exception exception ) {
//            System.out.println( "Couldn't read text from file. Error: " + exception );
//        }
//        return text;
//    }
    // Helpers
    private static BufferedImage getImageInUserSpace( BufferedImage image ) {
        BufferedImage imageInUserSpace = new BufferedImage( image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR );
        Graphics2D graphics = imageInUserSpace.createGraphics();
        graphics.drawRenderedImage( image, null );
        graphics.dispose();
        return imageInUserSpace;
    }

    private static byte[] getBytesFromImage( BufferedImage image ) {
        WritableRaster raster = image.getRaster();
        DataBufferByte buffer = ( DataBufferByte ) raster.getDataBuffer();
        return buffer.getData();
    }

    private static byte[] getBytesFromInt( int integer ) {
        return ByteBuffer.allocate( BYTESFORTEXTLENGTHDATA ).putInt( integer ).array();
    }

//</editor-fold>
}
