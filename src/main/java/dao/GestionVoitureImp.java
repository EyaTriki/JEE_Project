package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import dao.entities.Voiture;

public class GestionVoitureImp implements IGestionVoiture{

	Connection cnx = SingletonConnection.getInstance();

	@Override
	public void ajouterVoiture(Voiture v) {
		try {
			PreparedStatement ps =cnx.prepareStatement("insert into voiture(modele,carburant,prix) values(?,?,?)");
			ps.setString(1, v.getModele());
			ps.setString(2, v.getCarburant());
			ps.setDouble(3,v.getPrix());
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void supprimerVoiture(int id) {
		
		try {
			PreparedStatement ps = cnx.prepareStatement("delete from voiture where id=?");
			ps.setInt(1,id);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mettreAJourVoiture(Voiture v) {
		try {
		PreparedStatement ps = cnx.prepareStatement("update voiture set modele=?,carburant=?,prix=? where id=?");
		ps.setString(1,v.getModele());
		ps.setString(2, v.getCarburant());
		ps.setDouble(3, v.getPrix());
		ps.setInt(4, v.getId());
		ps.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Voiture> getAllVoitures() {
		List <Voiture> liste = new ArrayList<Voiture>();
		try {
			PreparedStatement ps =cnx.prepareStatement("select * from voiture");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				liste.add(new Voiture (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4)));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public List<Voiture> getVoitureBMC(String motcle) {
		List<Voiture> liste = new ArrayList<Voiture>();
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from voiture where modele like ?");
			ps.setString(1,"%" + motcle +"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				liste.add(new Voiture(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public Voiture getVoiture(int id) {
		Voiture v = new Voiture();
		try {
			PreparedStatement ps = cnx.prepareStatement("select modele,carburant,prix from voiture where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new Voiture (id,rs.getString(1),rs.getString(2),rs.getDouble(3));
			}
		}catch(SQLException e) {
			
		}
		return v;
	}

	@Override
	public List<Voiture> getVoituresByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
