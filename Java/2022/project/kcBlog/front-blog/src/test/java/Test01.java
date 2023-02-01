import com.kc.KcBlogApplication;
import com.kc.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;

@SpringBootTest(classes = KcBlogApplication.class)
class Test01 {

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Test
    public void tt() {
        System.out.println(securityConfig);
        System.out.println(authenticationManager);
    }
}