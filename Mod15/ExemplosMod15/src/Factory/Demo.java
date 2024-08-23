package Factory;

public class Demo {

    public static  void main(String[] args){
        Customer customerOne = new Customer("B",false);
        Factory factory = getCarFactory(customerOne);
        Car carOne = factory.create(customerOne.getGradeRequest());
        carOne.startEngine();
    }



    private static Factory getCarFactory(Customer customer) {
        if (customer.hasCompanyContract()) {
            return new ContratosFactory();
        } else {
            return new SemContratosFactory();
        }
    }

}
