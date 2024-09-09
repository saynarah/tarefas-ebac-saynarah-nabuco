package Factory;

public class ContratosFactory extends Factory{
    @Override
    Car retrieveCar(String requestedGrade) {
        if("A".equals(requestedGrade)){
            return new Corola(100,"cheio","azul");
    }
        else{
            return new Hilux(300,"cheio","prata");
        }
    }
}