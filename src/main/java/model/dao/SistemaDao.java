package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cadastro;
import myConnection.Conexao;

public class SistemaDao {
	private static Connection conn = null;
	private static String sql;
	private static PreparedStatement ps = null;

	public void cadastrar(Cadastro cadastro) throws ClassNotFoundException {

		sql = "INSERT INTO cadastro (nome, cpf, senha) VALUES (?, ?, ?)";

		conn = Conexao.getConexao();

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, cadastro.getNome());
			ps.setString(2, cadastro.getCpf());
			ps.setString(3, cadastro.getSenha());

			ps.executeUpdate();
			ps.close();

			System.out.println("Cadastrado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha ao cadastrar!");
		}

	}

	public List<Cadastro> logar(Cadastro loginSenha)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		try {
			sql = "SELECT * FROM cadastro WHERE nome=? and senha=?;";

			conn = Conexao.getConexao();
			ps = conn.prepareStatement(sql);

			ps.setString(1, loginSenha.getNome());
			ps.setString(2, loginSenha.getSenha());
			;

			List<Cadastro> cadastrado = new ArrayList<Cadastro>();
			ResultSet rs = ps.executeQuery();
			Cadastro cliente = new Cadastro();
			if (rs.next()) {

				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));

				cadastrado.add(cliente);

				System.out.println("Cadastro encontrado!");
				return cadastrado;
			}

			System.out.println("Ususario ou senha incorretos!");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro encontrado!");
			return null;
		}

	}
	public void alterar(Cadastro cliente) {
		
		sql = "UPDATE cadastro SET senha = ? WHERE cpf = ?";
		try {
			conn = Conexao.getConexao();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, cliente.getSenha());
			ps.setString(2, cliente.getCpf());
			
			ps.executeUpdate();
			System.out.println("Senha alterada");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao alterar senha");
		}
		
	}
}
