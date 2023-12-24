package testtechtask.service.role;

import testtechtask.model.Role;
import testtechtask.model.Role.RoleName;

public interface RoleService {
    Role getRoleByRoleName(RoleName roleName);
}
