package nmt;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public void saveUser() {
        System.out.println("Saving user...");
    }
}
