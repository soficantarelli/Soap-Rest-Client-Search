package ar.edu.ubp.das.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ar.edu.ubp.das.beans.UrlBean;
import ar.edu.ubp.das.db.Dao;

public class MSUrlDao extends Dao<UrlBean, UrlBean>{

	@Override
	public UrlBean delete(UrlBean arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UrlBean insert(UrlBean arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UrlBean make(ResultSet result) throws SQLException {
		UrlBean url = new UrlBean();
		url.setUrl(result.getString("url"));
		url.setTags(result.getString("tags"));
		url.setFilters(result.getString("filters"));
		//url.setData(result.getString("data"));
		return url;
	}

	@Override
	public List<UrlBean> select(UrlBean arg0) throws SQLException {
		try {
			System.out.print("entre");
			this.connect();
			this.setProcedure("dbo.get_urls");
			return this.executeQuery();
		} finally {
			this.close();
		}
	}

	@Override
	public UrlBean update(UrlBean arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean valid(UrlBean arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
