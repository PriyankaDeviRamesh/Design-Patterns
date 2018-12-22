package airportSecurityState.airportStates;

import airportSecurityState.util.Results;

public interface AirportContextI {
	public void increaseOrDecreaseSecurity(String dayCount, String itemName);
	
	public int getTotal_travellers();

	public int getTotal_Prohib_Items();

	public int getTotal_days();
	
	public int getAvgTrafficPerDay();

	public void setAvgTrafficPerDay(int avgTrafficPerDay);

	public void setAvgProhibItemsPerDay(int avgProhibItemsPerDay);

	public int getAvgProhibItemsPerDay();
	
	public void setState(AirportStateI state);
	
	public AirportStateI getHigh_Risk();

	public AirportStateI getModerate_Risk();

	public AirportStateI getLow_Risk();
	
	public Results getResult();

	public void parseFile();
	
}
