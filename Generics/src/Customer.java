public class Customer {
    int id;
    String firstname;

    public Customer(int id, String firstname) {
        this.id = id;
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "Customer_id:"+id+" "+"Customer_name:"+firstname;
    }
}
