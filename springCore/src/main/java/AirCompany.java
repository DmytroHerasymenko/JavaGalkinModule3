import java.util.List;

/**
 * Created by dima on 14.02.17.
 */
public class AirCompany {
    List<Flights> flights;


    public double profit(){
        double profit = 0;
        for(Flights f : flights){
            profit += f.profit();
        }
        return profit;
    }

    public List<Flights> getFlights() {
        return flights;
    }

    public void setFlights(List<Flights> flights) {
        this.flights = flights;
    }
}
