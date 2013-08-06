package support.training.hibernate.bean;



public class Shares {
 public int share_id;
 public String share_name;
 public int share_price;
 public int s_quantity;
/**
 * @return the share_name
 */
public String getShare_name() {
	return share_name;
}
/**
 * @return the share_id
 */
public int getShare_id() {
	return share_id;
}
/**
 * @param share_id the share_id to set
 */
public void setShare_id(int share_id) {
	this.share_id = share_id;
}
/**
 * @param share_name the share_name to set
 */
public void setShare_name(String share_name) {
	this.share_name = share_name;
}
/**
 * @return the share_price
 */
public int getShare_price() {
	return share_price;
}
/**
 * @param share_price the share_price to set
 */
public void setShare_price(int share_price) {
	this.share_price = share_price;
}
/**
 * @return the s_quantity
 */
public int getS_quantity() {
	return s_quantity;
}
/**
 * @param s_quantity the s_quantity to set
 */
public void setS_quantity(int s_quantity) {
	this.s_quantity = s_quantity;
}
 
}
