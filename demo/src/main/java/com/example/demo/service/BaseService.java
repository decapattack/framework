package com.example.demo.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BaseEntity;
import com.example.demo.entity.Post;

public abstract class BaseService  <T extends BaseEntity<ID>, ID extends Serializable> {
	
	protected final String FALHA_DELETAR = "Falha ao deletar";
    protected final String FALHA_SALVAR = "Falha ao salvar";
    protected final String FALHA_CONSULTAR = "Falha ao consultar";
    protected final String FALHA_ATUALIZAR = "Falha ao atualizar";
    protected final String CAMPO_OBRIGATORIO = "Campo obrigatório não preenchido:";

    protected abstract JpaRepository<T, ID> getRepository();

    public List<T> list() {
        return getRepository().findAll();
    }

    public T save(T entity) {
        if (entity.getId() != null) {
            T consulta = getRepository().getOne(entity.getId());
            if (consulta != null) {
                //throw new RegistroExistenteException(String.format("%s, O Resgitro já existe.", FALHA_SALVAR));
            }
        }
        validation(entity);
        return getRepository().save(entity);
    }

    public T search(ID id) {
        T e = getRepository().getOne(id);
        if (e == null) {
            //throw new RegistroNaoEncontradoException(String.format("%s, O Registro não pôde ser encontrado.", FALHA_CONSULTAR));
        }
        return e;
    }

    public void delete(ID id) {
        try {
            getRepository().deleteById(id);
        } catch (Exception e) {
            //throw new RegistroNaoEncontradoException(String.format("%s, O Registro não pôde ser encontrado.", FALHA_DELETAR));
        }
    }

    public void update(T entity) {
        T consulta = getRepository().getOne(entity.getId());
        if (consulta == null) {
            //throw new RegistroNaoEncontradoException(String.format("%s, O registro não pôde ser encontrado.", FALHA_ATUALIZAR));
        }
        getRepository().save(entity);
    }
    
    public void validation(T entidade){
    }
}
