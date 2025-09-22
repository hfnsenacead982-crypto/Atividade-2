

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        conn = new conectaDAO().connectDB();
String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?,?,?)";

try {
    prep = conn.prepareStatement(sql);
    prep.setString(1, produto.getNome());
    prep.setInt(2, produto.getValor());
    prep.setString(3, produto.getStatus());
    prep.execute();
    prep.close();
} catch (SQLException e) {
    System.out.println("Erro ao cadastrar: " + e.getMessage());
} finally {
    try {
        if (conn != null) {
            conn.close();
        }
    } catch (SQLException e) {
        System.out.println("Erro ao fechar conexão: " + e.getMessage());
    }
}
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

