function logar() {
    usuario = document.getElementById("us_usuario").value;
    senha = document.getElementById("us_senha").value;
    console.log(usuario);
    console.log(senha);

    $.post("/logar?us_usuario=" + usuario + "&us_senha=" + senha,function () {
        window.location.href="/principal";
    });

}

function registrar() {
    usuario = document.getElementById("us_usuario").value;
    senha = document.getElementById("us_senha").value;

    $.post("/registrar?us_usuario=" + usuario + "&us_senha=" + senha,function () {
        window.location.href="/";
    });
}

function cadastrar() {
    tipo = document.getElementById("tipo").value;
    descricao = document.getElementById("descricao").value;
    telefone1 = document.getElementById("telefone1").value;
    telefone2 = document.getElementById("telefone2").value;

    $.post("/cadastro?descricao=" + descricao+ "&tipo=" + tipo+"&telefone1="+telefone1+"&telefone2="+telefone2,function () {
        window.location.href = "/principal";
    });
}


function atualizar(codigo) {
    $.get("/atualizar?codigo="+codigo,function () {
        window.location.href = "/atualizar?codigo="+codigo;
    });
}