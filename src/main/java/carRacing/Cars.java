package carRacing;

import java.util.*;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void operate(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    public List<Car> getCarListForPrint() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> callWinners() {
        List<String> result = new ArrayList<>();
        int maxDistance = maxDistance();

        for (Car car : cars) {
            addWinnerName(result, maxDistance, car);
        }

        return result;
    }

    private void addWinnerName(List<String> result, int maxDistance, Car car) {
        if (isMaxDistance(maxDistance, car)) {
            result.add(car.getCarNameForPrint());
        }
    }

    private boolean isMaxDistance(int maxDistance, Car car) {
        return car.isSameDistance(maxDistance);
    }

    private int maxDistance() {
        int maxNumber = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxNumber = car.findLongerDistance(maxNumber);
        }
        return maxNumber;
    }


}
