public class Plane extends Thread{
    private Airport airport;
    private int maxDistance;
    private int capacity;
    private City route;

    public Plane(Airport airport, int maxDistance, int capacity) throws ParametersException {
       if ((maxDistance<0)||(capacity<0))
            throw new ParametersException("Неверно введены параметры");

        this.airport=airport;
        this.maxDistance=maxDistance;
        this.capacity=capacity;
    }

    public void run() {
            try {
                while(true) {
                    Gate gate = airport.getGate(maxDistance - route.getDistance());
                    System.out.println("Самолет " + this.getRoute().getRouteID()
                            + " из " + getRoute().getCity() + " прибыл на посадку:   Terminal "
                            + gate.getGateTerminalId() + " Gate " + gate.getGateId());
                    gate.using(capacity);
                    System.out.println("\tСамолет " + this.getRoute().getRouteID()
                            + " улетает в " + getRoute().getCity() + ":   Terminal "
                            + gate.getGateTerminalId()  + " Gate " + gate.getGateId() );
                    airport.returnGate(gate);
                }
            }
            catch (ResourсeException e) {
                    System.out.println("Самолет " + this.getRoute().getRouteID()
                        + " из " + getRoute().getCity() + " пропал с радаров!!!!!!!"
                        + e.getMessage());
            }
    }

    public void setRoute(City route) {
        if ((this.getDistantZone()<route.getDistanceZone())||(maxDistance<route.getDistance()))
            System.out.println("Самолет (вместимость: "+capacity+", макс дальность: "+maxDistance
            +") не полетит в "+route.getCity());
        else{
            this.route=route;
        }
    }

    public int getDistantZone() {
        if (maxDistance<2000)
            return 1;
        else if ((maxDistance>=2000)&&(maxDistance<4000))
            return 2;
        else
            return 3;
    }

    public City getRoute() {
        return route;
    }
}
