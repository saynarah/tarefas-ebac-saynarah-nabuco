package Dao.generic;

import domain.Persistente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class GenericDaO<T extends Persistente> implements IGeneric<T> {

        public abstract Class<T> getTipoClasse();

        protected Map<Class, Map<Long,T>> map;

        public abstract void alterarDados(T entity, T entidadeCadastrada);

        public GenericDaO() {
            this.map = new HashMap<>();
            Map<Long,T> mapaInterno = this.map.get(getTipoClasse());
            if(mapaInterno == null){
                mapaInterno = new HashMap<>();
                this.map.put(getTipoClasse(),mapaInterno);
            }
        }

        @Override
        public Boolean cadastrar(T entity) {
            Map<Long,T> mapaInterno = this.map.get(getTipoClasse());
            //Se o código da entidade já existir dentro do mapa, retorna falso
            if(mapaInterno.containsKey(entity.getCodigo())){
                return false;
            }

            mapaInterno.put(entity.getCodigo(),entity);
            return true;
        }

        @Override
        public T excluir(Long valor) {
            //Retorna o mapa dos valores da classe ativa (this)
            Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
            //Registra a entidade a partir do valor dado
            T entidadeCadastrada = mapaInterno.get(valor);

            //se a entidade existe, disponível para exclusão
            if(entidadeCadastrada != null){
                mapaInterno.remove(valor,entidadeCadastrada);
            }
            return entidadeCadastrada;
        }

        @Override
        public T alterar(T entity) {
            Map<Long,T> mapaInterno = this.map.get(getTipoClasse());
            T entidadeAlterada = mapaInterno.get(entity.getCodigo());
            if(entidadeAlterada != null){
                alterarDados(entity,entidadeAlterada);
            }
            return entidadeAlterada;
        }

        @Override
        public T consultar(Long valor) {
            Map<Long,T> mapaInterno = this.map.get(getTipoClasse());
            return mapaInterno.get(valor);
        }

        @Override
        public Collection<T> buscarTodos() {
            Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
            return mapaInterno.values();
        }
}

