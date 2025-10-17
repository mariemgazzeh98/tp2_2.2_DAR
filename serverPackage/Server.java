package serverPackage;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import operateurPackage.Operation;

public class Server {

	public static void main(String[] args) throws IOException {
		try{
		ServerSocket socketServeur =  new ServerSocket(1234);
		System.out.println("Je suis un serveur en attente la connexion d'un client ");
		Socket socket = socketServeur.accept();
		System.out.println("un client est connecté");
		
		InputStream is = socket.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(is) ;
		Operation op=(Operation) ois.readObject();

		int res = 0;
		switch (op.getO()) {
			case "+":
				res = op.getX1()+op.getX2();
				System.out.println("Addition : " + op.getX1() + " + "+op.getX2()+" = " + res);
				break;
			case "-":
				res = op.getX1()-op.getX2();
				System.out.println("Soustraction : " + op.getX1() +" -  "+op.getX2()+" = " + res);
				break;
			case "*":
				res = op.getX1()*op.getX2();
				System.out.println("Multiplication : " + op.getX1() + " *  "+op.getX2()+" = " + res);
				break;
			case "/":
				if(op.getX2() !=0) {
					res = op.getX1()/op.getX2();
					System.out.println("Division : " + op.getX1() + " /  "+op.getX2()+" = " + res);
				}
				else
				{System.out.println("Division par zéro impossible");}
				break;
			default:
				System.out.println("Erreur : operateur invalide");
		}
		
		OutputStream os = socket.getOutputStream();
		os.write(res);
		socketServeur.close();
		socket.close();
		}catch(IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
			
		}
	}



}


