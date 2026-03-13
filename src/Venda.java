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


}
