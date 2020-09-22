package lu.smarthome.housemanager;

import io.vavr.control.Try;
import org.junit.jupiter.api.Test;

class HouseManagerApplicationTests {

    @Test
    void contextLoads() {

    }

    private Try<Customer> getCustomer() {
        return getUser()
                .mapTry(this::parseUser)
                .map(user -> new Customer(user.getName()));
    }

    private Try<User> getUser() {
        return Try.of(User::new);
    }

    private User parseUser(User user) throws Exception {
        throw new Exception();
    }

}

class Customer {
    private String name;

    public Customer(String name) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}