package principal;

import connect.ConnectFactory;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;





public class ProdutosDAO {
    
    private Connection con;
    
    public ProdutosDAO () {
        
        this.con = new ConnectFactory().getConnection();
      }
        
    public void  CadastrarVenda(ProdutosDTO x) {
        
        String sql = "Insert into ProdutosD(nome, valor, status)" + "values(?,?,?)";
        
        try (PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, x.getNome());
            ps.setString(2, x.getValor());
            ps.setString(3, x.getStatus());
            
            ps.execute();
            ps.close();
            
            JOptionPane.showMessageDialog(null, "Usuario Cadastrado com Sucesso!");
            
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro, Usuario Não Cadastrado!");
        }
            
        
        
        
    }  
        
    
        
}

