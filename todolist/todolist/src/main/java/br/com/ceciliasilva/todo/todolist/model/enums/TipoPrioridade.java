package br.com.ceciliasilva.todo.todolist.model.enums;

public enum TipoPrioridade {
    BAIXA,
    MEDIA,
    ALTA;

    public static TipoPrioridade obterPorNumero(int numero) {
        if (numero >= 1 && numero <= values().length) {
            return values()[numero - 1];
        } else {
            throw new IllegalArgumentException("Número de prioridade inválido: " + numero);
        }
    }

    public static TipoPrioridade obterPorNome(String nome) {
        for (TipoPrioridade prioridade : values()) {
            if (prioridade.name().equalsIgnoreCase(nome)) {
                return prioridade;
            }
        }
        throw new IllegalArgumentException("Prioridade inválida: " + nome);
    }
}

