package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestContrller {
    @Autowired
    private TestEntityDao dao;

    @GetMapping("/all")
    @ResponseBody
    @Secured("ROLE_ADMIN")
    public List<TestEntity> getAll() {
        return dao.getAll();
    }

    @GetMapping("/one")
    @ResponseBody
    @Secured("ROLE_USER")
    public TestEntity getOne() {
        return dao.get(1L);
    }
}
