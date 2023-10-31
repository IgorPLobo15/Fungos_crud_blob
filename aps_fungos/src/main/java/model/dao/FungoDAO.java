package model.dao;

import connection.ConnectionFactory;
import static connection.ConnectionFactory.getConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Fungo;
import org.apache.commons.io.IOUtils;


public class FungoDAO {
    

    public void create(Fungo f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO fungos (id, numero, data, nome, imagem) VALUES (?, ?, ?, ?, ?)");
            stmt.setInt(1,f.getId());
            stmt.setInt(2, f.getNumero());
            stmt.setDate(3, new java.sql.Date(f.getData().getTime()));
            stmt.setString(4, f.getNome());
            
            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt);
        }
    }
    private void atualizarImagemNoBanco(int idFungo, byte[] novaImagem) {
    FungoDAO dao = new FungoDAO();
    dao.updateImagem(idFungo, novaImagem);
    }
    public void updateImagem(int id, byte[] novaImagem) {
    Connection connection = null;
    PreparedStatement statement = null;
    
    try {
        connection = getConnection(); // Implemente uma função para obter uma conexão com o banco de dados
        String sql = "UPDATE fungos SET imagem = ? WHERE id = ?";
        statement = connection.prepareStatement(sql);
        
        statement.setBytes(1, novaImagem);
        statement.setInt(2, id);
        
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } 
}

    public List<Fungo> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Fungo> fungos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM fungos");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Fungo fungo = new Fungo();
                fungo.setId(rs.getInt("id"));
                fungo.setNumero(rs.getInt("numero"));
                fungo.setData(rs.getDate("data"));
                fungo.setNome(rs.getString("nome"));
                
                fungos.add(fungo);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler dados " + ex);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return fungos;
    }

    public void update(Fungo f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
        // Defina o formato da data a ser armazenada no banco de dados
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = sdf.format(f.getData());

        stmt = con.prepareStatement("UPDATE fungos SET data = ?, nome = ? WHERE numero = ?");
        stmt.setDate(1, Date.valueOf(dataFormatada)); // Converte a data para java.sql.Date
        stmt.setString(2, f.getNome());
        
        stmt.setInt(3, f.getNumero());

        stmt.executeUpdate();

        JOptionPane.showMessageDialog(null, "Atualizado com sucesso.");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar " + ex);
    } finally {
        //ConnectionFactory.closeConnection(con, stmt);
    }
    }
    
    
    public byte[] getImagemById(int id) {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    byte[] imagemBytes = null;

    try {
        stmt = con.prepareStatement("SELECT imagem FROM fungos WHERE id = ?");
        stmt.setInt(1, id);
        rs = stmt.executeQuery();

        if (rs.next()) {
            imagemBytes = rs.getBytes("imagem");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao buscar imagem " + ex);
    } finally {
        //ConnectionFactory.closeConnection(con, stmt, rs);
    }

    return imagemBytes;
}

    public void delete(Fungo f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM fungos WHERE id = ?");
            stmt.setInt(1, f.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir " + ex);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public byte[] getImageBlobById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

