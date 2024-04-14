package vehicleroutingproblem;


import java.util.ArrayList;
import java.util.List;

public class Problem {
    private List<Depot> depots;
    private List<Client> clients;
    private int maxDepots;

    public Problem(int maxDepots) {
        this.depots = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.maxDepots = maxDepots;
    }

    public int getMaxDepots() {
        return maxDepots;
    }

    public void setMaxDepots(int maxDepots) {
        this.maxDepots = maxDepots;
    }

    public List<Depot> getDepots() {
        return depots;
    }

    public void setDepots(List<Depot> depots) {
        this.depots = depots;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    /**
     * @param depot add a new depot to the list
     */
    public void addDepot(Depot depot) {
        if (depots.size() >= maxDepots) {
            System.out.println("Cannot add depot. Maximum number of depots reached.");

        }

        for (Depot existingDepot : depots) {
            if (existingDepot.equals(depot)) {
                System.out.println("Depot already exists.");

            }
        }

        depots.add(depot);

    }

    /**
     * @param client we add the new clients
     */
    public void addClient(Client client) {
        for (Client existingClient : clients) {
            if (existingClient.equals(client)) {
                System.out.println("Client already exists");
            }
        }
        clients.add(client);
    }

    /**
     * @return an array from the list of all vehicles
     */
    public Vehicle[] getVehicles() {
        List<Vehicle> allVehicles = new ArrayList<>();

        for (Depot depot : depots) {
            allVehicles.addAll(depot.getVehicles());
        }

        return allVehicles.toArray(new Vehicle[0]);

    }

    @Override
    public String toString() {
        return "Problem{" +
                "depots=" + depots +
                ", maxDepots=" + maxDepots +
                '}';
    }
}
