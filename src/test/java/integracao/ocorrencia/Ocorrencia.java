package integracao.ocorrencia;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

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
    public void testeListar() throws SQLException {
        Statement estado = connection.createStatement();
        String consulta = "SELECT * FROM Ocorrencia";
        ResultSet listaDeOcorrencia = (ResultSet) estado.executeQuery(consulta);
        Assert.assertNotNull(listaDeOcorrencia);

    }

    @Test
    public void testeAtualizar(){}

    @Test
    public void testeDeletar(){}

    @Test
    public void testeCriar(){}
}
