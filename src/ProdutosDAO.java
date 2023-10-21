/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public ProdutosDAO() {
        this.conn = new conectaDAO().connectDB();
    }

                    public void cadastrarProduto(ProdutosDTO p) {
                        String sql = "insert into ProdutosD(nome, valor, status)" + "values(?,?,?)";
                        try {
                            ps = conn.prepareStatement(sql);
                            ps.setString(1, p.getNome());
                            ps.setInt(2, p.getValor());
                            ps.setString(3, p.getStatus());
                            ps.execute();
                            ps.close();

                            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!!!");
                            {
                            }
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Produto Não cadastrado");
                        }
                    }

    public ArrayList<ProdutosDTO> listarProdutos() {
        try {
            String sql = "select * from ProdutosD";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ProdutosDTO pro = new ProdutosDTO();
                pro.setId(rs.getInt("id"));
                pro.setNome(rs.getString("nome"));
                pro.setValor(rs.getInt("valor"));
                pro.setStatus(rs.getString("status"));

                listagem.add(pro);
            }
            return listagem;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o Banco de Dados");
            return null;
        }
    }

    public void venderProduto(int numeroId) {
        try {
            String sql = "UPDATE ProdutosD SET status = 'Vendido' WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, numeroId);

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Produto vendido com sucesso!");
            } else {
                System.out.println("Produto com o ID " + numeroId + " não encontrado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o Banco de Dados");
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutosVendidos() {
        try {
            String sql = "select * from ProdutosD WHERE status = 'Vendido'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ProdutosDTO pro = new ProdutosDTO();
                pro.setId(rs.getInt("id"));
                pro.setNome(rs.getString("nome"));
                pro.setValor(rs.getInt("valor"));
                pro.setStatus(rs.getString("status"));

                listagem.add(pro);
            }
            return listagem;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o Banco de Dados");
            return null;
        }
    }

}
