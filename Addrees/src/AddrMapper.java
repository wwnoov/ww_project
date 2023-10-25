import java.util.ArrayList;

public interface AddrMapper {
	
	public ArrayList<Addr> getAddresses();
	public void insertAddress(Addr addr);
	public void updateAddress(Addr addr);
	public void deleteAddress(int id);
}
