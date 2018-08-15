package integracao.ocorrencia;


import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    public static String status = "Não conectou...";
//    @Autowired
//    private OcorrenciaServicoImplementacao ocorrenciaServicoImplementacao;

//    @Autowired
//    private ApplicationContext applicationContext;

    @Test
    public void teste() {
        Connection connection = null;          //atributo do tipo Connection


        try {

// Carregando o JDBC Driver padrão

            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);


// Configurando a nossa conexão com um banco de dados//

//            String serverName = "localhost";    //caminho do servidor do BD

//            String mydatabase ="mysql";        //nome do seu banco de dados

//            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String url = "jdbc:mysql://localhost:3306/egammer";
            String username = "root";        //nome de um usuário de seu BD

            String password = "password";      //sua senha de acesso

            connection = DriverManager.getConnection(url, username, password);


            //Testa sua conexão//

            if (connection != null) {

                status = ("STATUS--->Conectado com sucesso!");

            } else {

                status = ("STATUS--->Não foi possivel realizar conexão");

            }


//            return connection;


        } catch (ClassNotFoundException e) {  //Driver não encontrado


            System.out.println("O driver expecificado nao foi encontrado.");

//            return null;

        } catch (SQLException e) {

//Não conseguindo se conectar ao banco

            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

//            return null;

        }
    }
}
