package taskone.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import java.io.Console;

public class Main {

    public static void main(String[] args) {

        //get <server><port> from CLI
        if(args.length == 1){
            String[] hostPort = args[0].split(":");
            String host = hostPort[0];
            int port = Integer.parseInt(hostPort[1]);
        
            boolean quitFlag = true;
            try{
                Scanner scan = new Scanner(System.in);
                while(quitFlag){
                    Socket sock = new Socket(host, port);
                    InputStream is = sock.getInputStream();
                    ObjectInputStream ois = new ObjectInputStream(is);
                    OutputStream os = sock.getOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(os);

                    float answer[] = calcStats(ois.readUTF());

                    Console cons = System.console();
                    String consinput = cons.readLine("Input Name as in NRIC\n>>");
                    oos.writeUTF(consinput);
                    consinput = cons.readLine("Input Email\n>>");
                    oos.writeUTF(consinput);
                    System.out.println("Sending Mean");
                    oos.writeFloat(answer[1]);
                    System.out.println("Sending Standard Deviation");
                    oos.writeFloat(answer[2]);

                    System.out.println("Terminating Connection");
                    quitFlag = false;
                    oos.close();
                    os.close();
                    ois.close(); 
                    is.close();
                    sock.close();
                }
            } catch (IOException e) {
                System.out.println(">>Server IO Error\n");
                e.printStackTrace();
            }
        } else {
            System.out.println("Usage: <Host>:<Port>");
            System.exit(1);
        }
    }



    public static float[] calcStats(String serverinput){
        String[] numStrArr = serverinput.split(",");
        int count = numStrArr.length;
        float[] numFltArr = new float[count];
        float total = 0.0f;
        float element;
        for(int i = 0; i < count;i++){
            element = Float.parseFloat(numStrArr[i]);
            numFltArr[i] = element;
            total += element;
        }

        float avg = total/count;

        double variance = 0.0d;
        for(int i = 0; i < count; i++){
            variance += Math.pow((numFltArr[i] - avg), 2);
        }
        variance /= count;
        float stddev = (float)(Math.sqrt(variance));

        System.out.println("Recieved"+ Arrays.toString(numFltArr));
        System.out.println("Count:" + count );
        System.out.println("Total:" + total );
        System.out.println("Average:" + avg );
        System.out.println("Variance:" + variance );
        System.out.println("Std Dev:" + stddev );

        float[] stats = new float[3];
        stats[0] = total;
        stats[1] = avg;
        stats[2] = stddev;
        return stats;
    }


//end of class
}