package br.com.emotional.persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.sql.Date;

import br.com.emotional.entidade.Usuario;


public class UsuarioDAO extends Dao {
	public void salvarUsuario(Usuario usuario) throws Exception {
		open(); 
		
		String sql = "INSERT INTO Usuario (nome, login, email, senha, foto, data_nascimento, Premium, ativo, cpf, tipoUsuario)" +
				 " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		//Connection conn = null; 
		PreparedStatement pstm = null;
		
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getLogin());
			pstm.setString(3, usuario.getEmail());
			pstm.setString(4, usuario.getSenha());
			pstm.setString(5, usuario.getImagem());
			pstm.setDate(6, new java.sql.Date(
                    Calendar.getInstance().getTimeInMillis()));
			pstm.setBoolean(7, usuario.Premium());
			pstm.setBoolean(8, true);
			pstm.setString(9, usuario.getCpf());
			pstm.setString(10, usuario.getTipoUsuario()); 
			
			pstm.execute(); 
		}
		catch(Exception e) {
			 e.printStackTrace();			
		}
		finally{
			 try{
				 if(pstm != null){
				 
				 pstm.close();
				 }
				 
				 if(con != null){
				 con.close();
				 }
				 
				 }catch(Exception e){
				 
				 e.printStackTrace();
				 }
		
	}
}
	
	public void atualizarUsuario(Usuario usuario) throws Exception {
		open(); 
		
		String sql = "UPDATE USUARIO SET NOME = ?, login = ?, EMAIL = ?,"
				+ " SENHA = ?, FOTO = ?, data_nascimento = ? , Premium = ?, ATIVO = ?, cpf = ?, tipoUsuario = ? WHERE id_usu = ?";
				
				
		PreparedStatement pstm = null;
		
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getLogin());
			pstm.setString(3, usuario.getEmail());
			pstm.setString(4, usuario.getSenha());
			pstm.setString(5, usuario.getImagem());
			pstm.setDate(6, new java.sql.Date(
                    Calendar.getInstance().getTimeInMillis()));
			pstm.setBoolean(7, usuario.Premium());
			pstm.setBoolean(8, usuario.isAtivo());
			pstm.setString(9, usuario.getCpf());
			pstm.setString(10, usuario.getTipoUsuario());
			pstm.setInt(11, usuario.getid_usu());

			
			pstm.executeUpdate(); 
		}
		catch(Exception e) {
			 e.printStackTrace();			
		}
		finally{
			 try{
				 if(pstm != null){
				 
				 pstm.close();
				 }
				 
				 if(con != null){
				 con.close();
				 }
				 
				 }catch(Exception e){
				 
				 e.printStackTrace();
				 }
		
	}
		
	} 
	
	
	
	public void excluirUsuario(Usuario usuario) throws Exception {
		open(); 
		
		String sql = "DELETE FROM USUARIO WHERE id_usu = ?"; 
		
		PreparedStatement pstm = null;
		
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, usuario.getid_usu());
			
			pstm.execute(); 
		}
		catch(Exception e) {
			 e.printStackTrace();			
		}
		finally{
			 try{
				 if(pstm != null){
				 
				 pstm.close();
				 }
				 
				 if(con != null){
				 con.close();
				 }
				 
				 }catch(Exception e){
				 
				 e.printStackTrace();
				 }
		
	}
		
	}
	
	//Buscar o Usu�rio pelo ID 
	public Usuario buscaPorCodigo(Usuario usuario) throws Exception {
		open(); 
		
		String sql = "SELECT * FROM USUARIO WHERE id_usu = ?"; 
		
		PreparedStatement pstm = null;
		
		
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, usuario.getid_usu());
			
			ResultSet rs =  pstm.executeQuery(); 
		
			Usuario us = null; 
			if(rs.next()) {
				us = new Usuario(); 
				us.setLogin(rs.getString("login"));
				us.setAtivo(rs.getBoolean("ATIVO"));
				//us.setdata_nascimento(rs.getDate("data_nascimento");
				us.setEmail(rs.getString("EMAIL"));
				us.setid_emocao(rs.getInt("id_emocao"));
				us.setImagem(rs.getString("FOTO"));
				us.setNome(rs.getString("NOME"));
				us.setPremium(rs.getBoolean("Premium"));
				us.setid_usu(rs.getInt("id_usu"));
				us.setCpf(rs.getString("CPF"));
				us.setCpf(rs.getString("CPF"));
				us.setTipoUsuario(rs.getString("tipoUsuario"));
			}
			return us; 
				
	}
	
	//Trazer o email do usu�rio buscando pelo ID
	public int getIdPorEmail(String email) throws Exception {
		open(); 
		
		String sql = "SELECT id_usu FROM USUARIO WHERE EMAIL = ?"; 
		
		PreparedStatement pstm = null;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, email);
			
			ResultSet rs = pstm.executeQuery(); 
		}

	catch(Exception e){
   e.printStackTrace();
   
}
		pstm.close();
        con.close();
		int codigo = rs.getInt("id_usu"); 
		return codigo; 
	}
	
	public void bloquearDesbloquearUsuario(Usuario usuario) throws Exception {
		open(); 
		
		//Se est� Ativo, bloqueia o usu�rio
		if(usuario.isAtivo()) {
			String sql = "UPDATE USUARIO SET ATIVO = FALSE WHERE id_usu = ?";	
			
			PreparedStatement pstm = null;
			try {
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, usuario.getid_usu());
			
			pstm.executeUpdate(); 
			}
			catch(Exception e) {
				 e.printStackTrace();			
			}
			finally{
				 try{
					 if(pstm != null){
					 
					 pstm.close();
					 }
					 
					 if(con != null){
					 con.close();
					 }
					 
					 }catch(Exception e){
					 
					 e.printStackTrace();
					 }
			
		}
			
		}
		
		//Se est� inativo, desbloqueia
		else {
			String sql = "UPDATE USUARIO SET ATIVO = TRUE WHERE id_usu = ?";	
			
			PreparedStatement pstm = null;
			
			try {
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, usuario.getid_usu());
			
			pstm.executeUpdate(); 
			}
			catch(Exception e) {
				 e.printStackTrace();			
			}
			finally{
				 try{
					 if(pstm != null){
					 
					 pstm.close();
					 }
					 
					 if(con != null){
					 con.close();
					 }
					 
					 }catch(Exception e){
					 
					 e.printStackTrace();
					 }
			
		}
		}
		
	}
	
	public static void main(String[] args) {
		
	}
}
