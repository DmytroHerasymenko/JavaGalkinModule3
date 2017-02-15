import java.util.List;
import java.util.Map;

/**
 * Created by dima on 14.02.17.
 */
public class Flights {
    Map<String, Ticket> tickets;
    List<Stuart> stuarts;
    List<Pilot> pilots;
    AirPlane plane;
    int distance;

    public double profit(){
        double profit = 0;
        for(Ticket t : tickets.values()){
            profit += t.getPrice();
        }
        for(Pilot p : pilots){
            profit -= p.getSalary();
        }
        for(Stuart s : stuarts){
            profit -= s.getSalary();
        }
        profit -=plane.getFuel() * distance;
        return profit;
    }

    public Map<String, Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Map<String, Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Stuart> getStuarts() {
        return stuarts;
    }

    public void setStuarts(List<Stuart> stuarts) {
        this.stuarts = stuarts;
    }

    public List<Pilot> getPilots() {
        return pilots;
    }

    public void setPilots(List<Pilot> pilots) {
        this.pilots = pilots;
    }

    public AirPlane getPlane() {
        return plane;
    }

    public void setPlane(AirPlane plane) {
        this.plane = plane;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
