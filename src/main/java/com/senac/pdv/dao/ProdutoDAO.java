package com.senac.pdv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.senac.pdv.modelo.Produto;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ProdutoDAO {
	
	public void inserir(Produto produto) {
		try (Connection conn = ConnectionPDVFactory.getConnection()) {
			String sql = "INSERT INTO produto (nome, preco, qtd)" +
							"VALUES (?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql); // esta pedindo para preparar a conexão
			//ps.setLong(1, produto.getId()); // vai pegar o primeiro parametro ? e colocar o id por isso setInt
			ps.setString(1, produto.getNome());
			ps.setDouble(2, produto.getPreco());
			ps.setDouble(3, produto.getQuantidade());

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void atualizar(Produto produto) {
                Connection con = ConnectionPDVFactory.getConnection();

                PreparedStatement stmt = null;

                try {
                    stmt = con.prepareStatement("UPDATE produto SET nome = ? ,qtd = ?,preco = ? WHERE id = ?");
                    stmt.setString(1, produto.getNome());
                    stmt.setInt(2, produto.getQuantidade());
                    stmt.setDouble(3, produto.getPreco());
                    stmt.setInt(4, produto.getId());

                    stmt.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
                } finally {
                    ConnectionPDVFactory.closeConnection(con, stmt);
                }
	}
	
	public void remover(Produto produto) {
                Connection con = ConnectionPDVFactory.getConnection();

                PreparedStatement stmt = null;

                try {
                    stmt = con.prepareStatement("DELETE FROM produto WHERE id = ?");
                    stmt.setInt(1, produto.getId());

                    stmt.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
                } finally {
                    ConnectionPDVFactory.closeConnection(con, stmt);
                }
	}
	
	
	public List<Produto> listar() {
		try (Connection conn = ConnectionPDVFactory.getConnection()) {
			String sql = "SELECT * FROM produto";

			ResultSet rs = conn
					.prepareStatement(sql)
					.executeQuery();

			List<Produto> produtos = new ArrayList<>();
			while(rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setPreco(rs.getDouble(3));
				produto.setQuantidade(rs.getInt(4));
				produtos.add(produto);
			}
			return produtos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Produto> buscaPorNome(String nome) {
		try (Connection conn = ConnectionPDVFactory.getConnection()) {
			String sql = "SELECT * FROM produto WHERE nome LIKE (?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+nome+"%");
			ResultSet rs = ps.executeQuery(); 

			List<Produto> produtos = new ArrayList<>();
			while(rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setPreco(rs.getDouble(3));
				produto.setQuantidade(rs.getInt(4));
				produtos.add(produto);
			}
			
			return produtos;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Produto buscaPorCodigo(int id) {
		try (Connection conn = ConnectionPDVFactory.getConnection()) {
			String sql = "SELECT * FROM produto WHERE id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			Produto produto = new Produto();
			while(rs.next()) {
				produto.setId(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setPreco(rs.getDouble(3));
				produto.setQuantidade(rs.getInt(4));
			}
			return produto;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Produto> buscaPreco(double preco, boolean opcao) {
		try (Connection conn = ConnectionPDVFactory.getConnection()) {
			String sql;
			if(opcao) {
				sql = "SELECT * FROM produto WHERE preco > ?  ";
			} else {
				sql = "SELECT * FROM produto WHERE preco < ? ";
			}
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, preco);
			ResultSet rs = ps.executeQuery();

			List<Produto> produtos = new ArrayList<>();
			while(rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt(1));
				p.setNome(rs.getString(2));
				p.setPreco(rs.getDouble(3));
				p.setQuantidade(rs.getInt(4));
				produtos.add(p);
			}
			return produtos;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}
        
        public List<Produto> read() {

        Connection con = ConnectionPDVFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("qtd"));
                produto.setPreco(rs.getDouble("preco"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPDVFactory.closeConnection(con, stmt, rs);
        }

        return produtos;
        }
        
        public List<Produto> readForDesc(String desc) {

        Connection con = ConnectionPDVFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE nome LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("qtd"));
                produto.setPreco(rs.getDouble("preco"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPDVFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

        }

}
