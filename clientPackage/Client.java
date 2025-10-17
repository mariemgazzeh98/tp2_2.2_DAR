package clientPackage;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;
import operateurPackage.Operation;



public class Client  {

	public static void main(String[] args) throws IOException{
		try {
			Socket socket=null;
			System.out.println("Je suis un client pas encore connecté…");
			socket = new Socket("localhost",1234);
			System.out.println("je suis connecté");
			InputStream is = socket.getInputStream();
			OutputStream os=socket.getOutputStream();
			
            Scanner sc=new Scanner(System.in);
			
			System.out.println("donner entier 1:");
			int x1=sc.nextInt();
			
			
			System.out.println("donner l'opérateur:");
			String o =sc.next();
			while(!(o.equals("+")) && !o.equals("-") && !o.equals("*") && !o.equals("/"))
			{	System.out.println("opérateur invalide");
				System.out.println("donner l'opérateur:");
				o =sc.next();
			}
			
			
			System.out.println("donner entier 2:");
			int x2=sc.nextInt();
			
			ObjectOutputStream oos = new ObjectOutputStream(os) ; 
			Operation op =new Operation (x1,x2,o);
			oos.writeObject(op);
			
			
            int res=is.read();
			System.out.println("la resultat="+res);
			
			socket.close();
			sc.close();
		}catch(IOException e)
		{
			e.printStackTrace();
			
		}
	
		}

}
