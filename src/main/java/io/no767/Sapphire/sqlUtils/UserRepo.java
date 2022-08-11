package io.no767.Sapphire.sqlUtils;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<KumikoUser, Integer> {
    Iterable<KumikoUser> findByUserUUIDContains(String userUUID);
}
