import com.getghoti.Role
import com.getghoti.User
import com.getghoti.UserRole

class BootStrap {

    def init = { servletContext ->
        def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)

        def adminUser = User.findByUsername('admin') ?: new User(
                username: 'admin',
                password: 'admin',
                enabled: true).save(failOnError: true)

        if (!adminUser.authorities.contains(adminRole)) {
            UserRole.create adminUser, adminRole
        }
    }
    def destroy = {
    }
}
