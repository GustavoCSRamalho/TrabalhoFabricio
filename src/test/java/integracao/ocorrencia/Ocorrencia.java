package integracao.ocorrencia;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

//@RunWith(SpringJUnit4ClassRunner.class)//@ContextConfiguration(locations = {"classpath:../webapp/WEB-INF/dispatcher-servlet.xml","classpath:../webapp/WEB-INF/web.xml"})

public class Ocorrencia {

    @Autowired
    private WebApplicationContext context;


    @Test
    public void teste(){
        Assert.assertNotNull(context);
        Assert.assertEquals(0,0);
    }
}
