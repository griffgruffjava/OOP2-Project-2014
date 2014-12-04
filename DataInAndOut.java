import java.io.*;
import javax.swing.*;
/** writes data to a binary file.*/
public class DataInAndOut {
    public static void main (String [] args) throws IOException {       
        // open file output stream
        File outFile = new File("data");
        FileOutputStream outStream = new FileOutputStream(outFile);
        DataOutputStream outDataStream = new DataOutputStream(outStream);

        // write an int, boolean, double
        outDataStream.writeInt(44);
        outDataStream.writeBoolean(true);
        outDataStream.writeDouble(7.2);

        outDataStream.close();

        
        // open file input stream
        File inFile = new File("data");
        FileInputStream inStream = new FileInputStream(inFile);
        DataInputStream inDataStream = new DataInputStream(inStream);

        // read an int, boolean, double
        int n =  inDataStream.readInt();
        boolean b = inDataStream.readBoolean();
        double d = inDataStream.readDouble();

        inDataStream.close();

        // what did we get?
        System.out.println("n = " + n);
        System.out.println("b = " + b);
        System.out.println("d = " + d);
        
        // can we add n to d?
        System.out.println("n + d = " + (n+d));        
        
    }
}
