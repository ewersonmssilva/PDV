package com.senac.pdv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.senac.pdv.modelo.Produto;


public class ProdutoDAO {
	
	public void inserir(Produto produto) {
		try (Connection conn = ConnectionPDVFactory.getConnection()) {
			String sql = "INSERT INTO produto (nome, preco, quantidade)" +
							"VALUES (?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql); // esta pedindo para preparar a conexão
			//ps.setLong(1, produto.getId()); // vai pegar o primeiro parametro ? e colocar o id por isso setInt
			ps.setString(1, produto.getNome());
			ps.setDouble(2, produto.getValor());
			ps.setDouble(3, produto.getQuantidade());

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void atualizar(Produto produto) {
		try (Connection conn = ConnectionPDVFactory.getConnection()) {
			String sql = "UPDATE produto SET " +
							"nome = (?), " +
							"preco = (?), " +
							"quantidade = (?) " +
						"WHERE codigo = (?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, produto.getNome());
			ps.setDouble(2, produto.getValor());
			ps.setInt(3, produto.getQuantidade());
			ps.setInt(4, produto.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remover(int id) {
		try (Connection conn = ConnectionPDVFactory.getConnection()) {
			String sql = "DELETE FROM produto WHERE codigo = (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
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
				produto.setValor(rs.getDouble(3));
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
				produto.setValor(rs.getDouble(3));
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
			String sql = "SELECT * FROM produto WHERE codigo = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			Produto produto = new Produto();
			while(rs.next()) {
				produto.setId(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setValor(rs.getDouble(3));
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
				p.setValor(rs.getDouble(3));
				p.setQuantidade(rs.getInt(4));
				produtos.add(p);
			}
			return produtos;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return new ArrayList<>();
	}

}
