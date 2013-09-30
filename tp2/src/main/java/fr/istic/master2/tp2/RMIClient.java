/**
 * 
 */
package fr.istic.master2.tp2;

import java.rmi.NotBoundException;

import java.rmi.RMISecurityManager;

import java.rmi.RemoteException;

import java.rmi.registry.LocateRegistry;

import java.rmi.registry.Registry;
import fr.istic.master2.tp2.ReceiveMessageInterface;

/**
 * @author antoine TURBIN, bertrand DAVID
 *
 */
public class RMIClient {
	static public void main(String args[]) {

	System.setSecurityManager(new RMISecurityManager());

	ReceiveMessageInterface rmiServer;

	Registry registry;

	String serverAddress="127.0.0.1";

	String serverPort="3232";

	String text="Middleware";

	System.out.println("sending "+text+" to "+serverAddress+":"+serverPort);

	try{

	// get the “registry”

	registry=LocateRegistry.getRegistry(serverAddress,(new Integer(serverPort)).intValue());

	// look up the remote object

	rmiServer=(ReceiveMessageInterface)(registry.lookup("rmiServer"));

	// call the remote method

	System.err.println(rmiServer.receiveMessage("toto"));

	} catch(RemoteException e){

	e.printStackTrace();

	} catch(NotBoundException e){

	e.printStackTrace();

	}
	   }
}
