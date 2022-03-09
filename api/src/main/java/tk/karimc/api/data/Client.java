package tk.karimc.api.data;

import javax.persistence.*;

@Entity
@Table
public class Client {

    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private long id;
    private String email;
    private String password;
    private int accountBalance;

    public Client(long id, String email, String password, int accountBalance) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.accountBalance = accountBalance;
    }

    public Client(String email, String password, int accountBalance) {
        this.email = email;
        this.password = password;
        this.accountBalance = accountBalance;
    }

    public Client() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
