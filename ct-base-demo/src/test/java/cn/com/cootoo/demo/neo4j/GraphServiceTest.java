package cn.com.cootoo.demo.neo4j;

import cn.com.cootoo.CtBaseDemoApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * GraphService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>九月 11, 2019</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CtBaseDemoApplication.class})
public class GraphServiceTest {

    @Autowired
    private GraphService graphService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getLoan()
     */
    @Test
    public void testGetLoan() throws Exception {

        graphService.getLoan();
    }


} 
