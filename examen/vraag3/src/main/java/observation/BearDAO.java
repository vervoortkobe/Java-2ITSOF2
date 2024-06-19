package observation;

public class BearDAO {
    public Bear findByName(String bearName) {
        return new Bear(bearName);
    }
}
