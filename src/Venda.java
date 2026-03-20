import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venda {

    private Long id;
    private Cliente cliente;
    private Usuario usuario;
    private LocalDateTime data;
    private BigDecimal valorTotal;
    private List<ItemVenda> itens;

    public Venda (Cliente cliente, Usuario usuario) {
        if (!usuario.isAtivo()) {
            throw new IllegalArgumentException("Usuário inativo");
        }
        this.cliente = cliente;
        this.usuario = usuario;
        this.data = LocalDateTime.now();
        this.itens = new ArrayList<>();
        this.valorTotal = BigDecimal.ZERO;
    }

    public void adicionarItem(Estoque estoque, int quantidade) {
        if (!estoque.temDisponivel(quantidade)) {
            throw new IllegalArgumentException("Estoque insuficiente");
        }

        estoque.reduzir(quantidade);

        ItemVenda item = new ItemVenda(this, estoque.getProduto(), quantidade);
        itens.add(item);

        recalcularTotal();
    }

    private void recalcularTotal() {
        this.valorTotal = itens.stream()
                .map(ItemVenda::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

//    private void recalcularTotal() {
//        BigDecimal total = BigDecimal.ZERO;
//
//        for (ItemVenda item : itens) {
//            total = total.add(item.getSubtotal());
//        }
//
//        this.valorTotal = total;
//    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }
}
