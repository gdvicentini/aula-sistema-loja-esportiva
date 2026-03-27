import model.*;

void main() {
    Usuario usuario = new Usuario(1L, "Admin", "admin", "123", true);
    Cliente cliente = new Cliente(1L, "João", "9999-9999");

    Produto produto = new Produto(1L, "Bola", "Bola de futebol",
            new BigDecimal("100.00"));

    Estoque estoque = new Estoque(1L, produto, 10);

    Venda venda = new Venda(cliente, usuario);

    int quantidade = 2;

    if (estoque.temDisponivel(quantidade)) {
//        venda.adicionarItem(estoque, quantidade);
        estoque.reduzir(quantidade);
    } else {
        System.out.println("model.Estoque insuficiente");
    }

    System.out.println("Total da venda: " + venda.getValorTotal());
    System.out.println("model.Estoque restante: " + estoque.getQuantidadeDisponivel());
}
