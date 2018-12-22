package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.MyLogger.DebugLevel;

/**  This class is the Moderate_risk of the airportSecurityState. This state is called when the avgTrafficPerDay 
 * and avgProhibItemsPerDay condition for this state is met
 **/

public class ModerateRisk implements AirportStateI {

	AirportContextI context;

	public ModerateRisk(AirportContextI contextIn) {
		MyLogger.writeMessage ("ModerateRisk Constructor", DebugLevel.CONSTRUCTOR );
		context = contextIn;
	}
   
	public void increaseOrDecreaseSecurity() {
		
		MyLogger.writeMessage ("Moderate_Risk State", DebugLevel.STATES);
		
		int avgTrafficPerDay = context.getTotal_travellers() / context.getTotal_days();
		context.setAvgTrafficPerDay(avgTrafficPerDay);

		int avgProhibItemsPerDay = context.getTotal_Prohib_Items() / context.getTotal_days();
		context.setAvgProhibItemsPerDay(avgProhibItemsPerDay);

		if ((context.getAvgTrafficPerDay() >= 8) || (context.getAvgProhibItemsPerDay() >= 4)) {
			context.setState(context.getHigh_Risk());
		}
		else if ((4 <= context.getAvgTrafficPerDay() && context.getAvgTrafficPerDay() < 8 ) 
				|| (2 <= context.getAvgProhibItemsPerDay() && context.getAvgProhibItemsPerDay() < 4)) {
			context.setState(context.getModerate_Risk());
		}
		else if ( (0 <= context.getAvgTrafficPerDay() && context.getAvgTrafficPerDay() < 4 ) 
				|| (0 <= context.getAvgProhibItemsPerDay() && context.getAvgProhibItemsPerDay() < 2)) {
			context.setState(context.getLow_Risk());
		}
	}

	@Override
	public void performOperation() {
		//MyLogger.writeOutput("2 3 5 8 9");	
		context.getResult().addToResults("2 3 5 8 9");
	}

	@Override
	public String toString() {
		return "ModerateRisk [context=" + context + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		return result;
	}
	

}
