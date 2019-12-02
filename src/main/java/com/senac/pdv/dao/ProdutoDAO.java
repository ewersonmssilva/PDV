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

        
        
        //=======================================================//
        //   VendasDAO
       /* public void inserirVenda(Produto produto) {
		try (Connection conn = ConnectionPDVFactory.getConnection()) {
			String sql = "INSERT INTO vendas (id, nome, qtd, preco, desc)" +
							"VALUES (?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql); // esta pedindo para preparar a conexão
			ps.setInt(1, produto.getId()); // vai pegar o primeiro parametro ? e colocar o id por isso setInt
			ps.setString(2, produto.getNome());
                        ps.setInt(4, produto.getQuantidade());
			ps.setDouble(3, produto.getPreco());			
                        ps.setInt(5, produto.getDesconto());

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
        */
        public void create(Produto p) {

            Connection con = ConnectionPDVFactory.getConnection();

            PreparedStatement stmt = null;

            try {
                stmt = con.prepareStatement("INSERT INTO `vendas`(`id`, `id_produto`,`nome`, `qtd`, `preco`, `desc`) VALUES (?,?,?,?,?,?)");
                stmt.setInt(1, p.getId());
                stmt.setInt(2, p.getId_Produto());
                stmt.setString(3, p.getNome());
                stmt.setInt(4, p.getQuantidade());
                stmt.setDouble(5, p.getPreco());
                stmt.setInt(6, p.getDesconto());

                stmt.executeUpdate();

                //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectionPDVFactory.closeConnection(con, stmt);
            }

        }
        
        
        
        
	public Produto idVenda() {
        Connection con = ConnectionPDVFactory.getConnection();
        
        PreparedStatement stmt;
        ResultSet rs;
                try {
                        stmt = con.prepareStatement("SELECT max(id) as max_id FROM vendas");
                        rs = stmt.executeQuery();
                        Produto produto = new Produto();
                        if (rs.next()) {                                
				produto.setId(rs.getInt("max_id"));
                        }
			return produto;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

        public List<Produto> readForId(Integer id) {

        Connection con = ConnectionPDVFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE id LIKE ?");
            stmt.setString(1, "%"+id+"%");
            
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
        
        public List<Produto> lerPorIdVendas(Integer id) {

        Connection con = ConnectionPDVFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM vendas WHERE id LIKE ?");
            stmt.setString(1, "%"+id+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                //produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("qtd"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setData(rs.getString("data"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPDVFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

        } 
  
	public Produto buscaPorNom(String desc) {
		try (Connection conn = ConnectionPDVFactory.getConnection()) {
			String sql = "SELECT * FROM produto WHERE nome = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, desc);
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
        
        
}
