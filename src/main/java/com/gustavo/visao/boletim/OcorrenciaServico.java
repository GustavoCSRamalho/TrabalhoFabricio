package com.gustavo.visao.boletim;

import java.util.List;

public interface OcorrenciaServico<T> {

    public T salvarOcorrencia(final T ocorrencia);

    public List<T> buscarOcorrencia(final String usuario);

    public T buscarOcorrenciaPorCodigo(final Long codigo);

    public T alterarOcorrencia(final T ocorrencia);

    //
    public Boolean deletarOcorrencia(final T usuario);


}
