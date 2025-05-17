package amendeStrategy;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RetardRemise extends Amende{
	@Override
	public float calculAmende(LocalDate date) {
		if(LocalDate.now().isAfter(date)) {
			return ChronoUnit.DAYS.between(LocalDate.now(), date) *10;//10€
		}
		else 
			return 0;
	}

}
