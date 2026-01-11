package com.loja.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import com.loja.model.*;

import com.loja.util.ConnectionFactory;

public class ProdutoDAO {
	public void cadastrar(int codigo, String nome, String marca, double preco) {
		ConnectionFactory conectar = new ConnectionFactory();
		try {
			Connection con = conectar.conectar();
			PreparedStatement st = con.prepareStatement("INSERT INTO produto VALUES(?,?,?,?)");
			st.setInt(1, codigo);
			st.setString(2, nome);
			st.setString(3, marca);
			st.setDouble(4, preco);
			st.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Produto> listar() {
		List<Produto> produtos = new ArrayList<>();
		ConnectionFactory conectar = new ConnectionFactory();
		
		try {
			Connection con = conectar.conectar();
			PreparedStatement st = con.prepareStatement("SELECT * FROM produto");
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Produto p = new Produto();
				
				p.setCodigo(rs.getInt("codigo"));
				p.setNome(rs.getString("nome"));
				p.setMarca(rs.getString("marca"));
				p.setPreco(rs.getDouble("preco"));
				
				produtos.add(p);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtos;
	}
	
	public void excluir(int codigo) {
		ConnectionFactory conectar = new ConnectionFactory();
		try {
			Connection con = conectar.conectar();
			PreparedStatement st = con.prepareStatement("DELETE FROM produto WHERE codigo=?");
			st.setInt(1, codigo);
			st.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Produto buscarId(int codigo) {
		ConnectionFactory conectar = new ConnectionFactory();
		Produto p = null;
		
		try {
			Connection con = conectar.conectar();
			PreparedStatement st = con.prepareStatement("SELECT * FROM produto WHERE codigo=?");
			st.setInt(1, codigo);
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				p = new Produto();
				p.setCodigo(rs.getInt("codigo"));
				p.setNome(rs.getString("nome"));
				p.setMarca(rs.getString("marca"));
				p.setPreco(rs.getDouble("preco"));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public void alterar(Produto p) {
		ConnectionFactory conectar = new ConnectionFactory();
		
		try {
			Connection con = conectar.conectar();
			PreparedStatement st = con.prepareStatement("UPDATE produto SET nome=?, marca=?, preco=? WHERE codigo=?");
			
			st.setString(1, p.getNome());
			st.setString(2, p.getMarca());
			st.setDouble(3, p.getPreco());
			st.setInt(4, p.getCodigo());
			st.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Produto> buscarPorNome(String termo) {
		List<Produto> lista = new ArrayList<>();
		ConnectionFactory conectar = new ConnectionFactory();
		
		try {
			Connection con = conectar.conectar();
			PreparedStatement st = con.prepareStatement("SELECT * FROM produto WHERE nome LIKE ?");
			st.setString(1, "%" + termo + "%");
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Produto p = new Produto();
				p.setCodigo(rs.getInt("codigo"));
				p.setNome(rs.getString("nome"));
				p.setMarca(rs.getString("marca"));
				p.setPreco(rs.getDouble("preco"));
				lista.add(p);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}
