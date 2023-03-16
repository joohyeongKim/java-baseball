package baseball.controller;

import java.util.Objects;

public class BaseBall {

    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public BaseBall(Integer number) {
        this.number = number;
    }

    // equals를 재정의 하려거든 hashCode도 재정의하라
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        BaseBall baseBall = (BaseBall) obj;
        return Objects.equals(number, baseBall.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
