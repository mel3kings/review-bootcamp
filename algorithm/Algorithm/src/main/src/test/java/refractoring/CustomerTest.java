package refractoring;


import org.junit.jupiter.api.*;

class CustomerTest {

    private Customer customer;
    private Movie movie;
    private Rental rental;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void NewReleaseStatement() {
        customer = new Customer("mel");
        movie = new Movie("title", Movie.NEW_RELEASE);
        rental = new Rental(movie,100);
        customer.addRental(rental);
        assert(customer.statement().contains("300"));
        System.out.println(customer.statement());
    }
    @Test
    void ChildrenStatement() {
        customer = new Customer("mel");
        movie = new Movie("title", Movie.CHILDRENS);
        rental = new Rental(movie,100);
        customer.addRental(rental);
        System.out.println(customer.statement());
        assert(customer.statement().contains("147"));
    }

    @Test
    void RegularStatement() {
        customer = new Customer("mel");
        movie = new Movie("title", Movie.REGULAR);
        rental = new Rental(movie,100);
        customer.addRental(rental);
        System.out.println(customer.statement());
        assert(customer.statement().contains("149"));
    }
}