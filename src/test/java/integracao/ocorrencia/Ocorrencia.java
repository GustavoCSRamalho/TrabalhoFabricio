package integracao.ocorrencia;


import org.junit.*;
import org.junit.runners.MethodSorters;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)//@ContextConfiguration(locations = {"classpath:../webapp/WEB-INF/dispatcher-servlet.xml","classpath:../webapp/WEB-INF/web.xml"})

//@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({ "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })//@ContextConfiguration(classes = LogarControler.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:../../../src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration//@ContextConfiguration(classes={OcorrenciaServico.class,OcorrenciaServicoImplementacao.class})
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Ocorrencia {

//    @Autowired
//    private OcorrenciaServico ocorrenciaServico;

    private static Connection connection = null;
    public static String status = "Não conectou...";

    @BeforeClass
    public static void iniciarVariaveis(){
        //atributo do tipo Connection
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            String url = "jdbc:mysql://localhost:3306/egammer";
            String username = "root";        //nome de um usuário de seu BD
            String password = "password";      //sua senha de acesso
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }
        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
        }
    }

    @AfterClass
    public static void fecharConeccao() throws SQLException{
//        connection.commit();
        connection.close();
    }


    @Test
    public void teste2Listar() throws SQLException {
        Statement estado = connection.createStatement();
        String consulta = "SELECT * FROM Ocorrencia where Ocorrencia.oc_codigo=1000";
        ResultSet listaDeOcorrencia = (ResultSet) estado.executeQuery(consulta);
        System.out.println("2");
        Assert.assertNotNull(listaDeOcorrencia);

    }

    @Test
    public void teste3Atualizar() throws SQLException{
        Statement estado = connection.createStatement();
        String consulta = "UPDATE Ocorrencia SET Ocorrencia.oc_tipo ='Deu ruim' WHERE Ocorrencia.oc_codigo=1000";
        estado.executeUpdate(consulta);
        System.out.println("3");
    }

    @Test
    public void teste4Deletar() throws SQLException{
        Statement estado = connection.createStatement();
        String consulta = "DELETE FROM Ocorrencia where Ocorrencia.oc_codigo=1000";
        estado.executeUpdate(consulta);
        System.out.println("4");
    }

    @Test
    public void teste1Criar() throws SQLException{
//        Statement estado = connection.createStatement();
//        String consulta = "INSERT INTO Ocorrencia(oc_codigo,oc_tipo,oc_descricao,oc_usuario) VALUES(1000,'Demencia','Muito louco','Douglas')";
//        estado.executeUpdate(consulta);
        System.out.println("1");
    }
}
