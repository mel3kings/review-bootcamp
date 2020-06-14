package refractoring;

class NewReleasePrice extends Price {
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int getFrequentRenterPoints(int daysRented, Movie movie) {
        if (daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
