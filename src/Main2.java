import controller.VendaController;
import model.Cliente;
import model.Estoque;
import model.Produto;
import model.Usuario;
import service.VendaService;

import java.math.BigDecimal;

public class Main2 {
    public static void main(String[] args) {
        VendaService vendaService = new VendaService();
        VendaController vendaController = new VendaController(vendaService);

        Usuario usuario = new Usuario(1L, "Admin", "admin", "123", true);
        Cliente cliente = new Cliente(1L, "João", "9999-9999");

        Produto produto = new Produto(1L, "Bola", "Bola futebol",
                new BigDecimal("100.00"));

        Estoque estoque = new Estoque(1L, produto, 10);

        vendaController.registrarVenda(cliente, usuario, estoque, 2);
    }
}
