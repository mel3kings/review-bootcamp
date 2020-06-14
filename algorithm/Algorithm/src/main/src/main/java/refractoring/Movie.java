package refractoring;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String _title;
    private Price _price;

    public Movie(String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return get_price().getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                set_price(new RegularPrice());
                break;
            case CHILDRENS:
                set_price(new ChildrenPrice());
                break;
            case NEW_RELEASE:
                set_price(new NewReleasePrice());
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public String getTitle() {
        return _title;
    }

    public Price get_price() {
        return _price;
    }

    public void set_price(Price _price) {
        this._price = _price;
    }

    ;

}