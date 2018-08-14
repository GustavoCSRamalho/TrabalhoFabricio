package unidade.ocorrencia;


import com.gustavo.modelo.ocorrencia.Ocorrencia;
import com.gustavo.visao.boletim.implementado.OcorrenciaServicoImplementacao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import unidade.usuario.UsuarioServico;

import java.util.List;


//@RunWith(SpringJUnit4ClassRunner.class)
//@Configurable(autowire = Autowire.BY_NAME)
//@ContextConfiguration(locations = { "dispatcher-servlet.xml" })
//@Transactional
public class OcorrenciaServico {

    @Autowired
    private UsuarioServico usuarioServico;
    private OcorrenciaServicoImplementacao ocorrenciaServico;

    @Test
    public void testar() {
        Assert.assertNotNull(usuarioServico);
    }

    @Before
    public void inicializarOcorrencia() {
        this.ocorrenciaServico = new OcorrenciaServicoImplementacao();
    }

    @After
    public void destruirOcorrencia() {
        ocorrenciaServico = null;
    }

    @Test
    public void salvarOcorrencia() {
        Ocorrencia ocorrencia = ocorrenciaServico.salvarOcorrencia(new Ocorrencia());
        Assert.assertNotNull(ocorrencia);
    }

    @Test
    public void salvarOcorrenciaErro() {
        Ocorrencia ocorrencia = ocorrenciaServico.salvarOcorrencia(null);
        Assert.assertNull(ocorrencia);
    }

    @Test
    public void buscarOcorrencia() {
        List<Ocorrencia> lista = ocorrenciaServico.buscarOcorrencia("Gustavo");
        Assert.assertNotNull(lista);
    }

    @Test
    public void buscarOcorrenciaErro() {
        List<Ocorrencia> lista = ocorrenciaServico.buscarOcorrencia(null);
        Assert.assertNull(lista);
    }

    @Test
    public void buscarOcorrenciaPorCodigo() {
        Ocorrencia ocorrencia = ocorrenciaServico.buscarOcorrenciaPorCodigo((long) 21);
        Assert.assertNotNull(ocorrencia);
    }

    @Test
    public void buscarOcorrenciaPorCodigoErro() {
        Ocorrencia ocorrencia = ocorrenciaServico.buscarOcorrenciaPorCodigo(null);
        Assert.assertNull(ocorrencia);
    }

    @Test
    public void alterarOcorrencia() {
        Ocorrencia ocorrencia = ocorrenciaServico.alterarOcorrencia(new Ocorrencia());
        Assert.assertNotNull(ocorrencia);
    }

    @Test
    public void alterarOcorrenciaErro() {
        Ocorrencia ocorrencia = ocorrenciaServico.buscarOcorrenciaPorCodigo(null);
        Assert.assertNull(ocorrencia);
    }

    @Test
    public void deletarOcorrencia() {
        Boolean ocorrencia = ocorrenciaServico.deletarOcorrencia(new Ocorrencia());
        Assert.assertTrue(ocorrencia);
    }

    @Test
    public void deletarOcorrenciaErro() {
        Boolean ocorrencia = ocorrenciaServico.deletarOcorrencia(null);
        Assert.assertFalse(ocorrencia);
    }


}
