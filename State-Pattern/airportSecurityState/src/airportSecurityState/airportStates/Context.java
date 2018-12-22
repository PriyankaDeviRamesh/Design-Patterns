package airportSecurityState.airportStates;

import java.util.ArrayList;
import java.util.List;

import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.Results;
import airportSecurityState.util.MyLogger.DebugLevel;
import airportSecurityState.util.MyLogger;

/**
 *  This class is responsible for parsing the input file and calling the respective states each time
 **/

public class Context implements AirportContextI {
	
	FileProcessor fp;
	Results r;
	
	
	AirportStateI High_Risk;
	AirportStateI Moderate_Risk;
	AirportStateI Low_Risk;
	AirportStateI Init;
	AirportStateI state;
	
	
	int AvgTrafficPerDay;
	int AvgProhibItemsPerDay;
	
	int total_travellers = 0;
	int total_Prohib_Items = 0;
	int total_days = 0;
	
	List<String> prohibitedItems = new ArrayList<String>();
	
	
	public Context(FileProcessor fpIn, Results  rIn) {
		
		fp = fpIn;
		r = rIn;
		
		MyLogger.writeMessage ("Context class is invoked ", DebugLevel.CONTEXT);
		
		High_Risk = new HighRisk(this);
		Moderate_Risk = new ModerateRisk(this);
		Low_Risk = new LowRisk(this);
		Init = new Init(this);
		state = Init;
		
		MyLogger.writeMessage ("Context Constructor", DebugLevel.CONSTRUCTOR );
		
		
		prohibitedItems.add("GRAINS");
		prohibitedItems.add("NAILCUTTERS");
		prohibitedItems.add("PLANTS");
		prohibitedItems.add("ENDANGEREDANIMALS");	
	}
	
	public void parseFile() {
		String line = fp.readFromFile(fp.getFileName());
		while (line != null) {
			String dayCount = line.split(";")[0].split(":")[1].trim();
			String itemName = line.split(";")[1].split(":")[1].trim();
			
			if (itemName.isEmpty()) {
				throw new IllegalArgumentException("Input Does not contain item name");
			}
			
			if (dayCount.isEmpty()) {
				throw new IllegalArgumentException("Input Does not contain day count");
			}
			
			try {
				Integer.parseInt(dayCount);
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Day count should positive number");
			}
			
			
			increaseOrDecreaseSecurity(dayCount, itemName);
			
			line = fp.readFromFile(fp.getFileName()); 
		}
	}
	public void increaseOrDecreaseSecurity(String dayCount, String itemName) {
		
		
		total_days = Integer.parseInt(dayCount);
		if (isProhibitedItem(itemName)) {
			total_Prohib_Items = total_Prohib_Items + 1;
		}
		total_travellers = total_travellers + 1;
		
		this.state.increaseOrDecreaseSecurity();
		this.state.performOperation();
	}
	
	private boolean isProhibitedItem(String itemName) {
		if (prohibitedItems.contains(itemName.toUpperCase())) {
			return true;
		}
		return false;
	}

	public int getTotal_travellers() {
		return total_travellers;
	}

	public int getTotal_Prohib_Items() {
		return total_Prohib_Items;
	}

	public int getTotal_days() {
		return total_days;
	}
	
	public int getAvgTrafficPerDay() {
		return AvgTrafficPerDay;
	}

	public void setAvgTrafficPerDay(int avgTrafficPerDay) {
		AvgTrafficPerDay = avgTrafficPerDay;
	}

	public void setAvgProhibItemsPerDay(int avgProhibItemsPerDay) {
		AvgProhibItemsPerDay = avgProhibItemsPerDay;
	}

	public int getAvgProhibItemsPerDay() {
		return AvgProhibItemsPerDay;
	}
	
	public void setState(AirportStateI state) {
		this.state = state;
	}
	
	public AirportStateI getHigh_Risk() {
		return High_Risk;
	}

	public AirportStateI getModerate_Risk() {
		return Moderate_Risk;
	}

	public AirportStateI getLow_Risk() {
		return Low_Risk;
	}
	
	public Results getResult() {
		return r;
	}

	@Override
	public String toString() {
		return "Context [fp=" + fp + ", r=" + r + ", High_Risk=" + High_Risk + ", Moderate_Risk=" + Moderate_Risk
				+ ", Low_Risk=" + Low_Risk + ", Init=" + Init + ", state=" + state + ", AvgTrafficPerDay="
				+ AvgTrafficPerDay + ", AvgProhibItemsPerDay=" + AvgProhibItemsPerDay + ", total_travellers="
				+ total_travellers + ", total_Prohib_Items=" + total_Prohib_Items + ", total_days=" + total_days
				+ ", prohibitedItems=" + prohibitedItems + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + AvgProhibItemsPerDay;
		result = prime * result + AvgTrafficPerDay;
		result = prime * result + ((High_Risk == null) ? 0 : High_Risk.hashCode());
		result = prime * result + ((Init == null) ? 0 : Init.hashCode());
		result = prime * result + ((Low_Risk == null) ? 0 : Low_Risk.hashCode());
		result = prime * result + ((Moderate_Risk == null) ? 0 : Moderate_Risk.hashCode());
		result = prime * result + ((fp == null) ? 0 : fp.hashCode());
		result = prime * result + ((prohibitedItems == null) ? 0 : prohibitedItems.hashCode());
		result = prime * result + ((r == null) ? 0 : r.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + total_Prohib_Items;
		result = prime * result + total_days;
		result = prime * result + total_travellers;
		return result;
	}
	

}
