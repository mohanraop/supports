package com.fmr.export.bean;

import java.io.Serializable;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class ExportWorkItemObj implements SQLData, Serializable{  
	static final long serialVersionUID = 4070409649129120458L;
	private String sql_type;
	private int client_Id;
	private int request_Id;
	private String workItem_Id;
	private int fims_id;
	private String clip_id;
	private String repository_cd;
	private String status;
	

	/**
	 * @return the sql_type
	 */
	public String getSql_type() {
		return sql_type;
	}

	/**
	 * @param sql_type the sql_type to set
	 */
	public void setSql_type(String sql_type) {
		this.sql_type = sql_type;
	}

	/**
	 * @return the client_Id
	 */
	public int getClient_Id() {
		return client_Id;
	}

	/**
	 * @param client_Id the client_Id to set
	 */
	public void setClient_Id(int client_Id) {
		this.client_Id = client_Id;
	}

	/**
	 * @return the request_Id
	 */
	public int getRequest_Id() {
		return request_Id;
	}

	/**
	 * @param request_Id the request_Id to set
	 */
	public void setRequest_Id(int request_Id) {
		this.request_Id = request_Id;
	}

	/**
	 * @return the workItem_Id
	 */
	public String getWorkItem_Id() {
		return workItem_Id;
	}

	/**
	 * @param workItem_Id the workItem_Id to set
	 */
	public void setWorkItem_Id(String workItem_Id) {
		this.workItem_Id = workItem_Id;
	}

	/**
	 * @return the fims_id
	 */
	public int getFims_id() {
		return fims_id;
	}

	/**
	 * @param fims_id the fims_id to set
	 */
	public void setFims_id(int fims_id) {
		this.fims_id = fims_id;
	}

	/**
	 * @return the clip_id
	 */
	public String getClip_id() {
		return clip_id;
	}

	/**
	 * @param clip_id the clip_id to set
	 */
	public void setClip_id(String clip_id) {
		this.clip_id = clip_id;
	}

	/**
	 * @return the repository_cd
	 */
	public String getRepository_cd() {
		return repository_cd;
	}

	/**
	 * @param repository_cd the repository_cd to set
	 */
	public void setRepository_cd(String repository_cd) {
		this.repository_cd = repository_cd;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getSQLTypeName() throws SQLException {
		return this.sql_type;
	}

	@Override
	public void readSQL(SQLInput stream, String typeName) throws SQLException {
		this.sql_type = typeName;
		this.client_Id = stream.readInt();
		this.request_Id = stream.readInt();
		this.workItem_Id = stream.readString();
		this.fims_id = stream.readInt();
		this.clip_id = stream.readString();
		this.repository_cd = stream.readString();
		this.status = stream.readString();
	}

	@Override
	public void writeSQL(SQLOutput stream) throws SQLException {
	    stream.writeInt(client_Id);
	    stream.writeInt(request_Id);
	    stream.writeString(workItem_Id);
	    stream.writeInt(fims_id);
	    stream.writeString(clip_id);
	    stream.writeString(repository_cd);
	    stream.writeString(status);
	} 

}
