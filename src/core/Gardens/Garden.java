package core.Gardens;

public class Garden {
    private int carrotWeight;
    private int carrotCount;

    public Garden(int carrotWeights, int carrotCount) {
        this.carrotWeight = carrotWeights;
        this.carrotCount = carrotCount;
    }
    public Garden(){
        this.carrotWeight = 0;
        this.carrotCount = 0;
    }

    public Integer getCarrotWeight() {
        return carrotWeight;
    }

    public Integer getCarrotCount() {
        return carrotCount;
    }
    public void setCarrotCount(int cnt) {
        this.carrotCount = cnt;
    }

    @Override
    public String toString() {
        return "Garden(carrotWeight = " + carrotWeight + "кг, carrotCount = " + carrotCount + "шт)";
    }
}
