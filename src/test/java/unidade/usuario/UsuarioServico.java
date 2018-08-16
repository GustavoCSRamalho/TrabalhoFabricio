package unidade.usuario;


import com.gustavo.modelo.usuario.Usuario;
import com.gustavo.dao.usuario.implementado.UsuarioServicoImplementacao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsuarioServico {


    private UsuarioServicoImplementacao usuarioServicoImplementacao;

    @Before
    public void inicializarOcorrencia() {
        this.usuarioServicoImplementacao = new UsuarioServicoImplementacao();
    }

    @After
    public void destruirOcorrencia() {
        usuarioServicoImplementacao = null;
    }

    @Test
    public void salvarUsuario() {
        Usuario ocorrencia = usuarioServicoImplementacao.salvar(new Usuario());
        Assert.assertNotNull(ocorrencia);
    }

    @Test
    public void salvarUsuarioErro() {
        Usuario ocorrencia = usuarioServicoImplementacao.salvar(null);
        Assert.assertNull(ocorrencia);
    }

    @Test
    public void buscarUsuario() {
        Usuario usuario = usuarioServicoImplementacao.buscarPorUsuario("Gustavo");
        Assert.assertNotNull(usuario);
    }

    @Test
    public void buscarUsuarioErro() {
        Usuario usuario = usuarioServicoImplementacao.buscarPorUsuario(null);
        Assert.assertNull(usuario);
    }

}
