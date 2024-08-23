package Factory;

public class SemContratosFactory extends Factory{
    @Override
    Car retrieveCar(String requestedGrade) {
        if("A".equals(requestedGrade)){
            return new Brasilia(100,"cheio","amarelo");
        }
        else{
            return new Fusca(200,"meio-cheio","branco");
        }
    }
}
