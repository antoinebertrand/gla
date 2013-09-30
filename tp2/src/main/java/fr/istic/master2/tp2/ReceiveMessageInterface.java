/**
 * 
 */
package fr.istic.master2.tp2;

import java.rmi.Remote;

import java.rmi.RemoteException;

/**
 * @author antoine TURBIN, bertrand DAVID
 *
 */
public interface ReceiveMessageInterface extends Remote {

	String receiveMessage(String x) throws RemoteException; //cette exception est levée lors d'un problème côté serveur, de communication, etc
}
