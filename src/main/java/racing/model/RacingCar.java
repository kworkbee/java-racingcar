package racing.model;

public class RacingCar {

    private final RacingCarName racingCarName;
    private final Position position;
    private static final int MOVABLE_MINVALUE = 4;

    public RacingCar(String racingCarName) {
        this.racingCarName = new RacingCarName(racingCarName);
        this.position = new Position(0);
    }

    public RacingCar(String racingCarName, int position) {
        this.racingCarName = new RacingCarName(racingCarName);
        this.position = new Position(position);
    }

    /**
     * 자동차 이름을 알려주는 메서드
     */
    public String getRacingCarName() {
        return racingCarName.getRacingCarName();
    }

    /**
     * 자동차 위치를 알려주는 메서드
     */
    public Position getPosition() {
        return position;
    }

    /**
     * 자동차 위치를 이동시켜주는 메서드
     */
    public void move(int randomValue) {
        if (isForward(randomValue)) {
            position.move();
        }
    }

    /**
     * 이동 거리가 4이상인지 판단하는 메서드
     */
    public boolean isForward(int randomValue) {
        return randomValue >= MOVABLE_MINVALUE;
    }

    /**
     * 포지션이 같은지 판단하는 메서드
     */
    public Boolean isSame(Position otherCarPosition) {
        return this.position.isSame(otherCarPosition);
    }

    public Boolean isGreaterThan(RacingCar otherCar) {
        return this.position.isGreaterThan(otherCar.position);
    }
}