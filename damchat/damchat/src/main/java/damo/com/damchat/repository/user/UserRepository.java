package damo.com.damchat.repository.user;
import damo.com.damchat.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User , String> {}
