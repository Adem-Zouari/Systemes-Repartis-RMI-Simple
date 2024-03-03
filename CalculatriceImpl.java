package Simple_RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatriceImpl extends UnicastRemoteObject implements CalculatriceInterface {

    protected CalculatriceImpl() throws RemoteException {
        super();
    }

    @Override
    public double addition(double a, double b) throws RemoteException {
        return a + b;
    }

    @Override
    public double soustraction(double a, double b) throws RemoteException {
        return a - b;
    }

    @Override
    public double multiplication(double a, double b) throws RemoteException {
        return a * b;
    }

    @Override
    public double division(double a, double b) throws RemoteException {
        if (b != 0) {
            return a / b;
        } else {
            throw new RemoteException("Division par zéro.");
        }
    }
}
