package testtechtask.repository.role;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import testtechtask.model.Role;
import testtechtask.model.Role.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByRoleName(RoleName roleName);
}
