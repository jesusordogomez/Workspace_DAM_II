package Super;

import java.time.LocalDate;

public interface IesAlimento {
	public void setCaducidad(LocalDate fc); 
	public LocalDate getCaducidad(); 
	public int getCalorias(); 
}
