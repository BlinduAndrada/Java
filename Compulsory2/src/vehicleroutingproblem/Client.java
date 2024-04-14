package vehicleroutingproblem;

import java.time.LocalTime;
import java.util.Objects;

/**
 * Class for the client part
 */
public class Client {
    private String clientName;
    private LocalTime minInterval, maxInterval;
    private TypeClient typeOfClient;


    public Client(String clientName, LocalTime minInterval, LocalTime maxInterval, TypeClient typeOfClient) {
        this.clientName = clientName;
        this.minInterval = minInterval;
        this.maxInterval = maxInterval;
        this.typeOfClient = typeOfClient;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }


    public LocalTime getMinInterval() {
        return minInterval;
    }

    public void setMinInterval(LocalTime minInterval) {
        this.minInterval = minInterval;
    }

    public LocalTime getMaxInterval() {
        return maxInterval;
    }

    public void setMaxInterval(LocalTime maxInterval) {
        this.maxInterval = maxInterval;
    }

    public TypeClient getTypeOfClient() {
        return typeOfClient;
    }

    public void setTypeOfClient(TypeClient typeOfClient) {
        this.typeOfClient = typeOfClient;
    }


    /**
     * printing all details about a client
     */
    public void print() {
        System.out.println("The client " + this.clientName + " with the type " + this.typeOfClient + " is in the interval of time starting at " + minInterval + " until " + maxInterval);
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientName='" + clientName + '\'' +
                ", minInterval=" + minInterval +
                ", maxInterval=" + maxInterval +
                ", typeOfClient=" + typeOfClient +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(clientName, client.clientName) && Objects.equals(minInterval, client.minInterval) && Objects.equals(maxInterval, client.maxInterval) && typeOfClient == client.typeOfClient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientName, minInterval, maxInterval, typeOfClient);
    }
}
