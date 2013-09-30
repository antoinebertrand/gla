/**
 * 
 */
package fr.istic.master2.tp2;

import java.rmi.RemoteException;

import fr.istic.master2.tp2.ReceiveMessageInterface;

/**
 * @author antoine TURBIN, bertrand DAVID
 * 
 */
public class ReceiveMessageImpl implements ReceiveMessageInterface {

	public String receiveMessage(String x) throws RemoteException {

		System.out.println(x.toUpperCase());

		return x.toUpperCase();

	}

	static public void main(String args[]) {

		try {

			System.out.println("Mise en place du Security Manager ...");

			System.setSecurityManager(new java.rmi.RMISecurityManager());

			new RMIServer();

		} catch (Exception e) {

			e.printStackTrace();

			System.exit(1);

		}
	}
}