package zoo;

import java.time.LocalDate;

public class CareTakerFactory {
    public static CareTaker assignCareTaker(Bonobo bonobo) {
        if(bonobo.getDateOfBirth().isBefore(LocalDate.of(1999, 12, 13)))
            return new CareTaker("Hans", bonobo);
        else return new CareTaker("Erik", bonobo);
    }
}
